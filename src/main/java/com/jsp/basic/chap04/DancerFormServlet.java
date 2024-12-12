package com.jsp.basic.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/v1/register")
public class DancerFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 비즈니스 로직 처리
        System.out.println("댄서 폼 열어줘!!!");

        // html은 jsp가 잘하니까 시켜버리자
        // 뷰 포워딩: jsp파일을 찾아서 열어주는 개념
        RequestDispatcher dispatcher
            = req.getRequestDispatcher("/WEB-INF/chap04/dancer/register.jsp");

        dispatcher.forward(req, resp);

    }
}

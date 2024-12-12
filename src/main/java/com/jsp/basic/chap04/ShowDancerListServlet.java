package com.jsp.basic.chap04;

import com.jsp.basic.chap02.Dancer;
import com.jsp.basic.chap02.DancerList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc/v1/show")
public class ShowDancerListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Dancer> dancerList = DancerList.getDancerList();

        // jsp에게 dancerList를 전달
        req.setAttribute("dancers", dancerList);

        // jsp로 포워딩
        RequestDispatcher dispatcher
            = req.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp");
        dispatcher.forward(req, resp);
    }
}

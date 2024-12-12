package com.jsp.basic.chap04;

import com.jsp.basic.chap02.DancerList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/v1/remove")
public class DancerRemoveServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제 요청이 들어옴!");
        // 클라이언트가 보낸 아이디를 읽음
        String id = req.getParameter("id");
        int index = Integer.parseInt(id);
        System.out.println("index = " + index);
        // 실제로 댄서리스트에서 삭제요청한 댄서를 제거해야 함.
        DancerList.removeDancer(index);

        // 새로운 삭제가 완료된 목록을 재요청
        resp.sendRedirect("/mvc/v1/show");
    }
}

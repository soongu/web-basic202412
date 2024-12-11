package com.jsp.basic.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

// 역할: HTTP 통신의 요청과 응답을 손쉽게 처리하는 클래스
// URL 매핑 : 어떤 요청이 들어올 때 이 클래스가 작동할 것인지
@WebServlet("/basic")
public class BasicServlet extends HttpServlet {

    // 생성자 : 톰캣이 이 객체를 생성
    public BasicServlet() {
        System.out.println("/basic 요청이 들어옴!");
    }

    // 요청이 들어오면 해야 할 일 : 비즈니스 로직
    // service메서드는 HTTP요청과 응답을 실질적으로 처리함
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("비즈니스 로직 실행!!!");

        // HTTP 요청을 분석해서 클라이언트가 뭘 원하는지 이해하고
        // 로직을 수행해야 함.
        String method = req.getMethod(); // 요청 방식
        System.out.println("method = " + method);

        // 요청 헤더 분석
        String header = req.getHeader("Cache-Control");
        System.out.println("header = " + header);

        // 쿼리 스트링 읽기
        // ?name=kim&age=10&grade=F
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        String age = req.getParameter("age");
        System.out.println("age = " + age);

        String grade = req.getParameter("grade");
        System.out.println("grade = " + grade);

        // 서버의 응답 처리
        // 핵심 로직: 나이를 기반으로 출생연도를 구해야 함
        //            학점이 F학점이면 재수강, 아니면 패스

        // 출생연도 구하기
        int birthYear = 0;

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // HTML을 자바코드로 써내려감
        PrintWriter w = resp.getWriter();

        try {
            birthYear = LocalDate.now().getYear() - Integer.parseInt(age) + 1;
            System.out.println("birthYear = " + birthYear);
        } catch (NumberFormatException e) {
            resp.setStatus(400);
            w.write("<h1>나이는 숫자로 제발좀~~~</h1>");
            return;
        }

        // 재수강 여부 메시지 구하기
        String message = grade.equals("F")
                ? "재수강 대상자 입니다."
                : "통과했습니다.";

        System.out.println("message = " + message);

        // 응답 HTTP 메시지 생성
        resp.setStatus(200); // 상태코드 전송

        w.write("<!DOCTYPE html>");
        w.write("<html lang=\"ko\">");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("   \t<h1>\n");
        w.write(String.format("%s님은 %d년생입니다.", name, birthYear));
        w.write("   </h1>\n");
        w.write("<h2>" + message + "</h2>");
        w.write("</body>\n");
        w.write("</html>");

    }
}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.jsp.basic.chap02.*" %>

<%
  String name = request.getParameter("name");
  String crewName = request.getParameter("crewName");
  String danceLevel = request.getParameter("danceLevel");
  String[] genres = request.getParameterValues("genres");

  List<Genre> genreList = new ArrayList<>();
  for (String g : genres) {
      genreList.add(Genre.valueOf(g));
  }

  Dancer dancer = new Dancer(
        name, crewName, DanceLevel.valueOf(danceLevel), genreList
  );

  DancerList.addDancer(dancer);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h1> <%= dancer.getName() %>님이 등록되었습니다.</h1>
  <a href="/chap03/dancer/show-list.jsp">댄서 목록 모아보기</a>
</body>
</html>
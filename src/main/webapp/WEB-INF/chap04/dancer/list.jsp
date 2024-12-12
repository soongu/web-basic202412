<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .del-btn {
        padding: 5px 10px;
        outline: none;
        border: none;
        background: red;
        border-radius: 10px;
        color: #fff;
        margin-left: 10px;
        margin-bottom: 10px;
        cursor: pointer;
    }
    .del-btn:hover {
        border: 1px solid orange;
        opacity: 0.8;
    }
</style>
</head>
<body>
  <h1>MVC 댄서 정보 목록</h1>
  <ul id="dancer-list">
    <!-- for (Dancer d : dancers) -->
    <c:forEach var="d" items="${dancers}">
      <li>
        # 이름: <span class="dancer-name">${d.name}</span>,
        # 크루명: ${d.crewName},
        # 수준: ${d.danceLevel}
        <button class="del-btn">삭제</button>
      </li>
    </c:forEach>
  </ul>

  <a href="/mvc/v1/register">다시 등록하기</a>

  <script>
    // li태그들에게 인덱스 부여하기
    [...document.querySelectorAll('li')].forEach(($li, i) => {
      $li.dataset.index = i;
    });

    const $dancerList = document.getElementById('dancer-list');
    $dancerList.addEventListener('click', e => {
      if (!e.target.matches('.del-btn')) return;

      // console.log('click: ', e.target);

      const $targetLi = e.target.closest('li');
      // console.log($targetLi);

      const index = $targetLi.dataset.index;
      console.log(index);
      

      // 삭제 요청 보내기
      window.location.href='/mvc/v1/remove?id=' + index;

    });
  </script>

</body>
</html>
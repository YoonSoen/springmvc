<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>List</title>
</head>
<body>
 
<h2> 게시글 목록 </h2>
 
<button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button>
 
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>No</th>
            <th>Subject</th>
            <th>Writer</th>
            <th>Date</th>
        </tr>
          <c:forEach var="l" items="${list}">
              <tr onclick="location.href='/detail/${l.no}'">
                  <td>${l.no}</td>
                  <td>${l.title}</td>
                  <td>${l.writer}</td>
                  <td>${l.regdate}</td>
              </tr>
          </c:forEach>
          
    </table>
</div>
 
 
<%@ include file="design.jsp" %>
</body>
</html>



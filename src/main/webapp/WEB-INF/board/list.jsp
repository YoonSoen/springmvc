<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
<style>
	table{border-collapse: collapse;}
	table, td, th{border:1px solid black;}
	span.brelevel{font-size:7px;color:red;}
</style>
</head>
<body>

<table style="width:500px;">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	
	
	<c:forEach var="Board" items="${list}"> 
	<tr>
		
		<td>${board.no}</td> 
		<td>${board.writer}</td> 
		<td>
			
			<a href="content.do?num=${board.no}">${board.title}</a>
		</td> 
		<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td> 
		<td>${board.viewcnt}</td> 
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>

</body>
</html>
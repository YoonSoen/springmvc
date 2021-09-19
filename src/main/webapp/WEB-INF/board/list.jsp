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
		<td>날짜</td>
		<td>조회수</td>
	</tr>
	
	
	<c:forEach var="Board" items="${list}"> 
	<tr>
		
		<td>${Board.num}</td> 
		<td>${Board.writer}</td> 
		<td>
			
			<c:forEach begin="1" end="${Board.relevel}"><span class="relevel">[re]</span></c:forEach>
			<a href="content.do?num=${Board.num}">${Board.Subject}</a>
		</td> 
		<td><fmt:formatDate value="${Board.date}" pattern="yyyy-MM-dd" /></td> 
		<td>${Board.readcount}</td> 
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>

</body>
</html>
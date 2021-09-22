<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>content_view</title>
</head>
<body>

	<form action="modify.do" method="post">
		<table style="width:500px;">
			<%-- bIdx hidden --%>
			<input type="hidden" name="no" value="${board.no}" />
			
			<tr>
				<td>번호</td>
				<td>${board.no}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${board.viewcnt}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" value="${board.writer}"></td>	
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${board.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;
					<a href="list.do">목록보기</a>&nbsp;&nbsp;
					<a href="delete.do?no=${board.no}">삭제</a>&nbsp;&nbsp;
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>
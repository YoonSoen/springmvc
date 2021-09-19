<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>reply_view</title>
</head>
<body>

	<form action="reply.do" method="post">
		<table style="width:500px;">
			
			<%-- ReplyViewCommand --%>
			<input type="hidden" name="num" value="${reply.num}">
			<input type="hidden" name="ref" value="${reply.ref}">
			<input type="hidden" name="restep" value="${reply.restep}">
			<input type="hidden" name="relevel" value="${reply.relevel}">
		
			<tr>
				<%-- 고유번호/수정불가 --%>
				<td>번호</td>
				<td>${reply.num}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${reply.readcount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="Writer" value="${reply.writer}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="Subject" value="${reply.subject}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea row="10" name="Content">${reply.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="답변"> <a href="list.do">목록</a></td>
			</tr>
		</table>
	</form>

</body>
</html>
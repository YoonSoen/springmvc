<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write</title>
</head>
<body>

<form action="write.do" method="post">
	<table style="width:500px;">
		<tr>
			<td>이름</td>
			<td><input type="text" name="writer" size="50"></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" size="50"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><textarea name="content" row="10"></textarea></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="입력">&nbsp;&nbsp;<a href="list.do">목록보기</a></td>
		</tr>
		
	</table>
</form>

</body>
</html>
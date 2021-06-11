<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증 구현</title>
</head>
<body>
	<form action="auth.do" method="post">
		<label>아이디: <input type="text" name="userId" required></label>
		<label>비밀번호 : <input type="password" name="pwd"></label>
		<label>이메일 : <input type="email" name="email" required></label>
		<input type="submit" value="인증하기">
	</form>
	<p>${msg}</p>
</body>
</html>
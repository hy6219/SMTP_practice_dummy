<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증처리 로직</title>
</head>
<body>
	<header><h1>회원 정보 처리 과정</h1></header>
	<section>
		<article>
			<form action="authProcess.do" method="post">
			<p>입력하신 아이디, 비밀번호, 이메일 정보는 아래와 같습니다. 아래의 이메일로 전송된 인증코드를 입력해주세요</p>
			<label>아이디: <input type="text" name="userId" value="${onProcess.userId }" readonly></label>
			<label>비밀번호: <input type="text" name="pwd" value="${onProcess.pwd }" readonly></label>
			<label>이메일: <input type="text" name="email" value="${onProcess.email }" readonly></label>
			<label>인증코드: <input type="text" name="confirmCode" required></label>
			<input type="submit" value="인증 확인하기">
			</form>
		</article>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<style>
		label {
			display : inline-block;
			width : 100px;
			height : 30px;
		}
	</style>
</head>
<body>
	<%--개인정보를 전송하므로 url에 노출되지 않도록 request body 영역에 파라미터를 전송 ( POST 방식 ) --%>
	<form action="<%=request.getContextPath() %>/loginController" method="post">
		<label>user id : </label><input type="text" name="userid"><br>
		<label>user id : </label><input type="text" name="userid"><br>
		<label>password : </label><input type="password" name="password"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>
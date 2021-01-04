<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
</head>
<body>
	<h2>scope.jsp</h2>
	<form action="<%=request.getContextPath() %>/scope" method="post">
		<input type="text" name = "scope">
		<input type="submit" value="전송">
	</form>
</body>
</html>
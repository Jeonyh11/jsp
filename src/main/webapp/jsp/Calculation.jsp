<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>sumCalculation</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sumCalculation" method="post">
		<input type="text" name = "start"> 에서 <input type="text" name = "end"> 까지의 합 구하기
		<input type="submit" value = "결과">
	</form>
	<br><br>
	<form action="<%=request.getContextPath() %>/mulCalculation" method="post">
		<input type="text" name="param1"> * <input type="text" name="param2"> 
		<input type="submit" value = "결과">
	</form>
</body>
</html>
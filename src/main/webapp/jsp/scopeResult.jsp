<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>scopeResult</title>
	<style>
		td {
			width : 150px;
			height : 30px;
			text-align : center;
		}
		
	</style>
</head>
<body>
	<h2>Result.jsp</h2>
	<table border="1">
		<tr>
			<th>속성명</th>
			<th>속성값</th>
		</tr>
		<tr>
			<td>request</td> 
			<td><%=request.getAttribute("request") %></td>
		</tr>
		<tr>
			<td>session</td>
			<td> <%=session.getAttribute("session") %></td>
		</tr>
		<tr>
			<td>application</td> 
			<td><%=application.getAttribute("application") %></td>
		</tr>
	</table>
</body>
</html>
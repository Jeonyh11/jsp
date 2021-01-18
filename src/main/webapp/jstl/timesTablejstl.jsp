<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		td {
			width:130px;	
			height:50px;	
			text-align:center;	
		}
	</style>
</head>
<body>
	표현식, 스크립틀릿을 EL, JSTL로 변경
	<table border = "1">
	
	<c:forEach begin="1" end="9" var="i">
		<tr>
			<c:forEach begin="2" end="9" var="j">
				<td> ${j } * ${i } = ${j*i } </td>
			</c:forEach>		
		</tr>
	</c:forEach>
	
<%-- 	<% --%>
<!--  	for(int i = 1; i <= 9; i++) { -->
<%-- 	%> --%>
<!-- 		<tr> -->
<%-- 		<% --%>
<!--  			for(int j = 2; j <= 9; j++) { -->
<%-- 		%> --%>
<%-- 			<td><%=j %> * <%=i %> = <%=j*i %></td> --%>
<%-- 		<% --%>
<!--  			} -->
<%-- 		%> --%>
<!-- 		</tr> -->
<%-- 	<% --%>
<!--  	} -->
<%-- 	%> --%>
	</table>
	
	<br><hr><br>
	
	<table border = "1">
	<%
	for(int i = 1; i <= 9; i++) {
		out.write("<tr>");
			for(int j = 2; j <= 9; j++) {
			out.write("<td>");
				out.write(j + " * " + i + " = " + j*i);
			out.write("</td>");
			}
		out.write("</tr>");
	}
	%>
	</table>
	
</body>
</html>
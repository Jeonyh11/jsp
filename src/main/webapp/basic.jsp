<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% Date date = new Date(); %> <%--스크립틀릿 : 자바 코드를 작성 --%>
	Hello, World <%=date %> <%--표현식 : 문자열 출력 --%>
</body>
</html>
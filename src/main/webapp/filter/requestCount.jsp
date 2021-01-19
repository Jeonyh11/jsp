<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- application 영역에 저장된 requestCountMap 객체를 forEach를 통해 tr 태그로 생성
			uri 반복 횟수
	 --%>
	 
	 <table>
	 	<tr>
	 		<th>uri</th>
	 		<th>반복횟숫</th>
	 	</tr>
	 	<c:forEach items="${requestCountMap }" var="entry">
	 	
	 	<tr>
	 		<td>${entry.key }</td>
	 		<td>${entry.value }</td>
	 	</tr>
	 		 	
	 	</c:forEach>
	 	
	 	
	 </table>
</body>
</html>
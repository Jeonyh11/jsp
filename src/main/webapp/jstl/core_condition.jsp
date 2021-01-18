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
	<h3>if</h3>
	<c:set var ="userid" value ="brown"></c:set>

	<%-- java
			if() ==> test속성에 검사할 조건식을 기술 
				 userid 속성의 값이 brown인지 체크하고 brown일 때 화면에 userid 출력
				 
		1. test 속성 안에 조건을 기술 할때는 el표현식 안에 기술해야 한다.		 
			${userid } == 'brown'  X
			${userid == 'brown'}   O
			
		2.test 속성 안에 공백을 넣으면 정상적으로 판단되지 않음
			<c:if test ="${userid == 'brown'} ">  X
			<c:if test ="${userid == 'brown'}">  O
	
	<%
		if((String)pageContext.getAttribute("userid")).equals("brown"){
			out.write(pageContext.getAttribute("userid"));
			}
	%>
	--%>
	
	<%
		if( ((String)pageContext.getAttribute("userid")).equals("brown")){
			out.write("userid 스크립틀릿"+(String)pageContext.getAttribute("userid"));
			}
	%>
	
	<c:if test="${userid } == 'brown' ">
		틀린 예 :userid : ${userid } <br>
	
	</c:if>
	
	<c:if test="${userid == 'brown' }">  <%-- <c:if test="${userid == 'brown' } "> } 뒤에 공백이 있으면 안됨--%>
		올바른 예 :userid : ${userid } <br>
		
	<h3> choose : 일반 if, else if, else</h3>
	<c:choose>
		<c:when test="${userid == 'sally' }"> sally 사용자 입니다.</c:when>
		<c:when test="${userid == 'moon' }"> moon 사용자 입니다.</c:when>
		<c:when test="${userid == 'brown' }"> brown 사용자 입니다.</c:when>
		<c:otherwise>when 절에 매칭되는 조건이 없습니다.</c:otherwise>
	</c:choose>
	<br>
	</c:if>
</body>
</html>
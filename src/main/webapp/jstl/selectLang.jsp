<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
$(function(){
	$("select").on("change", function(){
		$("form").submit();
	})
	//$("select").val("${param.lang}");  //==> $("select").val(en)
	$("select").val("${param.lang}");  //==> $("select").val("en")
	
// 	var language = $("#select option:selected").text();
	
})
</script>
</head>
<body>
param : [${param.lang }]
<!-- 전송을 위해서 name을 설정 -->
<form action ="${pageContext.request.contextPath }/jstl/selectLang.jsp">
<select id="select" name="lang">
	<option value="ko">한국어</option>
	
	<option value="en" >English</option>
	<option value="ja" >日本語</option>
	<option value="etc" >기타</option>
<%-- 	<c:if test="${param.lang == 'etc'}"> selected </c:if> --%>
</select>
<input type ="submit" value="전송">
</form>
<br><br>
<%-- select box로 설정한 언어로 GREETTING, LANG 값을 표현 
	 select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정 --%>
<fmt:setLocale value="${param.lang }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/>	<br>
	<fmt:message key="GREETTING">
		<fmt:param value ="brown"/>
	</fmt:message> <br>
</fmt:bundle>
</body>
</html>
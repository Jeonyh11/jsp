<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//컨트롤러에서 조회된 데이터를 request에 저장 했다라는 가정
		UserVo userVo = new UserVo();
		userVo.setUserid("brown");
		userVo.setUsernm("브라운");
		userVo.setAlias("괌");
		
		request.setAttribute("userVo",userVo);
	%>
	
	<%-- view --%>
	<h3>표현식 : userVo</h3>
	 userVo : <%=request.getAttribute("userVo") %><br>
	 userVo.getUserid() : <%=((UserVo)request.getAttribute("userVo")).getUserid() %> <br>
	 
	 <h3>el - userVo</h3>
	 userVo : ${userVo} <br>
	 userVo.getUserid() : ${userVo.userid } / ${userVo.getUserid() } <br>
	 
	 
	 <%
	 	Map<String, String> map = new HashMap<String, String>();
	 	map.put("userid", "brown");
	 	map.put("usernm", "브라운");
	 	map.put("alias", "곰");
	 	
	 	request.setAttribute("map", map);
	 %>
	 
	 <h3>map - expression</h3>
	 map : <%=map %> <br>
	 map.get("userid") : <%=map.get("userid") %><br>
	 
	 <h3>map - EL</h3>
	 map : ${map} <br>
	 map.get("userid") : ${map.userid} <br>
	 
	 
	 <h3>산술 연산</h3>
	 ${5 + 5 }  
	 
	 
</body>
</html>
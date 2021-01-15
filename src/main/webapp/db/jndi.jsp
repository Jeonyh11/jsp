<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
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
		//import : java naming
		//서버에 등록된 자원을 요청할 때 사용하는 객체
		InitialContext context = new InitialContext();
		
		//자원의 이름을 가지고 요청을 한다. 서버에 등록된 커넥션 풀 자원 요청
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB");
		
		
	
		//시작
		long startTime = System.currentTimeMillis();
		
		//커넥션을 데이터 소스로 부터 얻고 반환 하는 반복작업
		for(int i =0; i < 30; i++){
// 		Connection의 import 는 java sql , getConnection() 파라미터값이 없는것
		Connection connection = ds.getConnection();
		connection.close();
		
		}
		//종료 (작업 시간 확인)
		long endTime = System.currentTimeMillis();
		out.print("duration" + (endTime-startTime));
	%>
</body>
</html>
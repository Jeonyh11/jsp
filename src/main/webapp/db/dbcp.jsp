<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
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
// 		initDBCP.java 에서 설정한 bs로 가져온다
		BasicDataSource bs =  (BasicDataSource)application.getAttribute("bs");
	
		//시작
		long startTime = System.currentTimeMillis();
		
		//커넥션을 데이터 소스로 부터 얻고 반환 하는 반복작업
		for(int i =0; i < 30; i++){
// 		Connection의 import 는 java sql , getConnection() 파라미터값이 없는것
		Connection connection = bs.getConnection();
		connection.close();
		
		}
		//종료 (작업 시간 확인)
		long endTime = System.currentTimeMillis();
		out.print("duration" + (endTime-startTime));
	
	%>
</body>
</html>
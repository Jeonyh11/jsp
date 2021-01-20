<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- enctype="multipart/form-data" encoding 타입을 정한다 파일이 한개가 아니다. 여러개를 봐야한다라고 말한 것 -->
	<form action ="${cp }/fileupload" method="post" enctype="multipart/form-data">
		userid : <input type ="text" name="userid" value="brown"> <br>
				 <input type="file" name ="file" /><br>
		<input type ="submit" value ="전송"/>
	</form>
</body>
</html>
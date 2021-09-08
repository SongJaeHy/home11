<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BMI측정을 시작합니다.</h1>
	<form action="/bmi" method="post">
		키 : <input type="number" name="height" placeholder="키(cm)"/><br/>
		몸무게 : <input type="number" name="weight" placeholder="체중(kg)"><br/>
		<input type="submit" value="제출하기">
		
		
		
	</form>
</body>
</html>
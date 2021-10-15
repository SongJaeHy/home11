<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사진 등록 페이지</h1>
	<form action="/photo/create" method="post">
	사진번호:<input type="text" name="p_num"><br/>
	사진:<input type='file' name='uploadFile' multiple><br/>
	사진 제목:<input type="text" name="p_cate_name"><br/>
	사진 날짜:<input type="date" name="p_date">
		<input type="submit" value="제출" />
	</form>
</body>
</html>
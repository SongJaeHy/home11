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
	<h1>사진 수정창</h1>
	${vo }
	<form action="/photo/update" method="post">
	<input type="hidden" name="p_num" value="${vo.p_num }">
	사진 이름: <input type="text" name="p_cate_name" value="${vo.p_cate_name}">
	사진 수정: <input type="file" name="p_image1" value="${vo.p_image1 }">
	
	<input type="submit" value="수정">
	</form>
</body>
</html>
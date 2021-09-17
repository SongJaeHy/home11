<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${vo.bno}번 글 수정 페이지</h1>
	${vo }
	<form action="/board/modify" method="post">	
	<input type="hidden" name="bno" value="${vo.bno }" />
		제목:<input type="text" name="title" value="${vo.title }";> <br/>
		본문:<textarea rows="10" cols="50" name="content">${vo.content }</textarea><br/>
		글쓴이:<input type="text" name="writer" value="${vo.writer }"readonly><br/>
		<input type="submit" class="btn btn-primary" value="제출">
		<input type="reset" class="btn btn-danger" value="초기화">
	</form>
</body>
</html>
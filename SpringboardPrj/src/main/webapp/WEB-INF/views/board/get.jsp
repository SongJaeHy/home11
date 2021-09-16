<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상세 페이지 조회</h2>
	글번호 : ${vo.bno}<br/>
	글제목 : ${vo.title }<br/>
	글본문 : ${vo.content }<br/>
	글쓴이 : ${vo.writer }<br/>
	쓴날짜 : ${vo.regdate } / 최종수정날짜 : ${vo.updatedate }<br/>
	<a href="/board/list">목록으로</a>
	
</body>
</html>
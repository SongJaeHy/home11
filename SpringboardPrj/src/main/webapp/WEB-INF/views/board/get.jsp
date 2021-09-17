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
	<a href="/board/list"><button>목록으로</button></a>
	
	<!-- 글 삭제용 버튼 
	글 삭제가 되면, 리스트페이지로 넘어가는데, 삭제로 넘어오는 경우는
	alert()창을 띄워서 "글이 삭제되었습니다" 가 출력되도록 로직을 짜주세요.-->
	<form action="/board/remove" method="post">
		<input type="hidden" name="bno" value="${vo.bno }">
		<input type="submit" value="삭제">
	</form>
	<!-- 수정페이지로 넘어가는 버튼을 추가해주세요. -->
	<form action="/board/boardmodify" method="post">
		<input type="hidden" name="bno" value="${vo.bno }">
		<input type="submit" value="수정">
	
	</form>
</body>
</html>
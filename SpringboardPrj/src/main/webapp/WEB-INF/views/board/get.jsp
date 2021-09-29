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
	<a href="/board/list?pageNum=${param.pageNum }&searchType=${param.searchType }&keyword=${param.keyword}"><button>목록으로</button></a>
	<%-- pageNum, searchType, keyword 들어오는지 여부 디버깅 
	EL의 ${param.파라미터명}을 이용해 확인가능
	get 파라미터에 SearchType,를 선언해서 처리해도 되지만
	pageNum, searchType, keyword가 DB와 얀계된 작업을 하지 않으므로
	굳이 두 군데를 고치지 않고 get.jsp에서 바로 받아 쓸 수 있도록
	아래와 같이 활용하는게 효울적입니다.--%>
	페이지번호: ${param.pageNum}<br>
	검색조건: ${param.searchType }<br>
	키워드: ${param.keyword }
	
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
		<input type="hidden" name="pageNum" value="${param.pageNum }" />
		<input type="hidden" name="searchType" value="${param.searchType }" />
		<input type="hidden" name="keyword" value="${param.keyword }" />
		<input type="submit" value="수정">
	
	</form>
</body>
</html>
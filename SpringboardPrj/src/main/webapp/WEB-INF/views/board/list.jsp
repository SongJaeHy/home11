<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 class="text text-primary">게시물 목록</h1>
	<table class="table table-success table-striped">
	<tread>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>최종수정일</th>
		</tr>
	</tread>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bno }</td>
				<td><a href="/board/get?bno=${board.bno}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regdate }</td>
				<td>${board.updatedate }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/board/register"><button type="button" class="btn btn-success">글쓰기</button></a>
	<form action="/board/list" method="get">
		<input type="text" name="keyword" placeholder="검색어" value="${keyword }">
		<input type="submit" value="검색하기">
	</form>
	<script>
		// 컨트롤러에서 success라는 이름으로 날린 자료가 들어오는지 확인
		// 그냥 list페이지 접근시는 success를 날려주지 않아서
		// 아무것도 들어오지 않고
		// remove 로직의 결과로 넘어왔을때만 데이터가 전달됨
		var result = "${success}";
		var bno = "${bno}";
		
		if(result === "success"){
			alert(bno + "번글이 삭제되었습니다.");
		}
	</script>
	
</body>
</html>
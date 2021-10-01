<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Ajax 테스트</h2>
	
	<ul id="replies">
	</ul>
	<!--  jquery는 이곳에 -->
	<script src="https://ajax.gooleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		var bno =23;
		
		$.getJSON("/replies/all/" + bno, function(data){
			console.log(data.length);
		});
	
	</script>
</body>
</html>
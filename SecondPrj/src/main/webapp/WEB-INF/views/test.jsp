<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form name="fileForm" action="requestupload1" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="text" name="src" />
        <input type="submit" value="전송" />
    </form>
</body>
</html>
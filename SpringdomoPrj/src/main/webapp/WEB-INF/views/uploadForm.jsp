<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form action="uploadFormAction" method="post" enctype="multipart/form-data">
	<label>아이디:</label>
    <input type="text" name="u_id"><br>
	<label>이름:</label>
    <input type="text" name="u_name"><br>
	사진 번호 : <input type="number" name="p_num"><br>
	<input type='file' name='uploadFile' multiple>
	<input type="submit" value="등록">
	<button type="button" class="kboard-button-action kboard-button-like" onclick="kboard_document_like(this)" data-uid="<?php echo $content->uid?>" title="<?php echo __('Like', 'kboard')?>"><img src="<?php echo $skin_path?>/images/하트" alt=""> <span class="kboard-document-like-count"><?php echo intval($content->like)?></span></button>
	<a href="javascript:void(0);" class="like-icon" id="likeBtn" data-chuserid="claeotls" data-prgid="62543630"><i></i><img src="image/하트.jpg">0</a>
	</form>
	<a href="/main"><button>메인 페이지로</button></a>

</body>
</html>
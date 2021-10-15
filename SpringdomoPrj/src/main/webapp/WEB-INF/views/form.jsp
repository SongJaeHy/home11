<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<form id="ajaxform" enctype = "multipart/form-data">
			<input type="file" multiple id="photo_upload">
			<output id="list"></output>
			<input type="button" value="완료" id="files_send">
		</form>
	</div>
</body>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">

	$("#files_send").click(function(){
		var formData = new FormData();
		var temp = $("#photo_upload")[0].files[0];
		console.log(temp);
		
		  for(var i=0; i<$('#photo_upload')[0].files.length; i++){
			  formData.append('uploadFile', $('#photo_upload')[0].files[i]);
		  }
		  for (var key of formData.keys()) {
			  console.log(key);

			}
		  
			$.ajax({
				type : "POST",
				url : "/data/uploadImage",
		        processData: false,
		        contentType: false,
				data : formData,
				success : function(data) {
					alert('업로드 성공')

				},
				error : function(xhr, status, error) {
					alert(error);
				}
			});
		
	});

</script>
</html>
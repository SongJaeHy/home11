<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload with Ajax</h1>
	
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	
	<div class='uploadResult'>
		<ul>
			<!-- 업로드된 파일이 들어갈 자리 -->
		</ul>
	</div>
	
	<button id="uploadBtn">Upload</button>

	<script>
		$(document).ready(function(){
			
			// 정규표현식으로 파링ㄹ 확장자, 용량 거르기
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5mb
			
			function checkExtension(fileName, fileSize){
				if(fileSize >= maxSize){
					alert("파일 사이즈 초과");
					return false;
				}
				
				if(regex.test(fileName)){
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}
			
			var cloneObj = $(".uploadDiv").clone();
			
			$('#uploadBtn').on("click", function(e){
				
				// ajax는 제출번튼을 눌렀을때 목적지가 없기 때문에
				// 빈 폼을 만들고 거기에 정보를 채워나갑니다.
				var formData = new FormData();
				
				var inputFile = $("input[name='uploadFile']");
				
				console.log(inputFile)
				var files = inputFile[0].files;
				
				console.log(files);
				
				// 파일 데이터를 폼에 집어넣기
				for(var i =0; i< files.length; i++){
					// 폼에 넣기 전에 검사부터
					
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					formData.append("uploadFile", files[i]);
				}
				console.log("폼데이터");
				console.log(formData);
				
				var uploadResult = $(".uploadResult ul");
				
				function showUploadedFile(uploadResultArr){
					var str = "";
					
					$(uploadResultArr).each(function(i, obj){
						
						str += "<li>" + obj.fileName + "</li>"
					});
					
					uploadResult.append(str);
				}
				$.ajax({
					url: '/uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType: 'json',
					success: function(result){
						alert("Uploaded");
						console.log(result);
						
						showUploadedFile(result);
						
						$(".uploadDiv").html(cloneObj.html());
					}
				}); // end ajax
			});
		});
	
	</script>
</body>
</html>
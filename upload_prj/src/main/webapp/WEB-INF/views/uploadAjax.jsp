<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.uploadResult{
		width:100%;
		background-color : gray;
	}
	.uploadResult ul {
		display:flex;
		flex-flow:row;
		justify-content:center;
		align-items: center;
		}
	.uploadResult ul li {
	list-style: none;
	padding: 10px;
	}
	.uploadResult ul li img{
		width: 20px;
		}

</style>
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
			
			// 업로드시 파일 선택을 초기화시키기 위해 미리 비어있는
			// .uploadDiv를 깊은복사로 복사해둠
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
				
				$.ajax({
					url: '/uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType: 'json', // 입력시 json으로 콘솔에, 안입력하면 xml로 콘솔에찍힘
					success: function(result){
						console.log(result); // 내가 업로드한 파일 내역이 콘솔에 찍히나 디버깅
						alert("Uploaded");
						
						// 업로드된 그림파일 목록을 ul내부에 리스트로 입력
						showUploadedFile(result);
						
						// 세팅되어있던 파일이 업로드되면서 목록에서 사라지게 처리
						$(".uploadDiv").html(cloneObj.html());
					}
				}); // end ajax
			}); //onclick uploadBtn
			
			var uploadResult = $(".uploadResult ul");
			
			function showUploadedFile(uploadResultArr){
				var str = "";
				
				// i는 인덱스번호(0,1,2...) obj 그림 파일 정보가 담긴 json
				$(uploadResultArr).each(function(i, obj){
					if(!obj.image){
						// 그림이 아니면 썸네일대신 resources폴더 내 이미지를 대체로 보여줌
						var fileCallPath = encodeURIComponent(
								obj.uploadPath + "/"
								+ obj.uuid + "_" + obj.fileName);
						
						str +="<li><a href='/download?fileName=" + fileCallPath 
								+"'>" + "<img src='/resources/attachment.png'>"
								+ obj.fileName + "</a>"
								+"<span data-file=\'"+fileCallPath + "\' data-type='file'> X </span>"
								+"</li>";
						+obj.fileName + "</li>";
					} else{
					//str += "<li>" + obj.fileName + "</li>"
					// 수정 코드
					// 파일이름 + 썸네일을 보여주기 위해 썸네일 주소 요청하게 만들긴
					var fileCallPath = encodeURIComponent(obj.uploadPath 
							+ "/s_" + obj.uuid + "_" +  obj.fileName);
					var fileCallPath2 = encodeURIComponent(obj.uploadPath 
							+ "/_" + obj.uuid + "_" +  obj.fileName);
					
					
					// 원래 그냥 fileCallPath를 조립해서
					str += "<li><a href='download?fileName=" + fileCallPath2 +
							"'>" + "<img src='/display?fileName="+fileCallPath+"'>"
							+ obj.fileName + "</a>"
							+"<span data-file=\'"+fileCallPath + "\' data-type='image'>X</span>"
							+ "</li>";
					}
				});
				
				uploadResult.append(str);
			}// showUploadedFile
			
		$(".uploadResult").on("click", "span", function(e){
			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			
			var targetLi = $(this).closest("li");
			
			console.log(e);
			$.ajax({
				url: '/deleteFile',
				data: {fileName: targetFile, type:type},
				dataType: 'text',
				type: 'POST',
				success: function(result){
					alert(result);
					targetLi.remove();
				}
			}); // ajax
		}); // click span
	}); //document
	

	</script>
</body>
</html>
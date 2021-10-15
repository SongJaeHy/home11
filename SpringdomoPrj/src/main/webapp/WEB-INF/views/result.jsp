<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<style>
$red: #ff3252;

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  margin: 0;
}

.like-button {
  display: inline-block;
  position: relative;
  font-size: 32px;
  cursor: pointer;
  // border: 1px solid black;
  &::before {
    font-size: 3em;
    color: #000;
    content: '♥';
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
  &::after {
    font-size: 3em;
    color: $red;
    content: '♥';
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%) scale(0);
    transition: transform 0.2s;
  }
  &.liked::after {
    transform: translate(-50%, -50%) scale(1.1);
  }
}

</style>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>업로드가 완료되었습니다.</h1>
	<label>아이디:</label>
	 <input type="text" name="id" value="${map.id }" readonly><br>
	<label>이름:</label>
	 <input type="text" name="name" value="${map.name }" readonly><br>
	<div class="result-images">
	  <c:forEach var="imageFileName" items="${ map.fileList}"  >
	         <%-- <img src="${pageContext.request.contextPath }/download?imageFileName=${imageFileName }" style="width:150px"> --%>
	         <img src="${pageContext.request.contextPath }/download?imageFileName=${imageFileName }">
	         <br><br><br>
	  </c:forEach>         
	</div><p> 
	
	<a href='${pageContext.request.contextPath }/form'> 다시 업로드 하기 </a> </p>
	
	<div class="w3-border w3-padding">댓글</div>
			 <div class="w3-border w3-padding">
				<c:if test="${ id == null }">
					<textarea rows="5" cols="50" class="w3-input w3-border newLogin">로그인 후 댓글 달기</textarea>
				</c:if>
				<c:if test="${ id != null }">
					<i class="fa fa-user w3-padding-16"></i> ${ photo.u_id }
					<form action="uploadForm.jsp">
						<input type="hidden" name="no" id="p_num" value="${ photo_content.p_num }"> 
						<input type="hidden" name="id" id="u_id" value="${ id }">
						<textarea rows="5" cols="50" class="w3-input w3-border" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>
						<input type="button" class="w3-button w3-border" id="reply_btn" value="댓글 등록">
					</form>
				</c:if>
			</div> 
			<button class="like-button"></button>
		<script>
		document.querySelector('.like-button').addEventListener('click', (e) => 
		{
			  e.currentTarget.classList.toggle('liked');
		});</script>
			<!-- 라이브리 시티 설치 코드 -->
	<div id="lv-container" data-id="city" data-uid="MTAyMC81NDQ3My8zMDk0NA==">
	<script type="text/javascript">
	   (function(d, s) {
	       var j, e = d.getElementsByTagName(s)[0];
	
	       if (typeof LivereTower === 'function') { return; }
	
	       j = d.createElement(s);
	       j.src = 'https://cdn-city.livere.com/js/embed.dist.js';
	       j.async = true;
	
	       e.parentNode.insertBefore(j, e);
	   })(document, 'script');
	</script>
	<noscript>라이브리 댓글 작성을 위해 JavaScript를 활성화 해주세요</noscript>
	</div>
	<!-- 시티 설치 코드 끝 -->
	<script>		
			 $("#reply_btn").click(function(){
	    	if($("#reply_content").val().trim() === ""){
	    		alert("댓글을 입력하세요.");
	    		$("#reply_content").val("").focus();
	    	}else{
	    		$.ajax({
	    			url: "/views/uploadForm.jsp",
	                type: "POST",
	                data: {
	                    p_num : $("#p_num").val(),
	                    u_id : $("#u_id").val(),
	                    p_comment_content : $("#p_comment_contentt").val()
	                },
	                success: function () {
	                	alert("댓글 등록 완료");
	                	$("#p_comment_content").val("");
	                	getReply();
	                },
	    		})
	    	}
	    })
	</script>
</body>
</html>
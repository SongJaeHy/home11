<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#modDiv {
		width : 300px;
		height: 100px;
		background-color : green;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-top: -50px;
		margin-left: -150px;
		padding: 10px;
		z-index: 1000;
	}
</style>
</head>
<body>
	<h2>Ajax 테스트</h2>
	
	<div>
		<div>
			REPLYER <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			REPLY <input type="text" name="replyer" id="newReply">
		</div>
		<button id="replyAddBtn">리플 추가</button>
	</div>

	<ul id="replies">
	
	</ul>
	
	<!-- 모달 요소는 안 보이기 때문에 어디 넣어도 되지만 보통 html요소들 끼리 놨을때
	제일 아래쪽에 작성하는 경우가 많습니다. -->
	<div id="modDiv" style="display:none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">수정</button>
			<button type="button" id="replyDelBtn">삭제</button>
			<button type="button" id="closeBtn">닫기</button>
		</div>
	</div>
	<!--  jquery는 이곳에 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- 코드는 위에서 아래로 실행되므로 ajax스크립트 태그는 맨 아래에 -->
	<script>
		var bno = 23;
		
		// 비동기 코드
		// 글 쓰기
		$("#replyAddBtn").on("click", function(){
			var replyer = $("#newReplyWriter").val();
			var reply = $("#newReply").val();
			console.log("클릭됨");
			$.ajax({
				type : 'post',
				url : '/replies/',
				headers: {
					"Content-Type": "application/json",
					"X-HTTP-Method-Override":"POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno,
					replyer : replyer,
					reply : reply
				}),
				success : function(result){
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						// 댓글 쓰고 나서 다시 새롭게 갱신된 목록을
						// 넣어주도록 전체 댓글 목록 다시 조회
						getAllList();
					}
				}
			})
		});
		
		// 글 삭제 로직
		$("#replyDelBtn").on("click", function(){
			// 삭제에 필요한 댓글번호 모달 타이틀 부분에서 얻기
			var rno = $(".modal-title").html();
			
			$.ajax({
				type : 'delete',
				url : '/replies/' + rno,
				// 전달 데이터가 없이 url과 호출타입만으로 삭제처리하므로
				// 이외 정보는 제공할 필요가 없음
				success : function(result){
					console.log("result:" + result);
					if(result === 'SUCCESS'){
						alert(rno + "번 댓글이 삭제되었습니다.");
						// 댓글 삭제 후 모달창 닫고 새 댓글목록 갱신
						$("#modDiv").hide("slow")
						// 댓글 쓰고 나서 다시 새롭게 갱신된 목록을
						// 넣어주도록 전체 댓글 목록 다시 조회
						getAllList();
					}
				}
			})
		});
		
		// 글 수정 로직
		$("#replyModBtn").on("click", function(){
			// rno(수정에 필요한 댓글번호 모달 타이틀 부분에서 얻기)
			var rno = $(".modal-title").html();
			// 수정에 필요한 본문내역을 #reply의 value값으로 얻기
			var reply = $("#replytext").val();
			console.log(reply);
			$.ajax({
				type : 'patch',
				url : '/replies/' + rno,
				headers: {
					"Content-Type": "application/json",
					"X-HTTP-Method-Override":"PATCH"
				},
				dataType : 'text',
				data : JSON.stringify({reply:reply}),
				success : function(result){
					if(result === 'SUCCESS'){
						alert(rno + "번 댓글이 수정되었습니다.");
						// 댓글 삭제 후 모달창 닫고 새 댓글목록 갱신
						$("#modDiv").hide("slow")
						// 댓글 쓰고 나서 다시 새롭게 갱신된 목록을
						// 넣어주도록 전체 댓글 목록 다시 조회
						getAllList();
					}
				}
			})
		});
		// 이벤트 위임
		// 내가 현재 이벤트를 걸려는 집단(button) 을 포함하면서 범위가 제일 좁은
		// #replies로 시작조건을 잡습니다.
		// .on("click", "목적지 태그까지 요소들", function(){실행문})
		// 과 같이 위임시는 파라미터가 3개 들어갑니다.
		$("#replies").on("click", ".replyLi button", function(){
			// this는 최 하위태그인 button, button의 부모면 결국 .replyLi
			var replyLi = $(this).parent();
			
			// .attr("속성명") 을 하면 해당 속성의 값을 얻습니다.
			var rno = replyLi.attr("data-rno");
			var reply = replyLi.text(); // li태그 글씨만 얻기.
			
			// 클릭한 버튼에 해당하는 댓글번호 + 본문이 얻어지나 디버깅
			console.log(rno + ":" + reply);
			
			// 모달 열리도록 수정
			$(".modal-title").html(rno); // 모달 상단에 댓글번호 넣기
			$("#replytext").val(reply);// 모달 수정창에 댓글본문 넣기
			$("#modDiv").show("slow");// 창에 애니메이션 효과 넣기
		})
		function getAllList(){
		$.getJSON("/replies/all/" + bno, function(data){
			//data 변수가 바로 얻어온 json데이터의 집합
			console.log(data.length);
			
			// str 변수 내부에 문자 형태로 html 코드를 작성함
			var str = "";
			
		
			/// #replies의 ul태그 내부에 str을 끼워넣음
			// ul 내우베 <li>12</li> 를 축하나는 구문.
			
			$(data).each(function(){
				str += "<li data-rno='" + this.rno + "' class='replyLi'>"			
			+ this.rno + ":" + this.reply
			+ "<button>수정/삭제</button></li>";	
			});
			$("#replies").html(str);
		});
	}
	getAllList(); 
	
	
	
	</script>
</body>
</html>
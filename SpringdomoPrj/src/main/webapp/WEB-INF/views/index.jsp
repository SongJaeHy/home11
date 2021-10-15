<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
#form-commentInfo{ width: 100%; }
 #comment-count{ margin-bottom: 10px; }
  #comment-input{ width: 50%; height: 3.3em; } 
  #submit{ background-color: rgb(0, 128,255); 
  width: 5.5em;
   height: 3.3em;; 
   font-size: 15px; 
   font-weight: bold;
    color: aliceblue; } 
    #voteUp, #voteDown{ width: 3.5em; height: 1.9em; background-color: aqua; }
     #comments{ margin-top: 10px; } 
     .eachComment{ width :50%; margin: 10px; padding: 0.5em; border-bottom: 1px solid #c1bcba; }
      .eachComment .name{ font-size: 1.5em; font-weight: bold; margin-bottom: 0.3em; display: flex; justify-content: space-between; } .eachComment .inputValue{ font-size: 1.2em; font-style: italic; } .eachComment .time{ font-size: 0.7em; color: #c1bcba; font-style: oblique; margin-top: 0.5em; margin-bottom: 0.5em; }
      .eachComment .voteDiv{ display: flex; justify-content: flex-end; } 
  .eachComment .deleteComment{ background-color: red; color: aliceblue; }

.modal{ /* 모달 css 정보는 https://codepen.io/sdthornton/pen/wBZdXq 여기참고하면 됨 */ 
box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23); 
/* 모달창 크기 100% 만들기 위한 설정 => 스크린에 꽉채운거. */ 
position: fixed; 
top : 0; 
left : 0; 
width: 100%; 
height : 100%; 
display: flex; 
justify-content: center; align-items: center; }
 /* 모달창 뜨면서 뒤에 오버레이 배경준거. 모달창하고 같이 끌어옴. 
 */ .modal__overlay{ background-color: rgba(0,0,0,0.6); 
 width: 100%; height : 100%; position: absolute; } 
 .modal__content{ background-color: white; padding: 50px 100px; 
 text-align: center; position: relative; 
 width : 15%; 
 box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23); 
 border-radius: 15px; } 
 .modal__content #modifyVal{ margin-bottom: 1em; width: 100%; height: 3.3em; } 
 #inBtn{ display: flex; justify-content: center; } 
 #inBtn #ok { all : unset; 
 background-color: steelblue; color: white; 
 padding: 5px 20px; border-radius: 5px; cursor: pointer; margin-right : 10px; } 
 #inBtn #cancle { all : unset; background-color: steelblue; color: white; padding: 5px 20px; border-radius: 5px; cursor: pointer; } 
 .hidden{ display: none; }



</style>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<title>Page Title</title>
 <meta name="viewport" content="width=device-width, initial-scale=1"> 
 <link rel="stylesheet" type="text/css" media="screen" href="index.css"> 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Insert title here</title>
</head>
<body>
<div id="form-commentInfo"> 
<div id="comment-count">댓글 
<span id="count">1</span></div> 
<input id="comment-input" placeholder="댓글을 입력해 주세요.">
 <button id="submit">등록</button> </div> <div id=comments> </div> 
 <script src="index.jsp"></script>
<script>
const inputBar = document.querySelector("#comment-input"); 
const rootDiv = document.querySelector("#comments"); 
const btn = document.querySelector("#submit"); 
const mainCommentCount = document.querySelector('#count'); 
//맨위 댓글 숫자 세는거.
//글로벌로 뺏음. 값을 저장하기 위해서. 
let idOrVoteCountList=[];
//타임스템프 만들기 
function generateTime(){
	const date = new Date(); 
	const year = date.getFullYear(); 
	const month = date.getMonth(); 
	const wDate = date.getDate(); 
	const hour = date.getHours(); 
	const min = date.getMinutes(); 
	const sec = date.getSeconds(); 
	const time = year+'-'+month+'-'+wDate+' '+hour+':'+min+':'+sec; 
	return time; }
//유저이름 발생기 //유저이름은 8글자로 제한. 
function generateUserName(){ 
	let alphabet = 'abcdefghijklmnopqrstuvwxyz'; 
	var makeUsername = ''; 
	for(let i=0; i<4;i++){ 
		let index = Math.floor(Math.random(10) * alphabet.length);
		makeUsername += alphabet[index]; 
		} 
	for(let j=0;j<4;j++){
		makeUsername += "*"; } 
	return makeUsername; } 
	
	function numberCount(event){ 
		console.log(event.target.parentNode.id); 
		for(let i=0; i<idOrVoteCountList.length; i++){ 
			if(event.target.className === "voteUp"){ 
				//event.target.parentNode.id 값이 string이기 때문에 이 값을 Number처리하던지, idOrVoteCountList[i]["commentId"]이 값을 string처리해야 넘어감. 
			if(idOrVoteCountList[i]["commentId"].toString() === event.target.parentNode.id){ 
				idOrVoteCountList[i]["voteUpCount"]++; 
				event.target.innerHTML = "👍"+idOrVoteCountList[i]["voteUpCount"]; 
				} 
			}else if(event.target.className === "voteDown"){ 
				if(idOrVoteCountList[i]["commentId"].toString() === event.target.parentNode.id){
					idOrVoteCountList[i]["voteDownCount"]++; 
					event.target.innerHTML = "👎"+idOrVoteCountList[i]["voteDownCount"]; 
					} 
				} 
			} 
		} 
	
	//기존에 남아있던 id초기화 및 새로추가된부분만 코멘트값 이어서 들어옴. 
	function initIdCount(){ 
		for(let i=0; i<idOrVoteCountList.length; i++){ 
			if(idOrVoteCountList[i]["commentId"] - i > 1){ 
				idOrVoteCountList[i]["commentId"] = idOrVoteCountList[i]["commentId"] - (idOrVoteCountList.length-(i+1)); 
				} 
			} 
		} 
	
	function deleteComments(){ 
		const btn = event.target; 
		const list = btn.parentNode.parentNode;
		//commentList 
		//삭제버튼도 마찬가지임. 여러개니깐 인식을 못함. 상위노드에 id 부여함. 
		//삭제버튼 클릭한 배열의 인덱스를 날리면 됨. 뭐 여기까지 해도 상관없는데... 
		for(let i=0; i<idOrVoteCountList.length; i++){ 
			if(idOrVoteCountList[i]["commentId"].toString() === btn.parentNode.id){ 
				idOrVoteCountList.splice(btn.parentNode.id-1,1); 
				} 
			} 
		//그다음에 전체 지우기. 
		rootDiv.removeChild(list);
		//메인댓글 카운트 줄이기. 
		if(mainCommentCount.innerHTML <='0'){ 
			mainCommentCount.innerHTML = 0; 
			}else{ mainCommentCount.innerHTML--; 
			} 
		} 
	//수정창 모달로 만들기 
	function modifyComments(event){ 
		const mBtn = event.target; 
		const modal = document.createElement('div'); 
		
		//모달창 만들기 
		const modal = document.createElement('div') 
		const modalOverlay = document.createElement('div'); 
		const modalContent = document.createElement('div'); 
		const cancleBtn = document.createElement('button'); 
		const okBtn = document.createElement('button'); 
		const input = document.createElement('input'); 
		const span = document.createElement('span'); 
		modal.className = "modal hidden";
		modalOverlay.className ="modal__overlay"; 
		modalContent.className ="modal__content"; 
		okBtn.id = "ok"; 
		okBtn.innerHTML="수정"; 
		cancleBtn.id = "cancle"; 
		cancleBtn.innerHTML = "취소"; 
		input.id = "modifyVal"; 
		input.placeholder = "변경할 내용을 입력하세요"; 
		span.id ="inBtn";

		span.appendChild(okBtn); 
		span.appendChild(cancleBtn); 
		modalContent.appendChild(input); 
		modalContent.appendChild(span); 
		modal.appendChild(modalOverlay); 
		modal.appendChild(modalContent); 
		rootDiv.appendChild(modal); 
		m
		odal.classList.remove("hidden"); 
		
		cancleBtn.addEventListener("click",function(){ 
			modal.classList.add("hidden"); 
			});

		okBtn.addEventListener("click",function(event){ 
			console.dir(mBtn.parentNode.parentNode.children[1]);
			
			for(var i=0; i<idOrVoteCountList.length; i++){ 
				if(idOrVoteCountList[i]["commentId"].toString() === mBtn.parentNode.id){ 
					idOrVoteCountList[i]["commentValue"] = input.value; 
					//수정버튼누르면 변경.
					mBtn.parentNode.parentNode.children[1].innerHTML = input.value; 
					modal.classList.add("hidden"); 
					} 
				}
			});
		} 
	
	//댓글보여주기 
	function showComment(comment){ 
		inputValue.id = newId;
		const userName = document.createElement('div');
		const inputValue = document.createElement('span'); 
		const showTime = document.createElement('div'); 
		const voteDiv = document.createElement('div'); 
		const countSpan = document.createElement('span') 
		const voteUp = document.createElement('button'); 
		const voteDown = document.createElement('button'); 
		const commentList = document.createElement('div'); 
		//이놈이 스코프 밖으로 나가는 순간 하나지우면 다 지워지고 입력하면 리스트 다불러옴. 
		const modifyBtn = document.createElement('button'); 
		const spacer = document.createElement('div'); 
		const newId = idOrVoteCountList.length+1; 
		//댓글하나에 달린 ID //스페이서만들기 
		spacer.className = "spacer"; 
		
		//삭제버튼 만들기 
		const delBtn = document.createElement('button'); 
		delBtn.className ="deleteComment"; 
		delBtn.innerHTML="삭제"; 
		commentList.className = "eachComment"; 
		userName.className="name"; 
		userName.id = newId; 
		//삭제,수정버튼의 상위노드. 
		inputValue.className="inputValue"; 
		showTime.className="time"; 
		voteDiv.className="voteDiv"; 
		voteDiv.id = newId; 
		//수정버튼 만들기 
		modifyBtn.className = 'modifyBtn'; 
		modifyBtn.innerHTML = "수정"; 
		//유저네임가져오기 
		userName.innerHTML = generateUserName(); 
		userName.appendChild(spacer); 
		userName.appendChild(modifyBtn); 
		userName.appendChild(delBtn); 
		//입력값 넘기기 
		inputValue.innerText = comment; 
		//타임스템프찍기 
		showTime.innerHTML = generateTime();
		countSpan.innerHTML=0; 
		//투표창 만들기, css먼저 입혀야함. 
		voteUp.className ="voteUp"; 
		voteDown.className ="voteDown"; 
		voteUp.innerHTML = "👍"+0; 
		voteDown.innerHTML = "👎"+0; 
		voteDiv.appendChild(voteUp);
		voteDiv.appendChild(voteDown); 
		//댓글뿌려주기 
		commentList.appendChild(userName); 
		commentList.appendChild(inputValue); 
		commentList.appendChild(showTime); 
		commentList.appendChild(voteDiv); 
		rootDiv.prepend(commentList); 
		//아이디에 따른 투표수카운트. 배열에 접근해서 수정하는 방식으로 해야함. 
		let IdAccordingToVoteCount ={ 
				"commentId" : newId, 
				"voteUpCount" : 0, 
				"voteDownCount" : 0,
				 "commentValue" : comment
				} 
		
		idOrVoteCountList.push(IdAccordingToVoteCount); 
		console.log(idOrVoteCountList); 
		
		initIdCount(); 
		
		voteUp.addEventListener("click",numberCount); 
		voteDown.addEventListener("click",numberCount);
		delBtn.addEventListener("click",deleteComments);
		modifyBtn.addEventListener("click",modifyComments); 
		}

		
		
		//버튼만들기+입력값 전달 
		function pressBtn(){ 
			const currentVal = inputBar.value;
			if(!currentVal.length){ 
				alert("댓글을 입력해주세요!!"); 
				}else{ 
					showComment(currentVal); 
					mainCommentCount.innerHTML++; 
					inputBar.value =''; 
					} 
			}
		btn.onclick = pressBtn;



</script>
</body>
</html>
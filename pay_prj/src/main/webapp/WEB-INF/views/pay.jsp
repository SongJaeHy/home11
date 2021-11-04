<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>품질좋은 상품목록</h1>

<div class="itemSection">
	<div class="itemCard">
		<div class="itemTitle">
			<h2>운동을 위한 농구공</h2>
		</div>
		<div class="itemContent">
			<h3>시간이 날때 하면 체력에 좋습니다.</h3>
		</div>
		<div class="itemPrice">
			<p data-price="12000">12000원</p>
		</div>
		<div class="itemButton">
			<button class="orderBtn">주문하기</button>
		</div>
	</div>
	
	<div class="itemCard">
		<div class="itemTitle">
			<h2>개발자를 위한 마우스</h2>
		</div>
		<div class="itemContent">
			<h3>손목에 충격이 덜 가는 마우스</h3>
		</div>
		<div class="itemPrice">
			<p data-price="15000">15000원</p>
		</div>
		<div class="itemButton">
			<button class="orderBtn">주문하기</button>
		</div>
	</div>
	
	<div class="itemCard">
		<div class="itemTitle">
			<h2>귀에 좋은 헤드폰</h2>
		</div>
		<div class="itemContent">
			<h3>이어폰보다는 귀에 영향이 덜 갑니다.</h3>
		</div>
		<div class="itemPrice">
			<p data-price="30000">30000원</p>
		</div>
		<div class="itemButton">
			<button class="orderBtn">주문하기</button>
		</div>
	</div>
	
	<div class="itemCard">
		<div class="itemTitle">
			<h2>손에 좋은 휴대폰거치대</h2>
		</div>
		<div class="itemContent">
			<h3>거치대를 쓰면 보기 편합니다.</h3>
		</div>
		<div class="itemPrice">
			<p data-price="20000">20000원</p>
		</div>
		<div class="itemButton">
			<button class="orderBtn">주문하기</button>
		</div>
	</div>
	
	<div class="itemCard">
		<div class="itemTitle">
			<h2>그립톡</h2>
		</div>
		<div class="itemContent">
			<h3>그립감이 좋습니다.</h3>
		</div>
		<div class="itemPrice">
			<p data-price="8000">8000원</p>
		</div>
		<div class="itemButton">
			<button class="orderBtn">주문하기</button>
		</div>
	</div>
</div>
	<script>
	// 미리 받아와야할 정보를 변수를 전역변수처럼 쓰기위해 선언해두기
	var itemPrice = 0; //가격
	var itemTitle = ""; // 물건이름
	var merchant_uid = ""; // 주문번호
	
	$(".itemSection").on("click", ".orderBtn", function(){
		itemPrice = $(this).parent().siblings(".itemPrice").children().attr("data-price");
		itemTitle = $(this).parent().siblings(".itemTitle").children().text();
		d = new Date();
		merchant_uid = "order" + d.getTime();
		
		iamport();
	});
	
	
	 function iamport(){
		IMP.init('imp16480122');
		IMP.request_pay({
			pg : 'html5_inicis',
			pay_method : 'card',
			merchant_uid: merchant_uid,
			name : itemTitle,
			amount : itemPrice,
			buyer_email : 'iamport@siot.do',
			buyer_name : '구매자이름',
			buyer_tel : '010-1234-5678',
			buyer_addr : '서울특별시 강남구 삼성동',
			buyer_postcode : '123-456',
		}, function(rsp){
			console.log(rsp);
			if (rsp.success){
				$.ajax({
					type:'post',
					url:'/order',
					headers:{
						"Content-Type":"application/json",
						"X-HTTP-Method-Override":"POST"
					},
					dataType:"text",
					data: JSON.stringify({
						itemname : itemTitle,
						amount:itemPrice,
						merchant_uid :merchant_uid
					}),
					success: function(){
						alert(itemTitle + "결제완료!");
					}
				});			
			}else{
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				alert(msg);
			}
		});
	} 
	</script>
</body>
</html>
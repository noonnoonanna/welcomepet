<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="mypage/jquery-3.6.0.js"></script>
<script>
function getInfo(obj,name,phone,address) {
	var ch = obj.checked;
	var na = name;
	var ph =phone;
	var addr = address;
	if(ch == true){
		document.formm.name.value = na; 
		document.formm.phone.value = ph; 
		document.formm.address.value = addr; 
	}else{
		document.formm.name.value = ""; 
		document.formm.phone.value = ""; 
		document.formm.address.value = ""; 
	}
}

function go_order(pNum) {
	
	var reg = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	
	if(document.formm.name.value==""){
		alert("수취인을 입력하세요")
	}else if(document.formm.phone.value==""){
		alert("전화번호를 입력하세요")
	}else if(document.formm.phone.value.match(reg) == null){
		alert("연락처 형식이 잘 못 되었습니다.");
	    document.formm.phone.focus();
	}else if(document.formm.address.value==""){
		alert("배송지를 입력하세요")
	}else if(document.getElementById("orderconfirm").checked!=true){
		alert("상품주문에 동의하셔야 구매가 가능합니다.");
	}else{
		var p =pNum;
	  document.formm.action = "MypetServlet?command=order_direct_insert&pNum="+p;
	  document.formm.submit();
	}
}

function Cancle(){
	var result = confirm("취소하시겠습니까??");
		if(result){
			window.history.back();
		}else{
			
		}
}

function show1(){
	  document.getElementById('div1').style.display ='none';
}
function show2(){
	  document.getElementById('div1').style.display = 'block';
}
</script>
<article>
	<h2>주문/결제</h2>
	<form method="post" name="formm">
		<table id="cartList">
			<tr style="background-color:aliceblue">
				<th>상품명</th>
				<th>수량</th>
				<th>판매가</th>
			</tr>
			<tr>
				<td>${product.pName}</td>
				<td>${cnt}<input type="hidden" name="cnt" value="${cnt}"></td>
				<td><fmt:formatNumber value="${product.pPrice*cnt}"
						type="currency" /></td>
			</tr>
			<tr style="background-color: #e8e8e8">
				<td colspan="2">총 액</td>
				<td colspan="2"><fmt:formatNumber value="${totalPrice}"
						type="currency" /></td>
			</tr>
		</table>
		<br>
		<h2 id="oUser_info">주문자 정보</h2>
		<table id="cartList">
			<tr>
				<td class="of" style="text-align: left">이름</td>
				<td class="oi" style="text-align: left">${user.name}</td>
			</tr>
			<tr>
				<td class="of" style="text-align: left">전화번호</td>
				<td class="oi" style="text-align: left">${user.phone}</td>
			</tr>
			<tr>
				<td class="of" style="text-align: left">배송지</td>
				<td class="oi" style="text-align: left">${user.address}</td>
			</tr>
		</table>
		<h3 class="delivery">
			배송정보 <label><input type="checkbox" name="info"
				onclick="getInfo(this,'${user.name}','${user.phone}','${user.address}')">
				주문자와 동일</label>
		</h3>
		<table class="delivery_table">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name"></td>
				<th>전화번호</th>
				<td><input type="text" name="phone" id='phone'></td>
				<th>배송지</th>
				<td><input type="text" name="address" id="addr"></td>
			</tr>
		</table>
		<br>
		<h3 class="delivery">결제 금액</h3>
		<table class="delivery_table">
			<tr style="background-color:aliceblue">
				<th>상품금액</th>
				<th>배송비</th>
				<th>결제예정금액</th>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${totalPrice}" type="currency" /></td>
				<td>무료</td>
				<td><fmt:formatNumber value="${totalPrice}" type="currency" /></td>
			</tr>
		</table>
		<br>
		<h3 class="delivery">결제 방법</h3>
		<table class="pay_table">
			<tr>
				<th style="border-right: 1px dotted gray">결제방법</th>
				<td><label><input type="radio" name="pay" value="bank" checked onclick="show2();"> 무통장</label></td>
				<td><label><input type="radio" name="pay" value="payco" onclick="show1();">  페이코(미구현)</label></td>
				<td><label><input type="radio" name="pay" value="card" onclick="show1();"> 신용카드(미구현)</label></td>
				<td><label><input type="radio" name="pay" value="phone" onclick="show1();"> 휴대폰결제(미구현)</label></td>
				<td><label><input type="radio" name="pay" value="kakao" onclick="show1();"> 카카오페이(미구현)</label></td>
			</tr>
		</table>
				<div id="div1">이젠은행 123-45212-1101 예금주: 웰컴펫</div>
				
		<div id="pay_agree">
			<label><input type="checkbox" name="orderconfirm"
				id="orderconfirm"> 상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</label>
		</div>
		<table id="cartList">
			<tr style="background-color: #e8e8e8">
				<th>최종 결제 금액</th>
				<td style="font-weight: bold; font-size: 20px;"><fmt:formatNumber
						value="${totalPrice}" pattern="#,###,###" type="number" />원</td>
			</tr>
		</table>
		<div class="clear"></div>
		<div id="ing" style="float: right">
			<input type="reset" value="주문취소" name="orderconfirm1" id="null_ing" onclick="Cancle()">
				 <input type="button" value="주문하기" name="orderCancle" onclick="go_order(${product.pNum})" class="cancel">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../include/footer.jsp"%>
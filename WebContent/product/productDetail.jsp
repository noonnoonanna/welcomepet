<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="product/jquery-3.6.0.js"></script>
<script type="text/javascript" src="product/product.js"></script>
<style>
.rbb{
display:none;
}
.raa {
background-color:#f5f5f5;
}
</style>
<script>
var vId;
$("body").on("click", "[id^=rdd]", function() {
   vId=this.id;
   console.log(vId);
   $("#raa"+vId).toggleClass("raa rbb");
   });
</script>
<%!int num = 1;%>
<form method="post" name="formm">
	<div id="Product_detail">
		<a href="MypetServlet?command=product_detail&pNum=${productVO.pNum}">
			<span><img src="images/product_img/${productVO.pImg}" /></span>
		</a>
		<div id="pro_title">${productVO.pName}</div>
		<table id="pro_table">
			<tr>
				<th>제 조 사</th>
				<td>${productVO.CP}</td>
			</tr>
			<tr>
				<th>판 매 가</th>
				<td><fmt:formatNumber value="${productVO.pPrice}"
						pattern="#,###,###" type="number" />원 <input id="pP"
					name="pPrice" type='hidden' value="${productVO.pPrice}"></td>
			</tr>
			<tr>
				<th>수 량</th>
				<td><input type="number" name="cnt" maxlength="3" size="2"
					value="1" id="cn" onkeyup="changetotal()"> <input
					type="hidden" name="pNum" value="${productVO.pNum}"></td>
			</tr>
			<tr>
				<th>배송비</th>
				<td>무료</td>
			</tr>
			<tr>
				<th>상품정보</th>
				<td>${productVO.pInfo}</td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" id="to" name="total"
					value="<fmt:formatNumber value ="${productVO.pPrice}"  pattern="#,###"/>"
					readOnly></td>
			</tr>
		</table>
		<div id="re_ing">
			<input type="button" value="장바구니에 담기" class="submit"
				onclick="go_cart()" style="background: #373737; color: white">
			<input type="button" value="즉시 구매" class="submit"
				onclick="goOrder2(${productVO.pNum})"> <input type="button"
				value="이전 페이지" class="cancel" onclick="history.go(-1)">
		</div>
		<div id="review_table">
			<h2>상품후기</h2>
			<p></p>
			<table>
				<c:forEach items="${reviewList}" var="reviewVO" varStatus="status">
					<tr>
						<td><img src="images/review/${reviewVO.rating}.png"
											style="width: 71px; height: 12px;"></td>
						<td width="300"><div id ="rdd${status.index}" class="1">
									<a href="javascript:void(0);">${reviewVO.content}</a></div></td>
						<td style="font-size: 0.8em">홈페이지 구매자 IP:***</td>
						<td><fmt:formatDate value="${reviewVO.wDate}"></fmt:formatDate></td>
					</tr>
						<tr><td colspan='4'><div id="raardd${status.index}" class ="rbb">
						<br>${reviewVO.content}<br><br>
														<img src="review/${reviewVO.rImg}"></div></td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</form>
<div class="clear"></div>
<%@ include file="../include/footer.jsp"%>

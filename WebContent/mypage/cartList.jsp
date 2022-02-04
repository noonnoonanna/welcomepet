
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="mypage/mypage.js"></script>
<article>
	<h2>장바구니</h2>
	<form name="formm" method="post">
		<c:choose>
			<c:when test="${cartList.size() == 0}">
				<div id="cart_null">장바구니가 비었습니다.</div>
			</c:when>
			<c:otherwise>
				<table id="cartList">
					<tr style="background-color:aliceblue">
						<th>상품명</th><th>수 량</th><th>가 격</th><th>삭 제</th>
					</tr>

					<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td><a href="MypetServlet?command=product_detail&pNum=${cartVO.pNum_cart}">${cartVO.pName}</a></td>
							<td>${cartVO.cnt}</td>
							<td><fmt:formatNumber value="${cartVO.pPrice*cartVO.cnt}" type="currency" /></td>
							<td><a href="MypetServlet?command=cart_delete&cNum=${cartVO.cNum}">삭제</a>
							</td>
						</tr>
					</c:forEach>

					<tr style="background-color:#e8e8e8">
						<th colspan="2">총 액</th>
						<th colspan="2"><fmt:formatNumber value="${totalPrice}" type="currency" /><br></th>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>

		<div class="clear"></div>

		<div id="ing" style="float: right">
		<c:choose>
			<c:when test="${cateName=='none'}">
			<input type="button" value="쇼핑 계속하기" id="null_ing"
				onclick="location.href='MypetServlet?command=index'">
				</c:when>
				<c:otherwise>
			<input type="button" value="쇼핑 계속하기" id="null_ing"
				onclick="location.href='MypetServlet?command=${cateName}'">
				</c:otherwise>
		</c:choose>
			<c:if test="${cartList.size() != 0}">
				<input type="button" value="주문하기" id="order_btn"
					onclick="location.href='MypetServlet?command=order_form'">
			</c:if>
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../include/footer.jsp"%>
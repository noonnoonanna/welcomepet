<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

	<div class="clear"></div>

<div id="front">
	<h2>WELCOMPET ITEM</h2>
	<h3>웰컴펫 상품보기</h3>
	
	<div id="Product">
		<c:forEach items="${ProductList}" var="productVO">
			<div id="item">
				<a href="MypetServlet?command=product_detail&pNum=${productVO.pNum}">
					<img src="images/product_img/${productVO.pImg}" />
					<h3>${productVO.pName}</h3>
					<fmt:formatNumber value="${productVO.pPrice}" pattern="#,###,###" type="number"/>원
				</a>
			</div>
		</c:forEach>
	</div>

	<div class="clear"></div>
</div>

<%@ include file="../include/footer.jsp"%>
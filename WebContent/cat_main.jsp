<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/navi_cat.jsp"%>
<style>
html, body {
	cursor: url(images/catcur.cur), auto;
}
#front {
	cursor: url(images/catcur.cur), auto;
}
a:hover {
	cursor: url(images/catcur_over.cur), auto;
}
</style>

	<div class="clear"></div>
<!--메인 이미지 들어가는 곳 시작 --->
<div id="wrap" style="transform:translateY(-160px)">
	<div id="main_img">
		<img src="images/cat_main.jpg">
	</div>
</div>
<!--메인 이미지 들어가는 곳 끝--->

<!--Start of Tawk.to Script-->
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/601a48f5c31c9117cb7549f9/1etjapvth';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
<!--End of Tawk.to Script-->

<div id="front">
	<h2>WELCOMPET ITEM</h2>
	<h3 id="title">웰컴펫 상품보기</h3>
	
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
		
		<c:forEach items="${productKindList}" var="kindList">
			<div id="item">
				<a href="MypetServlet?command=product_detail&pNum=${kindList.pNum}">
					<img src="images/product_img/${kindList.pImg}" />
					<h3>${kindList.pName}</h3>
					<fmt:formatNumber value="${kindList.pPrice}" pattern="#,###,###" type="number"/>원
					
				</a>
			</div>
		</c:forEach>
	</div>

	<div class="clear"></div>
</div>

<%@ include file="../include/footer.jsp"%>
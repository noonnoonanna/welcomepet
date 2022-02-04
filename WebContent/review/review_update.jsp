<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/navi_dog.jsp"%>
<script>
function go_review_update(rNum,pNum) {
	var pN = pNum;
	var rN = rNum;
	document.formm.action = "MypetServlet?command=review_update&rNum=" + rN + "&pNum=" + pN;
	document.formm.submit()
}
</script>

<article id="review_write">
	<h2>리뷰 수정</h2>
	<p>
	<form name="formm" action="MypetServlet?command=review_update"
		method="post" enctype="multipart/form-data">
		<table id="re_write">
			<tr>
				<th>상품이름</th>
				<td>${pName}<input type="hidden" value="${pName}" name="pName"></td>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="49" rows="10">${review.content}</textarea></td>
			</tr>
			<tr>
				<th>별점</th>
				<td colspan="5" id="re_up_ra"><c:forEach items="${rating}" var="kind" varStatus="status">
				
<label>
						<c:choose>
							<c:when test="${review.rating==kind}">
								<input type="radio" value="${kind}" name="rating" checked>
								<c:if test="${kind == '0'}">0점</c:if>
								<c:if test="${kind == '1'}">1점</c:if>
								<c:if test="${kind == '2'}">2점</c:if>
								<c:if test="${kind == '3'}">3점</c:if>
								<c:if test="${kind == '4'}">4점</c:if>
								<c:if test="${kind == '5'}">5점</c:if>

							</c:when>
							<c:otherwise>
								<input type="radio" value="${kind}" name="rating">
								<c:if test="${kind == '0'}">0점</c:if>
								<c:if test="${kind == '1'}">1점</c:if>
								<c:if test="${kind == '2'}">2점</c:if>
								<c:if test="${kind == '3'}">3점</c:if>
								<c:if test="${kind == '4'}">4점</c:if>
								<c:if test="${kind == '5'}">5점</c:if>
							</c:otherwise>
						</c:choose></label>
					</c:forEach></td>
			<tr>
				<th>상품이미지</th>
				<td width="600" colspan="5"><input type="file" name="rImg" value="${review.rImg}"></td>
			</tr>
		</table>
		<div id="ing" style="float: right"> 
		<input id="review_cancle" type="reset" value="취소">
			<input type="button" value="업데이트" id="review_btn"
			onclick="go_review_update('${review.rNum}','${review.pNum}')">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../include/footer.jsp"%>

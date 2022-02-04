<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/navi_dog.jsp"%>
<%
	int odNum = Integer.parseInt(request.getParameter("odNum"));
%>
<script>
	function go_review_insert() {
		document.formm.action = "MypetServlet?command=review_insert&pNum=${pNum}&odNum="+<%=odNum%>;
		document.formm.submit()
	}
</script>
<article id="review_write">
	<h2>리뷰 등록</h2>
	<p></p>
	<form name="formm" action="MypetServlet?command=review_insert"
		method="post" enctype="multipart/form-data">
		<table id="re_write">
			<tr>
				<th>상품명</th>
				<td>${pName}</td>
				<td><input type="hidden" value=<%=odNum%> name="odNum"></td>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="49" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>별점</th>
				<td colspan="5"><label><input type="radio" name="rating" value="0"> 0점</label>
					            <label><input type="radio" name="rating" value="1"> 1점</label>
					            <label><input type="radio" name="rating" value="2"> 2점</label>
					            <label><input type="radio" name="rating" value="3"> 3점</label>
					            <label><input type="radio" name="rating" value="4"> 4점</label>
					            <label><input type="radio" name="rating" value="5"> 5점</label>
				</td>
			<tr>
				<th>상품이미지</th>
				<td colspan="5"><input type="file" name="rImg"></td>
				
			</tr>
		</table>
		<div id="ing" style="float: right">
			<input type="reset" value="취소" id="review_cancle">
			<input type="button" value="등록" onclick="go_review_insert()" id="review_btn">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../include/footer.jsp"%>
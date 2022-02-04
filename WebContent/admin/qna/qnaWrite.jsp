<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/admin/header.jsp"%>
	<%@ include file="/admin/sub_menu.jsp"%>
<div id="mtm_title">
<h2>공지사항</h2></div>

<article>
	<form name="formm" method="post" action="MypetServlet?command=qna_write">
	
	<table id="orderList">
	<tr>
		<th>제목</th>
		<td><input type="text" name="qTitle" size="77"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="8" cols="60" name="qContent"></textarea></td>
	</tr>
	</table>
<div class="clear"> </div>
<div class="md_btn">
	<input type="submit" value="글쓰기" class="btn">
	<input type="reset" value="취소" class="btn">
</div>
</form>
</article>

<%@ include file="/admin/footer.jsp"%>

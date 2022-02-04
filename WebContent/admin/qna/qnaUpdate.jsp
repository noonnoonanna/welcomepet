<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/admin/header.jsp"%>
	<%@ include file="/admin/sub_menu.jsp"%>
    
<div id="mtm_title">
<h2>공지사항</h2>
<h3>공지사항 수정</h3></div>

	<article>
<form name="formm" method="post" action="MypetServlet?command=qna_update">
	<input type="hidden" name="qNo" value="${qna.qNo}">
	<table id="orderList">
	<tr>
		<th>제목</th>
		<Td><input type="text" name="qTitle" size="77" value="${qna.qTitle}"></Td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="8" cols="60" name="qContent" >${qna.qContent}</textarea></td>
	</tr>

	</table>
	<div class="md_btn">
	<input type="submit" value="등록" class="btn">
	<input type="reset" value="다시 작성" class="btn">
	<input type="button" value="목록" onclick="location.href='MypetServlet?command=admin_qna_list'" class="btn"></div>
</form>
</article>
<%@ include file="/admin/footer.jsp"%>

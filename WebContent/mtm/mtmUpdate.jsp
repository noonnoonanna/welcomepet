<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

<article>
	<h2>1:1 게시글 수정</h2>

	<form name="formm" method="post"
		action="MypetServlet?command=mtm_update">
		<input type="hidden" name="qseq" value="${mtm.qseq}">
		<table id="cartList">
			<tr>
				<td>제목</td>
				<td class="mtm_input"><input type="text" name="title" value="${mtm.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td class="mtm_input"><textarea rows="15" cols="49" name="content">${mtm.content}</textarea></td>
			</tr>
		</table>
		<div class="clear"></div>
		<div id="mtm_ing" style="float: right">
			<input type="submit" value="등록" class="submit">
			<input type="reset" value="취소" class="cancel">
			<input type="button" value="목록" class="submit"
				onclick="location.href='MypetServlet?command=mtm_list'">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="/include/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
	<article>
		<h2>1:1 문의</h2>
		<h3 id="mtm_h3">고객님 문의에 1:1 답변을 드립니다.</h3>
		<form name="formm" method="post" action="MypetServlet?command=mtm_write">
			<table id="cartList">
				<tr>
					<Td>제목</Td>
					<td class="mtm_input"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>문의내용</td>
					<td class="mtm_input"><textarea rows="15" cols="49" name="content"></textarea></td>
				</tr>
			</table>
			<div class="clear"></div>
			<div id="mtm_ing" style="float: right">
				<input type="button" value="쇼핑 계속하기" class="submit"
					onclick="location.href='MypetServlet?command=index'">
				<input type="reset" value="내용 지우기" class="cancel">
				<input type="submit" value="글쓰기" class="submit" style="background-color:#373737; color:white;">
			</div>
		</form>
	</article>
	<div class="clear"></div>
<%@ include file="/include/footer.jsp"%>
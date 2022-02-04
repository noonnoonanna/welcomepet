<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<script>
	function go_update() {
		document.formm.action = "MypetServlet?command=mtm_update_form&qseq=${mtmVO.qseq}";
		document.formm.submit();
	}
	function go_delete() {
		document.formm.action = "MypetServlet?command=mtm_delete&qseq=${mtmVO.qseq}";
		documemt.formm.submit();
	}
</script>
<article>
	<h2>1:1 고객 센터</h2>
	<h4 id="mtm_h4">고객님 문의에 1:1 답변을 드립니다.<br>
	       운영시간 : 평일 09:00 ~ 18:00 (주말 & 공휴일 제외)</h4>
	<input type="hidden" name="qseq" value="${mtmVO.qseq}">
	<div id="mtm_update">
		<a href="MypetServlet?command=mtm_update_form&qseq=${mtmVO.qseq}">수정</a>
		/
		<a href="MypetServlet?command=mtm_delete&qseq=${mtmVO.qseq}"> 삭제</a>
	</div>			
	<form name="formm" method="post">
		<table id="mtmView_table">
			<tr>
				<th>제목</th>
				<td>${mtmVO.title}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${mtmVO.indate}" type="date" /></td>
			<tr>
				<th>내용</th>
				<td>${mtmVO.content}</td>
			</tr>
			<tr>
				<th>답변내용</th>
				<td>${mtmVO.reply}</td>
			</tr>
		</table>

		<div id="ing" style="float: right">
			<input type="button" value="목록보기" class="submit"
				onclick="location.href='MypetServlet?command=mtm_list'">
		    <input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='MypetServlet?command=index'">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="/include/footer.jsp"%>

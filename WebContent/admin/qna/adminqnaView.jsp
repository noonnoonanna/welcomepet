<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="/admin/header.jsp"%>
	<%@ include file="/admin/sub_menu.jsp"%>
<script>
function open_win(url, name){
	window.open(url, name, "width=500, height=230");
}

function go_update(){
    var theForm = document.formm;
    theForm.action = "MypetServlet?command=qna_update_form&qNo=${qnaVO.qNo}";
    theForm.submit();
 }
 function go_delete(qNo){
    var theForm = document.formm;
    theForm.action = "MypetServlet?command=qna_delete&qNo=${qnaVO.qNo}";
    theForm.submit();
 }

</script>
<div id="mtm_title"><h2>고객 센터</h2>
<h3>공지사항</h3></div>

		
<form name="formm" method="post">
	<article>
	<table id="orderList">
	
		<tr>	
			<th>제목</th>
			<td>${qnaVO.qTitle}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><fmt:formatDate value="${qnaVO.qDate}" type="date"/></td>
		</tr>
		<tr>
			<th>공지사항</th>
			<td>${qnaVO.qContent}</td>
		</tr>
	
	</table>
	<div class="clear"></div>
		<div id="buttons">
		
 		<input type="button" class="btn" value="수정" onclick="go_update()">
		<input type="button" class="btn" value="삭제" onclick="go_delete()">
	</div>
	 	
	


</article>
</form>

<%@ include file="/admin/footer.jsp"%>

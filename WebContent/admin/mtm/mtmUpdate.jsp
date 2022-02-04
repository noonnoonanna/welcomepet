<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ include file="/admin/header.jsp"%>
	<%@ include file="/admin/sub_menu.jsp"%>
<script>
function go_list() {
	var theForm = document.formm;
	theForm.action = "MypetServlet?command=admin_mtm_list";
	theForm.submit();
}
function go_update(qseq){
	var theForm = document.formm;
	theForm.qseq.value=qseq;
	
	theForm.action = "MypetServlet?command=admin_mtm_update";
	theForm.submit();
}
	
	function go_rep(qseq){
		var theForm = document.formm;
		theForm.qseq.value=qseq;
		theForm.action="MypetServlet?command=admin_mtm_repsave";
		theForm.submit();
	}


</script>
<div id="mtm_title"><h1>답변 글 수정</h1></div>
<form name="formm" method="post">
<article>
<input type="hidden" name="qseq">

<table id="orderList">
	
	<tr>
		<th width="20%">제목</th>
		
		<td>${mtmVO.title}
		<input type ="hidden" name ="title" value ="${mtmVO.title}"></td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><fmt:formatDate value="${mtmVO.indate}"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${mtmVO.content}<input type ="hidden" name ="content" value ="${mtmVO.content}"></td>
	</tr>
		<tr>
  		<td colspan="2">
  		<textarea name="reply" rows="3" cols="50">${mtmVO.reply}</textarea>
	<input type="button" class="btn"  value="수정" onclick= "go_update('${mtmVO.qseq}')">
		<%-- <a href="MypetServlet?command=admin_mtm_update${mtmVO.qseq}">저장</a> --%>
  		</td>
  	</tr>


  </table>

 <input type="button" class="btn" value="목록" onclick="go_list()">
 

<input type="reset" class="btn" value="취소" >
 </article>
</form>

<%@ include file="/admin/footer.jsp"%>

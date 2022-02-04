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
	
	function go_rep(qseq){
	      var theForm = document.formm;
	      theForm.qseq.value=qseq;
	      theForm.action="MypetServlet?command=admin_mtm_repsave";
	      theForm.submit();
	}
	function go_update_form(){
	      var theForm = document.formm;
	      theForm.action = "MypetServlet?command=admin_mtm_update_form&qseq=${mtmVO.qseq}";
	      theForm.submit();
	   }
	   function go_delete(qseq){
	      var theForm = document.formm;
	      theForm.qseq.value=qseq;
	      theForm.action = "MypetServlet?command=admin_mtm_delete&qseq=${mtmVO.qseq}";
	      theForm.submit();
	   }

</script>
<div id="mtm_title"><h1>1:1 문의 게시판</h1></div>
<form name="formm" method="post">
<article>
<input type="hidden" name="qseq">
<table id="orderList">
	
	<tr>
		<th width="20%">제목</th>
		<td>${mtmVO.title} </td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><fmt:formatDate value="${mtmVO.indate}"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${mtmVO.content}</td>
	</tr>
</table>
<c:choose>
  <c:when test='${mtmVO.rep=="1"}'>
  <table id="orderList">
  	<tr>
  		<th>답변</th>
  		<td><textarea name="reply"></textarea>
		<input type="button" class="btn" value="저장" onclick= "go_rep('${mtmVO.qseq}')"></td>
  	</tr>
  </table>
  <br>
  </c:when>
  <c:otherwise>
  <table id="orderList">
    <tr>
     <th>답변</th>
     <td>${mtmVO.reply}</td>
    </tr>
  </table>
  </c:otherwise>
 </c:choose>
 <div class="md_btn">
 <input type="button" class="btn" value="목록" onclick="go_list()">
  <input type="button" class="btn" value="수정" onclick="go_update_form()">
<input type="button" class="btn" value="삭제" onclick="go_delete()"></div>
 </article>
</form>

<%@ include file="/admin/footer.jsp"%>

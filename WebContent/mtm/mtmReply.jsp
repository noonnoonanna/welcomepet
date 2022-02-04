<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/include/header.jsp" %>
    
<form action="MypetServlet?command=mtm_reply" method="post">
<input type="hidden" name="qseq" value="${mtm.qseq}">
	<label>제목</label>
	<input type="text" name="title" size="77"><br>
	<label>내용</label>
	<textarea rows="8" cols="60" name="content"></textarea><br>

	<input type="submit" value="확인">
</form>
<div class="clear"></div>
<%@ include file="/include/footer.jsp" %>

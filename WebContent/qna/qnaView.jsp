<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ include file="../include/header.jsp" %>
<article>
<h2>공지사항</h2>
		
<form name="formm" method="post">
	<table id="cartList">
	
		<tr>	
			<th style="background-color:#e7e7e7">제목</th>
			<td>${qnaVO.qTitle}</td>
		</tr>
		<tr>
			<th style="background-color:#e7e7e7">등록일</th>
			<td><fmt:formatDate value="${qnaVO.qDate}" type="date"/></td>
		</tr>
		<tr>
			<th style="background-color:#e7e7e7">내용</th>
			<td>${qnaVO.qContent}</td>
		</tr>
	
	</table>
	<div class="clear"></div>
		<div id="ing" style="float:right">
		<input type="button" value="목록보기" class="submit" onclick="location.href='MypetServlet?command=qna_list'">
		<input type="button" value="쇼핑계속하기" class="cancel" onclick="location.href='MypetServlet?command=index'">
	</div>
	 	
	 	
		
</form>
</article>
<%@ include file="../include/footer.jsp" %>

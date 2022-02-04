<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<article>
<h2>고객 센터</h2>

<form name="formm" method="post">
	<table id="cartList">
	<tr style="background-color:aliceblue">
		<th>번호</th><th>제목</th><th>등록일</th><th>작성자</th>
	</tr>
	<c:forEach items="${qnaList}" var="qnaVO">
	<tr>
		<td>${qnaVO.qNo}</td>
		<td><a href="MypetServlet?command=qna_view&qNo=${qnaVO.qNo}">${qnaVO.qTitle}</a></td>
		<td><fmt:formatDate value="${qnaVO.qDate}" type="date"/></td>
		<td>${qnaVO.ID}</td>
		
	</tr>
	</c:forEach>
	</table>
	<div class="clear"></div>
	<div id="ing" style="float:right">
	<input type="button" value="1:1 문의하기" class="submit" onclick="location.href='MypetServlet?command=mtm_list'">
	<input type="button" value="쇼핑계속하기" class="cancel" onclick="location.href='MypetServlet?command=index'">
	
	</div>
</form>
</article>
<div class="clear"></div>

<%@ include file="../include/footer.jsp" %>
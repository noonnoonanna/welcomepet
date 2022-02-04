<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ include file="../include/header.jsp" %>
<article>
<h2>1:1 문의 게시판</h2>
<form name="formm" method="post">
	<table id="cartList">
		<tr style="background-color:aliceblue">
			<th>번호</th> <th>제목</th> <th>등록일</th> <th>답변여부</th>
		</tr>
		<c:forEach items="${mtmList}" var="mtmVO">
		<tr>
			<td>${mtmVO.qseq}</td>
			<td><a href="MypetServlet?command=mtm_view&qseq=${mtmVO.qseq}">${mtmVO.title}</a></td>
			<td><fmt:formatDate value="${mtmVO.indate}" type="date"/></td>
			<td>
				<c:choose>
				   <c:when test="${mtmVO.rep==1}">답변중</c:when>
				   <c:when test="${mtmVO.rep==2}">답변완료</c:when>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
	</table>
	<div class="clear"></div>
	<div id="ing" style="float:right">
	<input type="button" value="글쓰기" class="submit" onclick="location.href='MypetServlet?command=mtm_write_form'">
	<input type="button" value="쇼핑계속하기" class="cancel" onclick="location.href='MypetServlet?command=index'">
</div>
</form></article>
<div class="clear"></div>
<%@ include file="../include/footer.jsp" %>
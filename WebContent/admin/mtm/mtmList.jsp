<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<script type="text/javascript">
   function go_view(qseq) {
      var theForm = document.formm;
      theForm.qseq.value=qseq;
      theForm.action = "MypetServlet?command=admin_mtm_detail";
      theForm.submit();
   }
</script>

<form name="formm" method="post">
<article>
<input type="hidden" name="qseq">
  <table id="orderList">
  
<h1>1:1 고객문의 리스트</h1>
    <tr>
       <th>번호(답변여부)</th> <th>제목</th> <th>작성자</th> <th>작성일</th>
    </tr>
    <c:forEach items="${mtmList}" var="mtmVO">
    <tr>
       <td>${mtmVO.qseq}
       <c:choose>
          <c:when test='${mtmVO.rep=="1"}'>(미처리)</c:when>
           <c:otherwise>(답변처리완료)</c:otherwise>
        </c:choose>
        </td>
        <td>
        <a href="#" onclick="javascript:go_view('${mtmVO.qseq}')">
           ${mtmVO.title}
        </a>
        </td>
        <td> ${mtmVO.id}</td>
        <td><fmt:formatDate value="${mtmVO.indate}"/></td>
     </tr>
  </c:forEach>
  </table>
     </article>
</form>

<%@ include file="/admin/footer.jsp"%>

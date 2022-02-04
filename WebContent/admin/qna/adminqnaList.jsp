<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ include file="/admin/header.jsp"%>
   <%@ include file="/admin/sub_menu.jsp"%>
   <form name="frm" method="post">
   <article>
   <div id="adqna_title"><h2>고객 센터</h2>
   <h3>공지사항</h3></div> 
      
      <br>
      <table id="orderList">
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>등록일</th>
         </tr>
         <c:forEach items="${qnaList}" var="qnaVO">

            <tr>
<td>${qnaVO.qNo}</td>
      <td><a href="MypetServlet?command=admin_qna_view&qNo=${qnaVO.qNo}">${qnaVO.qTitle}</a></td>
      <td><fmt:formatDate value="${qnaVO.qDate}" type="date"/></td>
            
               
            </tr>
         </c:forEach>
      </table>
      <div class="clear"></div>
   <div id="buttons" style="float:right">
   <input type="button" class="btn" value="글쓰기" onclick="location.href='MypetServlet?command=qna_write_form'">
   </div>
   </article>
   </form>
<%@ include file="/admin/footer.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../include/header.jsp" %>  
  <article>
    <h2>마이페이지</h2>
    <form name="formm" method="post">
      <table id="cartList">
      <tr style="background-color:aliceblue">
        <th>주문일자</th> <th>주문번호</th> <th>상품명</th> <th>결제 금액</th> <th>주문 상세</th>   
      </tr>
      <c:forEach items="${orderList}"  var="orderVO">
      <tr>  
        <td> <fmt:formatDate value="${orderVO.indate}" type="date"/></td>
        <td> ${orderVO.oNum} </td>    
        <td> ${orderVO.pName} </td>
        <td> <fmt:formatNumber value="${orderVO.pPrice}" type="currency"/> </td>
        <td> <a href="MypetServlet?command=order_detail&oNum=${orderVO.oNum}"> 조회 </a></td>
      </tr>
      </c:forEach>    
      </table>   
          
      <div class="clear"></div>
      <div id="order_ing" style="float: right">
      <c:choose>
      	<c:when test="${cateName eq 'none'}">
       <input type="button" value="쇼핑 계속하기" id="null_ing"  onclick="location.href='MypetServlet?command=index'">
      	</c:when>
      	<c:otherwise>
       <input type="button" value="쇼핑 계속하기" id="null_ing"  onclick="location.href='MypetServlet?command=${cateName}'">
       </c:otherwise>
      </c:choose>
       <input type="button"    value="회원정보 수정"  class="cancel"  onclick="location.href='MypetServlet?command=update_user_form'"> 
      </div>
    </form>  
  </article>
  <div class="clear"></div>
<%@ include file="../include/footer.jsp" %>    
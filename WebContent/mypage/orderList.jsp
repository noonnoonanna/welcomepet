<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../include/header.jsp" %>  
  <article>
      <h2>주문 확인</h2>
      <form name="formm" method="post">
        <table id="cartList">
       <tr style="background-color:aliceblue">
        <th>주문자</th><th>받는사람</th><th>연락처</th><th colspan = "2">주소</th>
       </tr>
       <tr style="border-bottom:1px solid gray">
        <td>${orderList[0].name}</td><td>${orderList[0].oname}</td><td>${orderList[0].ophone}</td><td colspan = "2">${orderList[0].oaddress}</td>
        </tr>
       <tr style="background-color:aliceblue">
        <th>상품명</th> <th>수 량</th><th>가 격</th> <th>주문일</th> <th> 진행 상태 </th>    
       </tr>
       <c:forEach items="${orderList}"  var="orderVO">
       <tr>      
        <td>
            <a href="MypetServlet?command=product_detail&pseq=${cartVO.pNum}">
              ${orderVO.pName}              
          </a>    
        </td>
        <td> ${orderVO.cnt} </td>
        <td> <fmt:formatNumber value="${orderVO.pPrice*orderVO.cnt}" type="currency"/> </td>      
        <td> <fmt:formatDate value="${orderVO.indate}" type="date"/></td>
        <td> 처리 진행 중 </td>
       </tr>
       </c:forEach>
       <tr style="background-color:#e8e8e8">
         <th colspan="2"> 총 액 </th>
         <th colspan="2"> <fmt:formatNumber value="${totalPrice}" type="currency"/></th> 
         <th style="color:red"> 주문 처리가 완료되었습니다. </th>                
       </tr> 
      </table>   
          
      <div class="clear"></div>
      <div id="ing" style="float: right">
       <input type="button" value="쇼핑 계속하기" id="null_ing" onclick="location.href='MypetServlet?command=index'">     
      </div>
    </form>  
  </article>
  <div class="clear"></div>
<%@ include file="../include/footer.jsp" %>
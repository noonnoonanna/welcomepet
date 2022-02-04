<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<script>
function go_detail(tpage, pNum) {
   var theForm = document.frm;
   // 상품 상세 보기 페이지에서 다시 상품 리스트로 돌아왔을 경우 현재 페이지로
   // 돌아올 수 있도록 하기 위해서 현재 페이지 번호를 쿼리 스트링으로 넘겨준다.
   theForm.action =  "MypetServlet?command=admin_product_detail&tpage=" +
                     tpage+"&pNum="+pNum;
   
   theForm.submit();
}
</script>





<article>
<form name="frm" method="post">
 
 <h1>상품리스트</h1>
 <table>
  <tr>
  <td width="800">
       
      상품분류
       <select name="kind">
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${kind}">${kind}</option>
   </c:forEach>
  </select>  
 카테고리
  <select name="cateCode">
    <c:forEach items="${cateCodeList}" var="cateCode" varStatus="status1">
      <option value="${status1.index}">${cateCode}</option>
   </c:forEach>
   </select>
  상품명  
     <input type="text" name="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
     <input class="btn" type="button" name="btn_write" value="상품등록" onClick="go_wrt()">
  </td>
  </tr>
</table>
<table id="orderList">
    <tr>
        <th>번호</th><th>상품명</th><th>판매가</th><th>제조사</th><th>코드</th><th>분류</th>
    </tr>
    <c:choose>
    <c:when test="${productListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 상품이 없습니다.
      </td>      
    </tr>
    </c:when>
   <c:otherwise>
   <c:forEach items="${productList}" var="productVO">
    <tr>
      <td height="23" align="center" >${productVO.pNum}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="#" onClick="go_detail('${tpage}', '${productVO.pNum}')">
        ${productVO.pName}     
         </a>
        </td>
     
      <td><fmt:formatNumber value="${productVO.pPrice}"/></td> 
      <td>${productVO.CP}</td>
      <td>${productVO.cateCode}</td>
      <td>${productVO.kind}</td>
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
   </c:otherwise>   
</c:choose>  
</table>

</form>
</article>  

<%@ include file="/admin/footer.jsp"%>
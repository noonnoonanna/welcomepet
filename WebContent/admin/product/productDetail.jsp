<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
<h1>상품 상세 보기</h1> 
<form name="frm" method="post">
<table id="list">
  <tr>
    <th>카테고리</th>
    <td  colspan="5">
  ${productVO.cateCode}
     </td>    
    </tr>    
  <tr>
    <th>상품분류</th>
    <td  colspan="5">
  ${productVO.kind}
     </td>    
    </tr>    
    <tr>
        <th align="center" >상품 명</th>
        <td colspan="5">${productVO.pName}</td>
    </tr>
    <tr>
        <th align="center" >제조사</th>
        <td colspan="5">${productVO.CP}</td>
    </tr>
    
    <tr>
        <th >가격</th>
        <td width="60">${productVO.pPrice}</td>
        
    </tr>
     
    <tr>
        <th>상세설명</th>
        <td colspan="5">${productVO.pInfo}</td>
    </tr>
    
    <tr>
     <th>상품이미지</th>
     <td colspan="5" align="center">
  <!--[7] 상품 이미지를 출력하기 -->     
     <img src="images/product_img/${productVO.pImg}" width="200pt">    
     </td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_mod('${tpage}','${productVO.pNum}')">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onClick="go_list('${tpage}')">           
</form>
</article>
<%@ include file="/admin/footer.jsp"%>

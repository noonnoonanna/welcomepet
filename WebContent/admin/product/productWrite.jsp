<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<script>
function go_save() 
{
	 var theForm = document.frm;		
		theForm.action = "MypetServlet?command=admin_product_write";
		theForm.submit();
	}

</script>
<article>

<h1>상품등록</h1>  
<form name="frm" method="post" enctype="multipart/form-data">
<table id="list">
<tr>
  <th>상품분류</th>
  <td colspan="5">
  <select name="kind">
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${kind}">${kind}</option>
   </c:forEach>
  </select>  
 </td>
 <th>카테고리</th>
  <td colspan="5">
  <select name="cateCode">
    <c:forEach items="${cateCodeList}" var="cateCode" varStatus="status1">
      <option value="${status1.count}">${cateCode}</option>
   </c:forEach>
   </select>
     
 </td>
 </tr>
 
 <tr>
 <th> 제조사</th>
 <td width="70">   
 	<input type="text" name="CP" size="11" >
 </tr>
      
<tr>
  <th>상품명</th>
  <td width="343" colspan="5">
       <input type="text" name="pName" size="47" maxlength="100">
  </td>
</tr>
<tr>
  <th>판매가격</th>
  <td width="70">
    <input type="text" name="pPrice" size="11" >
  </td>
  
  </tr>
    
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="pInfo" rows="8" cols="70" ></textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="pImg">
    </td>
  </tr>    
</table>
<input type="button" value="등록" onclick="go_save()" class="btn">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="/admin/footer.jsp"%>

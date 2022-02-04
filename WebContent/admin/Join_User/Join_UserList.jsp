<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script type="text/javascript">
  function go_search()
  {
     document.frm.action="MypetServlet?command=admin_member_list";
     document.frm.submit();
  }
	
	function go_search4() {
		document.frm.action = "MypetServlet?command=order_Ranklist";
		document.frm.submit();
	}
	
</script>

<article>
<h1>회원리스트</h1>  
<form name="frm" method="post">
<table style="float:right; ">

  <tr>
  <td> 
  회원 이름
  <input type="text" name="key">
  <input class="btn" type="button" value="검색" onclick="go_search()">
  </td>
  </tr>
</table>  
<br>
<table id="orderList">
  <tr>
    <th> 아이디 </th>    <th> 이름 </th>
    <th> 이메일 </th>             <th> 우편번호 </th>  
    <th> 주소 </th>  <th> 전화 </th>  
  </tr>
  <c:forEach items="${join_UserList}" var="join_userVO">  
  <tr>
    <td>${join_userVO.ID} 
    </td>
    <td> ${join_userVO.name} </td>
    <td> ${join_userVO.email} </td> 
    <td> ${join_userVO.birthday} </td>
    <td> ${join_userVO.address} </td>
    <td> ${join_userVO.phone} </td> 
  
  </tr>
    </c:forEach>
    
</table>
 <div style="width:1123px">
 
<input class="btn" type="button" value="회원랭크"
onclick="go_search4()">
				
				</div>
</form>
 
</article>

<%@ include file="/admin/footer.jsp"%>
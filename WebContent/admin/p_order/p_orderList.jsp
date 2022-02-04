<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script type="text/javascript">
	function go_order_save2() {
		var count = 0;
		if (document.frm.admin_state.length == undefined) {
			if (document.frm.admin_state.checked == true) {
				count++;
			}
		} else {
			for (var i = 0; i < document.frm.admin_state.length; i++) {
				if (document.frm.admin_state[i].checked == true) {
					count++;
				}
			}
		}
		if (count == 0) {
			alert("주문처리할 항목을 선택해 주세요.");
		} else {
			document.frm.action = "MypetServlet?command=admin_order_save_finish";
			document.frm.submit();
		}
	}

	function go_search1() {
		document.frm.action = "MypetServlet?command=admin_order_list";
		document.frm.submit();
	}
</script>
<form name="frm" method="post">
	<article>
		<h1>주문리스트</h1>
		<table style="float: right;">
			<tr>
				<td>주문자 이름 <input type="text" name="key">
				 		    <input class="btn" type="button" value="검색" onclick="go_search1()">
				</td>
			</tr>
		</table>
		<br>
		<table id="orderList">
			<tr>
				<th>전체주문번호</th>
				<th>주문번호</th>
				<th>제품번호</th>
				<th>ID</th>
				<th>가격</th>
				<th>수량</th>
				<th>주문일</th>
				<th>결제확인</th>
				<th>주문확인</th>
			</tr>
			<c:forEach items="${p_orderList}" var="p_orderVO">
				<tr>
					<td>${p_orderVO.oNum}</td>
					<td>${p_orderVO.odNum}</td>
					<td>${p_orderVO.pNum}</td>
					<td>${p_orderVO.ID}</td>
					<td>${p_orderVO.pPrice}</td>
					<td>${p_orderVO.cnt}</td>
					<td><fmt:formatDate value="${p_orderVO.indate}" /></td>
					<td>${p_orderVO.user_state}</td>
					<td><c:choose>
							<c:when test='${p_orderVO.admin_state=="주문완료"}'>
								<span style="font-weight: bold; color: black"> 
								(<input	type="checkbox" name="admin_state" value="${p_orderVO.odNum}"> 배송완료) </span>
							</c:when>
							<c:when test='${p_orderVO.admin_state=="취소요청"}'>
								<span style="font-weithd: bold; color: red">취소 요청</span>
								
							</c:when>
							<c:when test='${p_orderVO.admin_state=="배송완료"}'>
								<span style="font-weithd: bold; color: green">배송완료</span>
							</c:when>
							<c:when test='${p_orderVO.admin_state=="취소완료"}'>
								<span style="font-weithd: bold; color: black">취소 완료</span>
							</c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" class="btn" style="margin: 0 7px 7px 155px;"
			value="배송완료" onClick="go_order_save2()">
	</article>
</form>

<%@ include file="/admin/footer.jsp"%>

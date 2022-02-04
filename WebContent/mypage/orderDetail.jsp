<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="mypage/mypage.js"></script>
<script>
function goReview(pNum,result,odNum){
	   var re = result;
	   var od = odNum;
	   if(re==1){
	      
	   document.formm.action = "MypetServlet?command=review_write&pNum="+pNum+"&odNum="+od;
	   document.formm.submit();
	   }else {
	      alert("이미 리뷰 작성하셨습니다.")
	   }
	}
	
function goReviewUpdate(odNum,pNum){
	   var od = odNum;
	   var pN = pNum;
	   document.formm.action = "MypetServlet?command=review_update_form&odNum="+od+"&pNum="+pN;
	   document.formm.submit();
}
</script>
<article>
	<h2>마이페이지(상세정보)</h2>
	<form name="formm" method="post">
		<h3 class="order_info">배송 정보</h3>
		<table id="cartList">
			<tr style="background-color:#E4F7BA">
				<th>주문자</th>
				<th>연락처</th>
				<th>배송지주소</th>
				<th>받는사람</th>
			</tr>
			<tr>
				<td>${orderList[0].name}</td>
				<td>${orderList[0].ophone}</td>
				<td>${orderList[0].oaddress}</td>
				<td>${orderList[0].oname}</td>
			</tr>
		</table>
		<table id="cartList">
			<tr style="background-color:#E4F7BA">
				<th>주문일자</th>
				<th>주문번호</th>
				<th>주문 금액</th>
			</tr>
			<tr>
				<td><fmt:formatDate value="${orderList[0].indate}" type="date" /></td>
				<td>${orderList[0].oNum}</td>
				<td><fmt:formatNumber value="${totalPrice}" type="currency" /></td>
			</tr>
		</table>
		<h3 class="order_pro_info">주문 상품 정보</h3>
		<table id="cartList">
			<tr style="background-color:#E4F7BA">
				<th>상품명</th>
				<th>상품별주문번호</th>
				<th>수량</th>
				<th>가격</th>
				<th>처리 상태</th>
				<th>리뷰작성</th>
				<th>주문취소</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td>${orderVO.pName}</td>
					<td>${orderVO.odNum}</td>
					<td>${orderVO.cnt}</td>
					<td><fmt:formatNumber type="currency"
							value="${orderVO.pPrice*orderVO.cnt}" /></td>
					<td><c:choose>
							<c:when test='${orderVO.user_state=="결제완료"}'>
								<c:choose>
									<c:when test='${orderVO.admin_state=="주문완료"}'> 주문완료 </c:when>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test='${orderVO.admin_state=="취소처리"}'>
										<span style='color: red'> 취소완료 </span>
									</c:when>
									<c:when test='${orderVO.admin_state=="취소요청"}'>
										<span style='color: red'> 취소요청 </span>
									</c:when>
									<c:otherwise>
										<span style='color: red'>취소완료</span>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>

					<td><c:choose>
							<c:when test='${orderVO.user_state=="취소요청"}'>
								취소 요청 중 
							</c:when>
							<c:when test='${orderVO.result==1}'>
								<input type="button" value="리뷰작성 " class="re_write_go"
									style="background-color: mistyrose"
									onclick="goReview('${orderVO.pNum}','${orderVO.result}','${orderVO.odNum}')">
							</c:when>
							<c:when test='${orderVO.result==3}'>
								취소 완료
							</c:when>

							<c:otherwise>
                  리뷰 작성 완료&nbsp;<input type="button" value="리뷰수정 "
									class="re_write_go"
									onclick="goReviewUpdate('${orderVO.odNum}','${orderVO.pNum}')">
							</c:otherwise>
						</c:choose></td>

					<td><c:choose>
							<c:when test="${orderVO.user_state=='결제완료'}">
								<input type="button" value="주문취소" class="re_write_go"
									onclick="goCancle('${orderVO.odNum}','${orderVO.user_state}')">
							</c:when>
							<c:when test="${orderVO.user_state=='취소요청'}">
                 				 취소 요청 중
                  </c:when>
							<c:otherwise>
               					   완료
                  </c:otherwise>
						</c:choose> <input type="hidden" name="odNum" value="${orderVO.odNum}">
						<input type="hidden" name="oNum" value="${orderVO.oNum}">
						<input type="hidden" name="pNum" value="${orderVO.pNum}">
						<input type="hidden" name="pName" value="${orderVO.pName}">
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="clear"></div>
		<div>
			<input type="button" value="쇼핑 계속하기" id="my_ing"
				onclick="location.href='MypetServlet?command=index'">
		</div>
	</form>
</article>
<%@ include file="../include/footer.jsp"%>
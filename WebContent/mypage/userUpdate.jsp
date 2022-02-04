<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="mypage/mypage.js"></script>
<script>
function go_delete(){
var con_test = confirm("탈퇴하시겠습니까?");
var concon = confirm("정말 탈퇴하시겠습니까?")
if(con_test == true){
   if(concon == true){
       document.formm.action = "MypetServlet?command=join_remove";
          document.formm.submit();
   }else{
      alert("취소하셨습니다.")
   }
}
else{
      alert("취소하셨습니다.")
}
}

function go_save() {
    if (document.formm.password.value == "") {
    alert("비밀번호를 입력해 주세요.");
    document.formm.pwd.focus();
  } else if ((document.formm.password.value != document.formm.passwordCheck.value)) {
    alert("비밀번호가 일치하지 않습니다.");
    document.formm.pwd.focus();
  } else if (document.formm.name.value == "") {
    alert("이름을 입력해 주세요.");
    document.formm.name.focus();
  } else if (document.formm.email.value == "") {
    alert("이메일을 입력해 주세요.");
    document.formm.email.focus();
  } else {
    document.formm.action = "MypetServlet?command=update_user";
    document.formm.submit();
  }
}
</script>
<article>
	<h2>회원정보수정</h2>
	<form method="post" action="MypetServlet?command=" name="formm">
		<fieldset id="join_field">
			<table id="user_update">
				<tr>
					<th>아이디</th>
					<td>${join_userVO.ID}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password"
						value="${join_userVO.password}"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="passwordCheck"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${join_userVO.name}"></td>
				</tr>
				<tr>
					<th>이메일 주소</th>
					<td><input type="text" name="email"
						value="${join_userVO.email}"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birthday"
						value="${join_userVO.birthday}"></td>
				</tr>
				<tr id="phone_type">
					<th>휴대폰 번호</th>
					<td colspan='2'>
					<input type="number" name="phone1"
						value="${p1}"> - <input type="number" name="phone2" value ="${p2}"> 
						- <input type="number" name="phone3" value ="${p3}"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address"
						value="${join_userVO.address}"></td>
				</tr>
				<tr>
					<th>관심사</th>
					<td><c:forEach items="${cateList}" var="kind"
							varStatus="status">
							<label> <c:choose>
									<c:when test="${join_userVO.cateName==kind}">
										<input type="radio" value="${kind}" name="cateName" checked>
										<c:if test="${kind == 'none'}">관심없음</c:if>
										<c:if test="${kind == 'dog'}">강아지</c:if>
										<c:if test="${kind == 'cat'}">고양이</c:if>
										<c:if test="${kind == 'bird'}">조류</c:if>
										<c:if test="${kind == 'rep'}">파충류</c:if>
									</c:when>
									<c:otherwise>
										<input type="radio" value="${kind}" name="cateName">
										<c:if test="${kind == 'none'}">관심없음</c:if>
										<c:if test="${kind == 'dog'}">강아지</c:if>
										<c:if test="${kind == 'cat'}">고양이</c:if>
										<c:if test="${kind == 'bird'}">조류</c:if>
										<c:if test="${kind == 'rep'}">파충류</c:if>
									</c:otherwise>
								</c:choose></label>

						</c:forEach></td>
				</tr>
			</table>
		</fieldset>
		<div class="clear"></div>
		<div id="user_update_div">
			<input type="button" value="이전 페이지" id="back"
				onclick="history.go(-1)"> <input type="reset" value="지우기"
				id="join_cancle"> <input type="button" value="정보수정"
				onclick="go_save()" id="join_ok"> <input type="button"
				value="회원탈퇴" onclick="go_delete()" id="join_ok">
		</div>
	</form>
</article>
<%@ include file="../include/footer.jsp"%>

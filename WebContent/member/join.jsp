<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="member/member.js"></script>
<script>
function write_email_show(){
	var w = 'write';
	console.log(document.formm.email2.value)
	console.log(w)
	if(document.formm.email2.value==w){
			  document.getElementById('w').style.display = 'block';
		}else{
			  document.getElementById('w').style.display ='none';
	}	
};

function go_save() {
	
	var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
    if (document.formm.password.value == "") {
    alert("비밀번호를 입력해 주세요.");
    document.formm.pwd.focus();
  } else if ((document.formm.password.value != document.formm.passwordCheck.value)) {
    alert("비밀번호가 일치하지 않습니다.");
    document.formm.pwd.focus();
  } else if (document.formm.name.value == "") {
    alert("이름을 입력해 주세요.");
    document.formm.name.focus();
  } else if (document.formm.email1.value == "") {
    alert("이메일을 입력해 주세요.");
    document.formm.email.focus();
  } else if(document.formm.we.value.match(reg) == null){
	alert("이메일 형식이 잘 못 되었습니다.");
    document.formm.email.focus();
  } else {
    document.formm.action = "MypetServlet?command=join";
    document.formm.submit();
  }
}
</script>
<article>
	<h2>회원가입</h2>
	<form action="ypMetServlet?command=join" method="post" name="formm">
		<fieldset id="join_field">
			<table id="join_table">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" size="12"></td>
					<td><input type="hidden" name="reid">
					    <input type="button" value="중복 체크" onclick="idcheck()" id="overlap"
					        style="width:80px; height:35px;"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan='2'><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td colspan='2'><input type="password" name="passwordCheck"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan='2'><input type="text" name="name"></td>
				</tr>
				<tr id="email_type">
					<th>이메일 주소</th>
						<td colspan='2'><input type="text" name="email1">
						<div id="email_sel_div">@
							<select name="email2" onchange="write_email_show()" id="email_sel">
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="write">직접입력</option>
							</select></div>
						<div style="display:none" id="w">
							<input type="text" name="we" style="margin-top: 0px; margin-bottom: 0px;"></div>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan='2'><input type="number" name="birthday" placeholder="19900101"></td>
				</tr>
				<tr id="phone_type">
					<th>휴대폰 번호</th>
					<td colspan='2'>
					<div id="phone_div"><input type="number" name="phone1" maxlength="3" onKeyPress="if(this.value.length==3) return false;"> - 
					<input type="number" name="phone2" maxlength="4" onKeyPress="if(this.value.length==4) return false;"> - 
					<input type="number" name="phone3" maxlength="4" onKeyPress="if(this.value.length==4) return false;"></div></td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan='2'><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>관심사</th>
						<td colspan='2'>
						    <label><input type ="radio" name ="cateName" value ="none">관심없음</label>
						    <label><input type ="radio" name ="cateName" value ="dog">강아지</label>
						    <label><input type ="radio" name ="cateName" value ="cat">고양이</label>
						    <label><input type ="radio" name ="cateName" value ="bird">조류</label>
						    <label><input type ="radio" name ="cateName" value ="rep">파충류</label></td>
				</tr>
			</table>
		</fieldset>
		<div class="clear"></div>
		<div>
			<input type="button" value="이전 페이지" id="back" onclick="history.go(-1)">
			<input type="reset" value="지우기" id="join_cancle">
			<input type="button" value="회원가입" onclick="go_save()" id="join_ok">
		</div>
	</form>
</article>
<%@ include file="../include/footer.jsp"%>

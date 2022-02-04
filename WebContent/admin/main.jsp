<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>welcomepet 관리자 로그인</title>
<link rel="stylesheet" href="admin/css/adminlogin.css">
<script type="text/javascript">
function admin_check()
{
  if(document.frm.adminid.value==""){ /*document.frm.workid해결  */
      alert("아이디를 입력하세요.");
      document.frm.adminid.focus();
      return false;
  }else if(document.frm.adminow.value==""){/*document.frm.workPw해결  */
     alert("비밀번호를 입력하세요.");
     document.frm.adminpw.focus();  
  return false;
    }
    return true;  
}
</script>
</head>

<body>

	<div class="main-container">

		<div class="main-wrap">
			<header>
			<div class="logo-wrap">
				<a href="MypetServlet?command=index"><img
					src="images/admin_logo.png"></a>
			</div>

			</header>
			<section class="login-input-section-wrap">
			<form name="frm" method="post"
				action="MypetServlet?command=admin_login">
				<div class="login-input-wrap">
					<input type="text" placeholder="아이디" name="adminid"></input>
				</div>
				<div class="login-input-wrap password-wrap">
					<input placeholder="비밀번호" type="password" name="adminpw"></input>
				</div>

				<div class="login-button-wrap">
					<button>관리자 로그인</button>
					<br>
					<br>
					<h4 style="color: red">${message}</h4>
			</form>
		</div>

	</div>




	</section>

	</div>

</body>

</html>
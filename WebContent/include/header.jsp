<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome pet</title>
<script>
function go_search() {
	var theForm = document.frm;
	theForm.action = "MypetServlet?command=search";
	theForm.submit();
}
</script>
<link href="./css/mypet.css" rel="stylesheet">
</head>
<body>
<form name="frm" method="post">
	<div id="wrap">
		<header>
			<div id="catagory_menu">
				<ul class="right_menu">
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}">
							<li><a href="MypetServlet?command=login_form">로그인</a></li>

							<li><a href="MypetServlet?command=contract">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li style="color: orange; transform:translateY(-10px)">
								${sessionScope.loginUser.name}님(${sessionScope.loginUser.ID})</li>
							<li><a href="MypetServlet?command=logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>

					<li><a href="MypetServlet?command=cart_list">장바구니</a></li>
					<li><a href="MypetServlet?command=mypage">마이페이지</a></li>
					<li><a href="MypetServlet?command=qna_list">고객센터</a></li>
				</ul>
			</div>
			
			<div id="logo">
				<a href="MypetServlet?command=index"> 
				<img src="./images/logo.jpg">
				</a>
			</div>
			
			<div class="search_area">
				<div class="search_form">
					<input type="text" name="searchValue" class="searchTerm" placeholder="원하는 상품을 검색해보세요."> 
					<button class="searchButton" type="submit" name="btn_search" value="검색" onClick="go_search()">
						<i class="search"></i>
					</button>
				</div>
			</div>


			<div class="aa">
				<div class="top_box">
					<a href="MypetServlet?command=dog" class="dog_box">강아지</a> 
					<a href="MypetServlet?command=cat" class="cat_box">고양이</a>
				</div>
				<div class="bottom_box">
					<a href="MypetServlet?command=bird" class="bird_box">조류</a> 
					<a href="MypetServlet?command=rep" class="rep_box">파충류</a>
				</div>
			</div>

			<div class="clear"></div>

		</header>
	</div>
</form>
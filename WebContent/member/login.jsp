<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../include/header.jsp" %>  
  <article>
    <h2>로그인</h2>
    <form method="post" action="MypetServlet?command=login">
        <fieldset id="login_field">
        <legend></legend>
          <input name="id" type="text" value="${id}" placeholder="아이디"><br> 
          <input name="pwd" type="password" placeholder="비밀번호"><br> 
        </fieldset>
        <div class="clear"></div>
        <div>
            <input type="submit" value="로그인" id="login_btn">
            <input type="button" value="회원가입" onclick="location='MypetServlet?command=contract'"
                   id="cons_btn">
        </div>
    </form>  
  </article>
<%@ include file="../include/footer.jsp" %>      

package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.controller.action.Action;
import com.mypet.dao.AdminDAO;

public class AdminLoginAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "MypetServlet?command=admin_login_form";
    String msg = "";
    String adminid = request.getParameter("adminid").trim();
    String adminpw = request.getParameter("adminpw").trim();

    AdminDAO adminDAO = AdminDAO.getInstance();

    int result = adminDAO.AdminCheck(adminid, adminpw);
    
    if (result == 1) {
      HttpSession session = request.getSession();
      session.setAttribute("adminid", adminid);
      url = "MypetServlet?command=admin_product_list";
    } else if (result == 0) {
      msg = "비밀번호를 확인하세요";
    } else if (result == -1) {
      msg = "아이디를 확인하세요";	
    }
    request.setAttribute("message", msg);
    request.getRequestDispatcher(url).forward(request, response);
  }
}
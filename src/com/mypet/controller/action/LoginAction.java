package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.Join_UserVO;
public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="member/login_fail.jsp";
		HttpSession session=request.getSession();

		String id2=request.getParameter("id");
		String pwd=request.getParameter("pwd");

		Join_UserDAO memberDAO=Join_UserDAO.getInstance();
		Join_UserVO memberVO=memberDAO.getUser(id2);

		if(memberVO!=null){
			if(memberVO.getPassword().equals(pwd)){    
				session.removeAttribute("id");
				session.setAttribute("loginUser", memberVO);
				url="MypetServlet?command=index";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);  
	}
}

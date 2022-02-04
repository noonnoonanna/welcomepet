package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.Join_UserVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/joinSuccess.jsp"; 

		HttpSession session = request.getSession();
		
		String p1 = "";
		for(int i=1; i<4; i++) {
			p1 += request.getParameter("phone"+i);
			if(i==3) {
				break;
			}
			p1 += "-";
		}
		
		String e = "";
		
		if(request.getParameter("we") == null) {
			for(int i=1; i<3; i++) {
				e += request.getParameter("email"+i);
				if(i==2) {
					break;
				}
				e += "@";
			}	
		}else {
			e = request.getParameter("email1")+"@";
			e += request.getParameter("we");
		}
		
				
		Join_UserVO join_UserVO = new Join_UserVO();
		join_UserVO.setID(request.getParameter("id"));
		join_UserVO.setPassword(request.getParameter("password"));
		join_UserVO.setName(request.getParameter("name"));
		join_UserVO.setBirthday(request.getParameter("birthday"));
		join_UserVO.setPhone(p1);    
		join_UserVO.setAddress(request.getParameter("address"));
		join_UserVO.setEmail(e);
		join_UserVO.setCateName(request.getParameter("cateName"));

		session.setAttribute("id", request.getParameter("id"));    

		Join_UserDAO join_UserDAO = Join_UserDAO.getInstance();
		join_UserDAO.insertJoin_User(join_UserVO);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.Join_UserVO;

public class UserUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		Join_UserVO join_UserVO = new Join_UserVO();
		join_UserVO.setID(loginUser.getID());
		join_UserVO.setPassword(request.getParameter("password"));
		System.out.println(request.getParameter("password"));
		join_UserVO.setName(request.getParameter("name"));
		System.out.println(request.getParameter("name"));
		join_UserVO.setBirthday(request.getParameter("birthday"));
		System.out.println(request.getParameter("birthday"));
		join_UserVO.setPhone(request.getParameter("phone"));
		System.out.println(request.getParameter("phone"));
		join_UserVO.setAddress(request.getParameter("address"));
		System.out.println(request.getParameter("address"));
		join_UserVO.setEmail(request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		join_UserVO.setCateName(request.getParameter("cateName"));
		System.out.println(request.getParameter("cateName"));
		session.setAttribute("join_userVO", join_UserVO);
		
		
		Join_UserDAO join_UserDAO = Join_UserDAO.getInstance();
		join_UserDAO.userUpdate(join_UserVO);
		request.setAttribute("join_userVO", join_UserVO);
		
		new MyPageAction().execute(request, response);
	}
}

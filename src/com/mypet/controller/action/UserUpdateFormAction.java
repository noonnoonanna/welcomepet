package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.Join_UserVO;

public class UserUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage/userUpdate.jsp"; 
		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		Join_UserVO join_UserVO = new Join_UserVO();
		Join_UserDAO join_UserDAO = Join_UserDAO.getInstance();
		join_UserVO = join_UserDAO.getUser(loginUser.getID());

		String p1 = join_UserVO.getPhone();
		
		String p[] = p1.split("-");
		for(int i=0; i<3; i++) {
			System.out.println(p[i]);
		}
		
		String[] catename = {"none","dog","cat","bird","rep"};
		System.out.println(join_UserVO.toString()+"....");
		System.out.println(catename.toString()+"....");
		request.setAttribute("join_userVO", join_UserVO);
		request.setAttribute("cateList", catename);
		request.setAttribute("p1", p[0]);
		request.setAttribute("p2", p[1]);
		request.setAttribute("p3", p[2]);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

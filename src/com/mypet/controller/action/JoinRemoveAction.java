package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.Join_UserVO;

public class JoinRemoveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/removejoin.jsp";
		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		Join_UserDAO join = Join_UserDAO.getInstance();
		ArrayList<Integer> oNumList =  join.selectOnum(loginUser.getID());
		for(int oNum : oNumList) {
			join.deleteOnum(oNum);
		}
		join.deleteUser(loginUser.getID());

		session.invalidate();
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}

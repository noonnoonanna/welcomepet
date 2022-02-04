package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.Join_UserDAO;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/member/idcheck.jsp";  

		String id = request.getParameter("id").trim();

		Join_UserDAO memberDAO = Join_UserDAO.getInstance();
		int message = memberDAO.confirmID(id);

		request.setAttribute("message", message);
		request.setAttribute("id", id);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

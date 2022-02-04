package com.mypet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;

@WebServlet("/MypetServlet")
public class MypetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("\nMypetServlet���� ��û�� ������ Ȯ�� : " + command);

		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		if (action != null) {
			System.out.println("action != null...."+action.getClass());
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("\nMypetServlet/doPost() ...."+request.getRequestURL());
		doGet(request, response);
	}
}


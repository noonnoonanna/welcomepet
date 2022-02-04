package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.P_orderDAO;
import com.mypet.dto.Join_UserVO;


public class OrderDirectInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "MypetServlet?command=order_list";    

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			P_orderDAO orderDAO = P_orderDAO.getInstance();
			int pNum = Integer.parseInt(request.getParameter("pNum"));
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			String oname = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address =request.getParameter("address");

			orderDAO.insertOrder(loginUser.getID());
			int max = orderDAO.getoNum();
			orderDAO.directOrder(max, pNum, cnt,oname,phone,address);
			url = "MypetServlet?command=order_list&oNum="+max;
		}
		response.sendRedirect(url);
	}
}

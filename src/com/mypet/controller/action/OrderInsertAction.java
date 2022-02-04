package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.CartDAO;
import com.mypet.dao.P_orderDAO;
import com.mypet.dto.Join_UserVO;


public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "MypetServlet?command=order_list";    

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			String name = request.getParameter("name");
	    	String phone =request.getParameter("phone");
	    	String addr =request.getParameter("address");
			CartDAO cartDAO = CartDAO.getInstance();
			ArrayList<Integer> cNumArry = cartDAO.getcNum(loginUser.getID());
			P_orderDAO orderDAO = P_orderDAO.getInstance();
			orderDAO.insertOrder(loginUser.getID());
			int max = orderDAO.getoNum();
			for(int cNum : cNumArry) {
				orderDAO.insertDetailOrder(cartDAO.selectCart(loginUser.getID(), cNum), max,name,phone,addr);
		    	cartDAO.deleteCart(cNum);
			}    	
			url = "MypetServlet?command=order_list&oNum="+max;
		}
		response.sendRedirect(url);
	}
}

package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.P_orderDAO;
import com.mypet.dto.Join_UserVO;
import com.mypet.dto.P_orderVO;


public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage/orderList.jsp";

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");    
		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			P_orderDAO orderDAO = P_orderDAO.getInstance();
			int oseq=Integer.parseInt(request.getParameter("oNum"));
			ArrayList<P_orderVO> orderList = orderDAO.listOrderById(loginUser.getID(), oseq);

			int totalPrice=0;
			for(P_orderVO orderVO :orderList){
				totalPrice+=orderVO.getpPrice()*orderVO.getCnt();
				System.out.println(orderVO.toString());
			}
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}

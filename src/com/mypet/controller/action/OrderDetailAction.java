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


public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage/orderDetail.jsp";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			int oNum=Integer.parseInt(request.getParameter("oNum"));
			P_orderDAO orderDAO = P_orderDAO.getInstance();
			ArrayList<P_orderVO> orderList = orderDAO.listOrderById(loginUser.getID(), oNum);

			int totalPrice=0;
			for(P_orderVO ovo :orderList){
				totalPrice+=ovo.getpPrice()*ovo.getCnt();
			}
			request.setAttribute("orderDetail", orderList.get(0));  
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
			System.out.println(orderList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}    
}

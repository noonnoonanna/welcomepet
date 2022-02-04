package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.CategoryDAO;
import com.mypet.dao.P_orderDAO;
import com.mypet.dto.Join_UserVO;
import com.mypet.dto.P_orderVO;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage/mypage.jsp";

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			P_orderDAO orderDAO = P_orderDAO.getInstance();
			ArrayList<Integer> oNumList = orderDAO.selectoNumIng(loginUser.getID());
			System.out.println(oNumList+"....");
			ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();

			for (int oNum : oNumList) {
				ArrayList<P_orderVO> orderListIng = orderDAO.listOrderById(loginUser.getID(), oNum);
				P_orderVO orderVO = orderListIng.get(0);
				orderVO.setpName(orderVO.getpName() + " 외" +orderListIng.size() + "건");
				int totalPrice = 0;
				for(P_orderVO ovo : orderListIng) {
					totalPrice += ovo.getpPrice() * ovo.getCnt();
				}
				orderVO.setpPrice(totalPrice);
				orderList.add(orderVO);
			}
			CategoryDAO categoryDAO = CategoryDAO.getInstance();
			String cateName = categoryDAO.selectCateName(loginUser.getID());
			request.setAttribute("title","진행 중인 주문 내역");
			request.setAttribute("orderList",orderList);
			request.setAttribute("cateName", cateName);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}


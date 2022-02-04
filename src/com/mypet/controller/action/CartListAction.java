package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.CartDAO;
import com.mypet.dao.CategoryDAO;
import com.mypet.dto.CartVO;
import com.mypet.dto.Join_UserVO;


public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage/cartList.jsp";
		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			CartDAO cartDAO = CartDAO.getInstance();
			ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getID());

			int totalPrice = 0;
			for (CartVO cartVO : cartList) {
				totalPrice += cartVO.getpPrice() * cartVO.getCnt();
			}

			CategoryDAO categoryDAO = CategoryDAO.getInstance();
			String cateName  = categoryDAO.selectCateName(loginUser.getID());
			request.setAttribute("cartList", cartList);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("cateName", cateName);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}

package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.CartDAO;
import com.mypet.dto.CartVO;
import com.mypet.dto.Join_UserVO;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "MypetServlet?command=cart_list";

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "MypetServlet?command=login_form";
		} else {
			CartVO cartVO = new CartVO();
			cartVO.setId(loginUser.getID());
			cartVO.setpNum_cart(Integer.parseInt(request.getParameter("pNum")));
			cartVO.setCnt(Integer.parseInt(request.getParameter("cnt")));

			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.insertCart(cartVO);
		}
		response.sendRedirect(url);
	}
}

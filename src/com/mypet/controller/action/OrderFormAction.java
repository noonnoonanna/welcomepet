package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.CartDAO;
import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.CartVO;
import com.mypet.dto.Join_UserVO;

public class OrderFormAction implements Action {

		 @Override
		  public void execute(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    String url = "mypage/orderForm.jsp";    
		    
		    HttpSession session = request.getSession();
		    Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		    
		    if (loginUser == null) {
		      url = "MypetServlet?command=login_form";
		    } else {
		    	CartDAO cartDAO = CartDAO.getInstance();
				ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getID());
				Join_UserDAO join_UserDAO = Join_UserDAO.getInstance();
				Join_UserVO join_UserVO = new Join_UserVO();
				join_UserVO = join_UserDAO.getUser(loginUser.getID());
				int totalPrice = 0;
				for (CartVO cartVO : cartList) {
					totalPrice += cartVO.getpPrice() * cartVO.getCnt();
				}
				System.out.println(join_UserVO.toString()+"....");
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("cartList", cartList);
				request.setAttribute("user", join_UserVO);
		    
		    }
		    request.getRequestDispatcher(url).forward(request, response);
		 }
	}
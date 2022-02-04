package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.Join_UserDAO;
import com.mypet.dao.ProductDAO;
import com.mypet.dto.Join_UserVO;
import com.mypet.dto.ProductVO;

public class OrderDirectFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage/orderDirectForm.jsp";    

		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		System.out.println(pNum+"....");
		System.out.println(cnt+"....");
		if (loginUser == null) {
			url = "MypetServlet?command=order_direct_insert";
		} else {
			Join_UserDAO join_UserDAO = Join_UserDAO.getInstance();
			Join_UserVO join_UserVO = new Join_UserVO();

			join_UserVO = join_UserDAO.getUser(loginUser.getID());
			ProductDAO productDAO = ProductDAO.getInstance();

			ProductVO productVO = new ProductVO(); 
			productVO = productDAO.getProductDetail(pNum);

			int totalPrice = cnt*productVO.getpPrice();
			System.out.println(join_UserVO.toString()+"....");
			System.out.println(productVO.toString()+".....");
			request.setAttribute("product",productVO );
			request.setAttribute("user", join_UserVO);
			request.setAttribute("cnt", cnt);
			request.setAttribute("totalPrice", totalPrice);

		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
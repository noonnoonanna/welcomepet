package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.ProductDAO;
import com.mypet.dto.Join_UserVO;

public class ReviewWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String url = "review/review_write.jsp";    
		    
		    HttpSession session = request.getSession();
		    Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		    if (loginUser == null) {
		      url = "MypetServlet?command=login_form";
		    } else {
		    	ProductDAO productDAO = ProductDAO.getInstance();
		    	int pNum = Integer.parseInt(request.getParameter("pNum"));
		    	String pName = productDAO.selectpName(pNum);
		    	String[] rating = {"0","1","2","3","4","5"};
		    	request.setAttribute("rating",rating);
		    	request.setAttribute("pNum", pNum);
		    	request.setAttribute("pName", pName);
		    	
		    }
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

}

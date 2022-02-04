package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.ProductDAO;
import com.mypet.dao.ReviewDAO;
import com.mypet.dto.ReviewVO;

public class ReviewUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "review/review_update.jsp";
		int odNum = Integer.parseInt(request.getParameter("odNum"));
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		ReviewVO reviewVO = reviewDAO.updateSelect(odNum);
		ProductDAO productDAO = ProductDAO.getInstance();
		String pName = productDAO.selectpName(pNum);
		String[] rating = {"0","1","2","3","4","5"};
		request.setAttribute("pName",pName);
		request.setAttribute("review",reviewVO);
		request.setAttribute("rating", rating);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}

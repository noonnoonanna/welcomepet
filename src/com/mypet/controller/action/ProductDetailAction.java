package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.ProductDAO;
import com.mypet.dao.ReviewDAO;
import com.mypet.dto.ProductVO;
import com.mypet.dto.ReviewVO;


public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="product/productDetail.jsp";
		
		int pNum=Integer.parseInt(request.getParameter("pNum").trim());

		ReviewDAO reviewDAO = ReviewDAO.getInstance(); 
		ArrayList<ReviewVO> reviewList = reviewDAO.selectReview(pNum);

		ProductDAO productDAO=ProductDAO.getInstance();
		ProductVO productVO= productDAO.getProductDetail(pNum);

		request.setAttribute("productVO", productVO);
		request.setAttribute("reviewList",reviewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

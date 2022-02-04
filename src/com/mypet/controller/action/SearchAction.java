package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.ProductDAO;
import com.mypet.dto.ProductVO;

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/productList.jsp";  
		String pName =  request.getParameter("searchValue");
		
		ArrayList<ProductVO> productVo = new ArrayList<ProductVO>();
		ProductDAO productDAO = ProductDAO.getInstance();
		productVo = productDAO.searchProduct(pName);
		
		request.setAttribute("ProductList", productVo);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.ProductDAO;
import com.mypet.controller.action.Action;
import com.mypet.dto.ProductVO;

public class AdminProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "admin/product/productUpdate.jsp";

		 int pseq = Integer.parseInt(request.getParameter("pNum").trim());

		ProductDAO productDAO = ProductDAO.getInstance();
		//ArrayList<ProductVO> productList = productDAO.admingetProduct();
		ProductVO productList = productDAO.admingetProductDetail(pseq);
		request.setAttribute("productVO", productList);

		String tpage = "1";
		if (request.getParameter("tpage") != null) {
			tpage = request.getParameter("tpage");
		}
		request.setAttribute("tpage", tpage);

		String kindList[] = { "사료","간식","용품" };    
		String cateCodeList[] = {"강아지","고양이","새","파충류"};
		
		request.setAttribute("kindList", kindList);
		request.setAttribute("cateCodeList", cateCodeList);
		request.getRequestDispatcher(url).forward(request, response);
	}
}

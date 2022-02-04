package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.ProductDAO;
import com.mypet.controller.action.Action;
import com.mypet.dto.ProductVO;

public class AdminProductDetailAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/product/productDetail.jsp";

    int pseq = Integer.parseInt(request.getParameter("pNum").trim());
   System.out.println(pseq);
    
    /*ProductDAO productDAO = ProductDAO.getInstance();
    ProductVO productVO = productDAO.getProduct(pseq);

    request.setAttribute("productVO", productVO);*/
    
    ProductDAO productDAO = ProductDAO.getInstance();
	ProductVO productList = productDAO.admingetProductDetail(pseq);
	request.setAttribute("productVO", productList);
    String tpage = "1";
    if (request.getParameter("tpage") != null) {
      tpage = request.getParameter("tpage");
    }
    String kindList[] = { "0", "사료", "간식", "용품", };
    request.setAttribute("tpage", tpage);
    request.setAttribute("kind", kindList);
    request.getRequestDispatcher(url).forward(request, response);
  }
}

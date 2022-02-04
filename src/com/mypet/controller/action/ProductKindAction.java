package com.mypet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.ProductDAO;
import com.mypet.dto.ProductVO;

public class ProductKindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url1="/dog_main.jsp";
		String url2="/cat_main.jsp";
		String url3="/bird_main.jsp";
		String url4="/rep_main.jsp";

		String cateName = request.getParameter("cateName").trim();
		String kind = request.getParameter("kind").trim();

		if(kind.equals("1")) {
			kind = "사료";
		}else if(kind.equals("2")) {
			kind = "간식";
		}else if(kind.equals("3")) {
			kind = "용품";
		}

		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO>productKindList= productDAO.listKindProduct(cateName, kind);

		request.setAttribute("productKindList", productKindList);
		request.setAttribute("catename", cateName);
		request.setAttribute("kind", kind);

		if(cateName.equals("dog")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url1);
			dispatcher.forward(request, response);
		}else if(cateName.equals("cat")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url2);
			dispatcher.forward(request, response);
		}else if(cateName.equals("bird")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url3);
			dispatcher.forward(request, response);
		}else if(cateName.equals("rep")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url4);
			dispatcher.forward(request, response);
		}
	}
}

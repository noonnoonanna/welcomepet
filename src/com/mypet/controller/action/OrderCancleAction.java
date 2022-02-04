package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.P_orderDAO;

public class OrderCancleAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int odNum = Integer.parseInt(request.getParameter("odNum"));
		int oNum = Integer.parseInt(request.getParameter("oNum"));
		System.out.println(oNum + " oNum.........");
		System.out.println(odNum + "odNUm");
		P_orderDAO p_orderDAO = P_orderDAO.getInstance();
		p_orderDAO.orderCancleConfirm(odNum);
		System.out.println("OrderCancle 여기까지 됐나요?");
		new OrderDetailAction().execute(request, response);
	}

}

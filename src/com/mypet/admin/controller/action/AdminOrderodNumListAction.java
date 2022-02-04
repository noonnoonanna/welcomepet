package com.mypet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.P_orderDAO;
import com.mypet.dto.P_orderVO;

public class AdminOrderodNumListAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/p_order/p_RankList.jsp";
    String key = "";
    if (request.getParameter("key") != null) {
      key = request.getParameter("key");
    }

    P_orderDAO p_orderDAO = P_orderDAO.getInstance();
    ArrayList<P_orderVO> p_orderList = p_orderDAO.oNumRank(key);

    request.setAttribute("p_orderList", p_orderList);

    request.getRequestDispatcher(url).forward(request, response);
    
    
    
  }
}

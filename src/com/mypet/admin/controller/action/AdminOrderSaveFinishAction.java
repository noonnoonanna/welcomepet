package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.P_orderDAO;
public class AdminOrderSaveFinishAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String url = "MypetServlet?command=admin_order_list";
      
      String[] resultArr = request.getParameterValues("admin_state");
      
      for(String oseq:resultArr){
        System.out.println(oseq);
        P_orderDAO orderDAO = P_orderDAO.getInstance();
        orderDAO.updateFinishOrderResult(oseq);
      }
      request.getRequestDispatcher(url).forward(request, response);
    }
}

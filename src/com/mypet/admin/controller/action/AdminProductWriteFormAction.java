package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;

public class AdminProductWriteFormAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/product/productWrite.jsp";
    String kindList[] = {"사료","간식","용품"};    
    String cateCodeList[] = {"강아지","고양이","새","파충류"};
    
    request.setAttribute("kindList", kindList);
    request.setAttribute("cateCodeList", cateCodeList);
    request.getRequestDispatcher(url).forward(request, response);
   
    
  }
}

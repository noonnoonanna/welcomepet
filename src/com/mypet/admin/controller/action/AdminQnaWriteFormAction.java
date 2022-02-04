package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;

public class AdminQnaWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaWrite.jsp";
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	

}

package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.QnaDAO;
import com.mypet.dto.QnaVO;

public class AdminQnaUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin//qna/qnaUpdate.jsp";
		
		
		int qno = Integer.parseInt(request.getParameter("qNo"));
		
		QnaDAO qDao = QnaDAO.getInstance();
		
		 QnaVO qVo = qDao.getQna(qno); 
		
		request.setAttribute("qna", qVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
		
	}

}

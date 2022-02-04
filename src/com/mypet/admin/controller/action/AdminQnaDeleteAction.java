package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.QnaDAO;

public class AdminQnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int qno = Integer.parseInt(request.getParameter("qNo"));
		System.out.println(qno+".......");
		QnaDAO qDao = QnaDAO.getInstance();
		qDao.deleteqna(qno);
		
		new AdminQnaListAction().execute(request, response);
		

	}

}

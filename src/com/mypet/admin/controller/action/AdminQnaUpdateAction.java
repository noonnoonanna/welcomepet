package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.QnaDAO;
import com.mypet.dto.QnaVO;

public class AdminQnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	QnaVO qVo = new QnaVO();
	
	qVo.setqNo(Integer.parseInt(request.getParameter("qNo")));
	qVo.setqTitle(request.getParameter("qTitle"));
	qVo.setqContent(request.getParameter("qContent"));
	
	QnaDAO qDao = QnaDAO.getInstance();
	qDao.updateqna(qVo);
	
	

	new AdminQnaListAction().execute(request, response);
		
		
	}

	
	}



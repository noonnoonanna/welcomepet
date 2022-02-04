package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.MtmDAO;

public class AdminMtmDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		MtmDAO mDao = MtmDAO.getInstance();
		mDao.deletemtm(qseq);
		
		new AdminMtmListAction().execute(request, response);

	}

}

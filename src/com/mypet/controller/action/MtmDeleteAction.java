package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.MtmDAO;

public class MtmDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		System.out.println("ªË¡¶");
		MtmDAO mDao = MtmDAO.getInstance();
		mDao.deletemtm(qseq);
		
		new MtmListAction().execute(request, response);

	}

}

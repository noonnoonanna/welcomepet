package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.dao.MtmDAO;
import com.mypet.dto.MtmVO;

public class MtmUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mtm/mtmUpdate.jsp";
		

		
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		
		MtmDAO mDao = MtmDAO.getInstance();
		
		
		 MtmVO mVo = mDao.getMtm(qseq);
		 
		request.setAttribute("mtm", mVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
		
	}

}

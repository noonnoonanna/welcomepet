package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.MtmDAO;
import com.mypet.dto.MtmVO;

public class AdminMtmDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url ="admin/mtm/mtmDetail.jsp";
		
		String qseq = request.getParameter("qseq").trim();
		
		MtmDAO mtmDAO = MtmDAO.getInstance();
		MtmVO mtmVO = mtmDAO.getMtm(Integer.parseInt(qseq));
		
		request.setAttribute("mtmVO", mtmVO);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}

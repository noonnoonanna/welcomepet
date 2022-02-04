package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.MtmDAO;
import com.mypet.dto.MtmVO;

public class AdminMtmResaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "MypetServlet?command=admin_mtm_list";
			
		
		String qseq = request.getParameter("qseq").trim();
		String reply = request.getParameter("reply").trim();
		
		MtmVO mtmVO = new MtmVO();
		mtmVO.setQseq(Integer.parseInt(qseq));
		mtmVO.setReply(reply);
		
		MtmDAO mtmDAO = MtmDAO.getInstance();
		mtmDAO.updateMtm(mtmVO);
		
		response.sendRedirect(url);

	}

}

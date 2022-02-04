package com.mypet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.MtmDAO;
import com.mypet.dto.MtmVO;

public class AdminMtmListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/mtm/mtmList.jsp";
		
		MtmDAO mtmDAO = MtmDAO.getInstance();
		ArrayList<MtmVO> mtmList = mtmDAO.listAllMtm();
		
		request.setAttribute("mtmList", mtmList);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}

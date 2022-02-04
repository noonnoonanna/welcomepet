package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.MtmDAO;
import com.mypet.dto.Join_UserVO;
import com.mypet.dto.MtmVO;

public class MtmViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="mtm/mtmView.jsp";
		
		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "MypetServlet?command=login_form";
		}else {
			int qseq = Integer.parseInt(request.getParameter("qseq"));
			MtmDAO mtmDAO = MtmDAO.getInstance();
			MtmVO mtmVO = mtmDAO.getMtm(qseq);
			request.setAttribute("mtmVO", mtmVO);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}

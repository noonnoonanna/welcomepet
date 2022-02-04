package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.MtmDAO;
import com.mypet.dto.Join_UserVO;
import com.mypet.dto.MtmVO;

public class MtmWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "MypetServlet?command=mtm_list";
		
		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "MypetServlet?command=login_form";
		}else {
			MtmVO mtmVO = new MtmVO();
			mtmVO.setTitle(request.getParameter("title"));
			mtmVO.setContent(request.getParameter("content"));
			MtmDAO mtmDAO = MtmDAO.getInstance();
			mtmDAO.insertmtm(mtmVO, loginUser.getID());
		}
		response.sendRedirect(url);
	}

}

package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dto.Join_UserVO;

public class MtmWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mtm/mtmWrite.jsp";
		
		
		HttpSession  session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "MypetServlet?command=login_form";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}

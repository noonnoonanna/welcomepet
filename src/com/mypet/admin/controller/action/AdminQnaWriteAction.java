package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.QnaDAO;
import com.mypet.dto.QnaVO;

public class AdminQnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "MypetServlet?command=admin_qna_list";
		

			
			QnaVO qnaVO = new QnaVO();
		
			qnaVO.setqTitle(request.getParameter("qTitle"));
			qnaVO.setqContent(request.getParameter("qContent"));
		
			QnaDAO qnaDAO = QnaDAO.getInstance();
			qnaDAO.insertqna(qnaVO);
		
			response.sendRedirect(url);
		
	}
}

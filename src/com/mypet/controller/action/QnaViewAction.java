package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mypet.dao.QnaDAO;
import com.mypet.dto.QnaVO;

public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaView.jsp";
	
		
		
			int qNo = Integer.parseInt(request.getParameter("qNo").trim());
			System.out.println(qNo+"....");
			QnaDAO qnaDAO =  QnaDAO.getInstance();
			QnaVO qnaVO = qnaDAO.getQna(qNo);
			request.setAttribute("qnaVO",qnaVO);
			
			System.out.println(qnaVO.toString());
		
		request.getRequestDispatcher(url).forward(request, response);	
	}

}

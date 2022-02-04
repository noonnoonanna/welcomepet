package com.mypet.controller.action;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mypet.dao.QnaDAO;
import com.mypet.dto.QnaVO;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="qna/qnaList.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		ArrayList<QnaVO> qnaList =  qnaDAO.listQna();
		request.setAttribute("qnaList", qnaList);
		
			
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}

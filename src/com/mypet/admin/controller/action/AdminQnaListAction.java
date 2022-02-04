package com.mypet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.QnaDAO;
import com.mypet.dto.QnaVO;

public class AdminQnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/qna/adminqnaList.jsp";
		QnaDAO qnaDAO = QnaDAO.getInstance();
		ArrayList<QnaVO> qnaList =  qnaDAO.listQna();
		request.setAttribute("qnaList", qnaList);
		
		
			
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}

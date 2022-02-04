package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.MtmDAO;
import com.mypet.dto.MtmVO;

public class AdminMtmUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		  MtmVO mtmVO = new MtmVO();
		 
		  mtmVO.setQseq(Integer.parseInt(request.getParameter("qseq")));
		  System.out.println(request.getParameter("title")+".....");
		  mtmVO.setReply(request.getParameter("reply"));
		  System.out.println(request.getParameter("content"));
		  mtmVO.setTitle(request.getParameter("title"));
		  mtmVO.setContent(request.getParameter("content"));
		  
		  MtmDAO mDao = MtmDAO.getInstance();
		  mDao.updateMtm(mtmVO);
		  
		  new AdminMtmListAction().execute(request, response);
		 
	 }	
	}


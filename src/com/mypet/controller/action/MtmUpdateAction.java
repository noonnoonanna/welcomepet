package com.mypet.controller.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mypet.dao.MtmDAO;
import com.mypet.dto.MtmVO;


public class MtmUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	MtmVO mVo = new MtmVO();
	
	mVo.setQseq(Integer.parseInt(request.getParameter("qseq")));
	mVo.setTitle(request.getParameter("title"));
	mVo.setContent(request.getParameter("content"));
	
	MtmDAO mDao = MtmDAO.getInstance();
	mDao.adminupdateMtm(mVo);
	
		
		new MtmListAction().execute(request, response);
		
		
	}

	
	}



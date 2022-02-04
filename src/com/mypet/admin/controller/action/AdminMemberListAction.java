package com.mypet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.Join_UserDAO;
import com.mypet.dto.Join_UserVO;


public class AdminMemberListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "admin/Join_User/Join_UserList.jsp";
		String key = "";
		if (request.getParameter("key") != null) {
		      key = request.getParameter("key");
		    }

		    Join_UserDAO Join_userDAO = Join_UserDAO.getInstance();
		    ArrayList<Join_UserVO> join_UserList = Join_userDAO.listJoin_User(key);

		    request.setAttribute("join_UserList", join_UserList);

		    request.getRequestDispatcher(url).forward(request, response);
		  }
		}

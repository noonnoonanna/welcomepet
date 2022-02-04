package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.P_orderDAO;
import com.mypet.dao.ReviewDAO;
import com.mypet.dto.Join_UserVO;
import com.mypet.dto.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ReviewInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="MypetServlet?command=mypage";
		HttpSession session = request.getSession();
		Join_UserVO loginUser = (Join_UserVO) session.getAttribute("loginUser");

		int sizeLimit = 5 * 1024 * 1024;
		String savePath = "review";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8",new DefaultFileRenamePolicy()); 
		System.out.println("여기까지가 끝인가보오");
		System.out.println(Integer.parseInt(request.getParameter("pNum")));
		System.out.println(loginUser.getID());
		int odNum = Integer.parseInt(request.getParameter("odNum"));
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setID(loginUser.getID());
		reviewVO.setpNum(Integer.parseInt(request.getParameter("pNum")));
		reviewVO.setOdNum(Integer.parseInt(request.getParameter("odNum")));
		reviewVO.setContent(multi.getParameter("content"));
		reviewVO.setrImg(multi.getFilesystemName("rImg"));
		reviewVO.setRating(multi.getParameter("rating"));

		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		System.out.println(reviewVO.toString());
		reviewDAO.insertReview(reviewVO);
		P_orderDAO p_orderDAO = P_orderDAO.getInstance();
		p_orderDAO.changeResult(odNum);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}

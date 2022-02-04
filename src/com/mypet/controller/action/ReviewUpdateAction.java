package com.mypet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.dao.ReviewDAO;
import com.mypet.dto.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="MypetServlet?command=mypage";
		
		HttpSession session = request.getSession();

		int sizeLimit = 5 * 1024 * 1024;
		String savePath = "review";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("¹¹Áö?");
		System.out.println(Integer.parseInt(request.getParameter("rNum")));
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8",new DefaultFileRenamePolicy()); 
	    ReviewVO reviewVO = new ReviewVO();
	    reviewVO.setrNum(Integer.parseInt(request.getParameter("rNum")));
	    reviewVO.setContent(multi.getParameter("content"));
	    reviewVO.setrImg(multi.getFilesystemName("rImg"));
	    reviewVO.setRating(multi.getParameter("rating"));
	    System.out.println(reviewVO+".....");
	    ReviewDAO reviewDAO = ReviewDAO.getInstance();
	    reviewDAO.updateReview(reviewVO);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}

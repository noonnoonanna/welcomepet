package com.mypet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypet.controller.action.Action;
import com.mypet.dao.ProductDAO;
import com.mypet.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class AdminProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "MypetServlet?command=admin_product_list";
		
		HttpSession session = request.getSession();

		int sizeLimit = 5 * 1024 * 1024;
		String savePath = "images/product_img";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("가상폴더..................."+uploadFilePath);
		System.out.println("실제폴더................"+savePath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8",new DefaultFileRenamePolicy()); 
		
		
		ProductVO productVO = new ProductVO();
		productVO.setpName(multi.getParameter("pName"));
		productVO.setpPrice(Integer.parseInt(multi.getParameter("pPrice")));
		productVO.setCP(multi.getParameter("CP"));
		productVO.setpInfo(multi.getParameter("pInfo"));
		productVO.setCateCode(multi.getParameter("cateCode"));
		productVO.setCateName(multi.getParameter("cateName"));
		productVO.setKind(multi.getParameter("kind"));
		productVO.setpImg(multi.getFilesystemName("pImg"));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.insertProduct(productVO);

		response.sendRedirect(url);
	}
}

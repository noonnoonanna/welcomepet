package com.mypet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypet.controller.action.Action;
import com.mypet.dao.ProductDAO;
import com.mypet.dto.ProductVO;

public class AdminProductSearchAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/product/productList.jsp";
    String key=request.getParameter("key");
    String tpage=request.getParameter("tpage");
    String kind=request.getParameter("kind");
    String cateCode=request.getParameter("cateCode");
    System.out.println(kind+cateCode+"�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
    
    
    
    
    
    
    
    int a=0; int b=0;
    
    if(kind.equals("��ü")) {a=0;}
    else if(kind.equals("���")) {a=1;}
    else if(kind.equals("����")) {a=2;}
    else if(kind.equals("��ǰ")) {a=3;}
    
    if(cateCode.equals("0")) { b=0;}
    else if(cateCode.equals("1")) { b=1;}
    else if(cateCode.equals("2")) { b=2;}
    else if(cateCode.equals("3")) { b=3;}
    else if(cateCode.equals("4")) { b=4;}
    
    
  
    
    
    
    
    if(key==null){
     key="";
    }    
    if(tpage== null){
      tpage="1";                     
    }else if(tpage.equals("")){
       tpage="1";  
    }
    request.setAttribute("key", key);
    request.setAttribute("tpage",tpage);
    
    
    
    String kindList[] = {"��ü","���","����","��ǰ"};    
    String cateCodeList[] = {"��ü","������","�����","��","�����"};
    request.setAttribute("kindList", kindList);
    request.setAttribute("cateCodeList", cateCodeList);
   
   
        
    ProductDAO productDAO=ProductDAO.getInstance();
    ArrayList<ProductVO> productList= new ArrayList<ProductVO>();
    
    
   
    int n=0;
    
    if((a==0) &&(b==0)) {
     productList=
                productDAO.listProduct(Integer.parseInt(tpage), key);
    			;   
    }
    else if((a==0) && (b>0))  {
       productList=
                productDAO.listProductcateCode(Integer.parseInt(tpage), key,b);
        
           
    }else if((a>0) && (b==0)) {
    	productList=
                productDAO.listProductKind(Integer.parseInt(tpage), key,kind);
    	  
    }else if((a>0) && (b>0)){ 
    	productList=
    			productDAO.listProduct(Integer.parseInt(tpage), key,b,kind);
    	
    }
           
        
    String paging=productDAO.pageNumber(Integer.parseInt(tpage), key);
     
    
    request.setAttribute("productList",productList);
    n=productList.size();   
    request.setAttribute("productListSize",n); 
    request.setAttribute("paging", paging);    
    request.getRequestDispatcher(url).forward(request, response);
  }
}

package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.ProductVO;
import com.mypet.util.ConnUtil;


public class ProductDAO {
	private ProductDAO() { }
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}

	public ProductVO getProductDetail(int pNum){
		ProductVO product = null;
		String sql = "select * from product where pNum = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductVO();
				product.setpNum(rs.getInt("pNum"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setCateCode(rs.getString("catecode"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return product;
	}
	public ArrayList<ProductVO> getProduct(int catecode) {
		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select * from cate_view where catecode = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, catecode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setpNum(rs.getInt("pNum"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setCateName(rs.getString("cateName"));
				productlist.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return productlist;
	}

	public ArrayList<ProductVO> admingetProduct() {
		ArrayList<ProductVO> productlist = new ArrayList<ProductVO>();
		String sql = "select * from cate_view";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setpNum(rs.getInt("pNum"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setKind(rs.getString("kind"));
				product.setCateName(rs.getString("catename"));
				productlist.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return productlist;
	}

	public ProductVO admingetProductDetail(int pNum){
		ProductVO product = null;
		String sql = "select * from product where pNum = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductVO();
				product.setpNum(rs.getInt("pNum"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setKind(rs.getString("kind"));
				product.setCateCode(rs.getString("catecode"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return product;
	}

	public int totalRecord(String pName) {
		int total_pages = 0;
		String sql = "select count(*) from product where pName like '%'||?||'%'";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			if(pName.equals("")) {
				pstmt.setString(1, "%");
			}
			else {
				pstmt.setString(1, pName);
			}
			rs= pstmt.executeQuery();
			if(rs.next()) {
				total_pages = rs.getInt(1);
				rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt);
		}
		return total_pages;
	}

	static int view_rows = 55;
	static int counts = 55;

	public String pageNumber(int tpage,String name) {
		String str = "";
		int total_pages = totalRecord(name);
		int page_count = total_pages/counts+1;
		if(total_pages % counts ==0) {
			page_count--;
		}
		if(tpage<1) {
			tpage=1;
		}
		int start_page = tpage - (tpage%view_rows) +1;
		int end_page = start_page + (counts-1);
		if(end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='MypetServlet?command=admin_product_list&tpage=1&key=" 
					+ name + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str+="<a href='MypetServlet?command=admin_product_list&tpage=" 
					+ (start_page - 1);
			str += "&key=<%=pName%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='MypetServlet?command=admin_product_list&tpage=" 
						+ i + "&key=" + name + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='MypetServlet?command=admin_product_list&tpage="
					+ (end_page + 1) + "&key=" + name + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='MypetServlet?command=admin_product_list&tpage="
					+ page_count + "&key=" + name + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	public ArrayList<ProductVO> listProduct(int tpage,String pName){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String str = "select pNum,pName,pPrice,CP,CateCode,Kind from product where pName like '%'||?||'%' order by pNum desc";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int absolutepage = 1;
		try {
			con = ConnUtil.getConnection();
			absolutepage = (tpage -1) * counts +1;
			pstmt = con.prepareStatement(str , ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(pName.equals("")) {
				pstmt.setString(1,"%");
			}else {
				pstmt.setString(1, pName);
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rs.absolute(absolutepage);
				int count = 0;
				while(count<counts) {
					ProductVO product = new ProductVO();
					product.setpNum(rs.getInt(1));
					product.setpName(rs.getString(2));
					product.setpPrice(rs.getInt(3));
					product.setCP(rs.getString(4));
					product.setCateCode(rs.getString(5));
					product.setKind(rs.getString(6));
					productList.add(product);
					if(rs.isLast()) {
						break;
					}
					rs.next();
					count++;

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt, rs);
		}
		return productList;
	}

	public int insertProduct(ProductVO product) {
		int result = 0;
		String sql ="insert into product (pNum,pName,pPrice,CP,pImg,pInfo,catecode,kind) values (pro_seq.nextVal,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			pstmt.setInt(2, product.getpPrice());
			pstmt.setString(3, product.getCP());
			pstmt.setString(4, product.getpImg());
			pstmt.setString(5, product.getpInfo());
			pstmt.setString(6,product.getCateCode());
			pstmt.setString(7,product.getKind());

			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("추가 실패");
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
		return result;
	}
	public int updateProduct(ProductVO product) {
		int result = -1;
		String sql = "update product set pName = ?, pPrice = ?, CP = ? , pImg = ? , pInfo = ? , kind = ? where pNum = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			pstmt.setInt(2, product.getpPrice());
			pstmt.setString(3, product.getCP());
			pstmt.setString(4, product.getpImg());
			pstmt.setString(5, product.getpInfo());
			pstmt.setString(6,product.getKind());
			pstmt.setInt(7, product.getpNum());
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt);
		}
		return result;
	}
	public ArrayList<ProductVO> listProduct(String cateCode) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "select * from cate_view where c.cateCode = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cateCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setKind(rs.getString("kind"));
				product.setCateCode(rs.getString("cateCode"));
				product.setCateName(rs.getString("cateName"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return productList;
	}

	public ArrayList<ProductVO> searchProduct(String pName){
		ArrayList<ProductVO> listKind = new ArrayList<ProductVO>();
		String sql = "select * from product where pName like '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setpNum(rs.getInt("pNum"));
				product.setpName(rs.getString("pName"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setKind(rs.getString("kind"));
				product.setCateCode(rs.getString("cateCode"));
				product.setCateName(rs.getString("cateName"));
				listKind.add(product);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return listKind;
	}

	public ArrayList<ProductVO> listKindProduct(String cateName, String kind) {

		ArrayList<ProductVO> listKind = new ArrayList<ProductVO>();
		String sql = "select * from product where catename =?  and kind = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cateName);
			pstmt.setString(2, kind);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setpName(rs.getString("pName"));
				product.setpNum(rs.getInt("pNum"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setKind(rs.getString("kind"));
				product.setCateCode(rs.getString("cateCode"));
				product.setCateName(rs.getString("cateName"));
				listKind.add(product);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return listKind;
	}
	public ArrayList<ProductVO> listKindProduct( String kind) {

		ArrayList<ProductVO> listKind = new ArrayList<ProductVO>();
		String sql = "select * from product where kind = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setpName(rs.getString("pName"));
				product.setpNum(rs.getInt("pNum"));
				product.setpPrice(rs.getInt("pPrice"));
				product.setCP(rs.getString("CP"));
				product.setpImg(rs.getString("pImg"));
				product.setpInfo(rs.getString("pInfo"));
				product.setKind(rs.getString("kind"));
				product.setCateCode(rs.getString("cateCode"));
				product.setCateName(rs.getString("cateName"));
				listKind.add(product);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return listKind;
	}

	public ArrayList<ProductVO> listProductcateCode(int tpage,String pName,int cateCode){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String str = "select pNum,pName,pPrice,CP,CateCode,Kind from product where pName like '%'||?||'%' and cateCode = ?order by pNum desc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int absolutepage = 1;

		try {
			con = ConnUtil.getConnection();
			absolutepage = (tpage -1) * counts +1;
			pstmt = con.prepareStatement(str , ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(pName.equals("")) {
				pstmt.setString(1,"%");
				pstmt.setInt(2, cateCode);
			}else {
				pstmt.setString(1, pName);
				pstmt.setInt(2, cateCode);
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rs.absolute(absolutepage);
				int count = 0;
				while(count<counts) {
					ProductVO product = new ProductVO();
					product.setpNum(rs.getInt(1));
					product.setpName(rs.getString(2));
					product.setpPrice(rs.getInt(3));
					product.setCP(rs.getString(4));
					product.setCateCode(rs.getString(5));
					product.setKind(rs.getString(6));
					productList.add(product);
					if(rs.isLast()) {
						break;
					}
					rs.next();
					count++;

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt, rs);
		}
		return productList;
	}
	public ArrayList<ProductVO> listProductKind(int tpage,String pName,String kind){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String str = "select pNum,pName,pPrice,CP,CateCode,Kind from product where pName like '%'||?||'%' and kind = ?order by pNum desc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int absolutepage = 1;

		try {
			con = ConnUtil.getConnection();
			absolutepage = (tpage -1) * counts +1;
			pstmt = con.prepareStatement(str , ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(pName.equals("")) {
				pstmt.setString(1,"%");
				pstmt.setString(2, kind);
			}else {
				pstmt.setString(1, pName);
				pstmt.setString(2, kind);
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rs.absolute(absolutepage);
				int count = 0;
				while(count<counts) {
					ProductVO product = new ProductVO();
					product.setpNum(rs.getInt(1));
					product.setpName(rs.getString(2));
					product.setpPrice(rs.getInt(3));
					product.setCP(rs.getString(4));
					product.setCateCode(rs.getString(5));
					product.setKind(rs.getString(6));
					productList.add(product);
					if(rs.isLast()) {
						break;
					}
					rs.next();
					count++;

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt, rs);
		}
		return productList;
	}
	public ArrayList<ProductVO> listProduct(int tpage,String pName,int cateCode, String kind){
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String str = "select pNum,pName,pPrice,CP,CateCode,Kind from product where pName like '%'||?||'%' and cateCode = ? and kind = ? order by pNum desc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int absolutepage = 1;

		try {
			con = ConnUtil.getConnection();
			absolutepage = (tpage -1) * counts +1;
			pstmt = con.prepareStatement(str , ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(pName.equals("")) {
				pstmt.setString(1,"%");
				pstmt.setInt(2, cateCode);
				pstmt.setString(3, kind);
			}else {
				pstmt.setString(1, pName);
				pstmt.setInt(2, cateCode);
				pstmt.setString(3, kind);
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rs.absolute(absolutepage);
				int count = 0;
				while(count<counts) {
					ProductVO product = new ProductVO();
					product.setpNum(rs.getInt(1));
					product.setpName(rs.getString(2));
					product.setpPrice(rs.getInt(3));
					product.setCP(rs.getString(4));
					product.setCateCode(rs.getString(5));
					product.setKind(rs.getString(6));
					productList.add(product);
					if(rs.isLast()) {
						break;
					}
					rs.next();
					count++;

				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt, rs);
		}
		return productList;
	}

	public String selectpName(int pNum) {
		String sql ="select pName from product where pNum = ?";
		String pName= "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pName = rs.getNString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt,rs);
		}
		return pName;
	}
}
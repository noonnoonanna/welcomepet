package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.CategoryVO;
import com.mypet.util.ConnUtil;

public class CategoryDAO {
	private CategoryDAO() { }
	private static CategoryDAO instance = new CategoryDAO();
	public static CategoryDAO getInstance() {
		return instance;
	} 
	public ArrayList<CategoryVO> categoryList() {
		ArrayList<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		String sql ="select * from category";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CategoryVO category = new CategoryVO();
				category.setCateCode(rs.getString("cateCode"));
				category.setCateName(rs.getString("cateName"));
				categoryList.add(category);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return categoryList;
	}
	public String selectCateName(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cateName = "";
		String sql ="select cateName from Join_User where id = ?";
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cateName = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return cateName;
	}

}

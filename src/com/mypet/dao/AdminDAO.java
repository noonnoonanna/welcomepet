package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypet.util.ConnUtil;


public class AdminDAO {
	private AdminDAO() {  }
	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public int AdminCheck(String adminid, String adminpw) {
		String sql = "select admin_pw from admin where admin_id = ?";
		int result = -1;

		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminid);
			rs= pstmt.executeQuery();
			if (rs.next()) {  
				result=0;
				String dbPwd = rs.getString(1); 

				if (dbPwd.equals(adminpw)) {
					result = 1; 
				}
			}
			ConnUtil.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}// adminDAO


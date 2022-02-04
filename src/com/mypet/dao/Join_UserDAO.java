package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.Join_UserVO;
import com.mypet.util.ConnUtil;

public class Join_UserDAO {

	private Join_UserDAO() {}
	private static Join_UserDAO instance = new Join_UserDAO();
	public static Join_UserDAO getInstance() {
		return instance;
	}
	//아이디확인?
	public int confirmID(String ID) {
		int result = -1;
		String sql = "select * from Join_User where id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	public Join_UserVO getUser(String id) {
		Join_UserVO join_userVO=null;
		String sql = "select * from join_user where ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				join_userVO = new Join_UserVO();
				join_userVO.setID(rs.getString("id"));
				join_userVO.setPassword(rs.getString("password"));
				join_userVO.setName(rs.getString("name"));
				join_userVO.setBirthday(rs.getString("birthday"));
				join_userVO.setPhone(rs.getString("phone"));
				join_userVO.setEmail(rs.getString("email"));
				join_userVO.setAddress(rs.getString("address"));
				join_userVO.setCateName(rs.getString("cateName"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return join_userVO;
	}
	//회원가입
	public int insertJoin_User(Join_UserVO join_userVO) {
		int result = 0;
		String sql = "insert into Join_User(id, password, name, birthday, phone, address, email,cateName) values (?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, join_userVO.getID());
			pstmt.setString(2, join_userVO.getPassword());
			pstmt.setString(3, join_userVO.getName());
			pstmt.setString(4, join_userVO.getBirthday());
			pstmt.setString(5, join_userVO.getPhone());
			pstmt.setString(6, join_userVO.getAddress());
			pstmt.setString(7, join_userVO.getEmail());
			pstmt.setString(8, join_userVO.getCateName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
		return result;
	}

	public void deleteUser(String id) {
		String sql2 ="delete from p_order where id =?";
		String sql1 ="delete from cart where id =?";
		String sql3 = "delete from Join_User where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	public ArrayList<Integer> selectOnum(String id) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		String sql = "select oNum from p_order where id = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				intList.add(rs.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return intList;
	}
	public void deleteOnum(int oNum) {
		String sql ="delete from o_detail where oNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	public int userUpdate(Join_UserVO join_userVO) {
		int result = -1;
		String sql ="update Join_User set name = ? , password = ? , birthday = ? , phone = ?, address = ? , Email = ? , catename= ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, join_userVO.getName());
			pstmt.setString(2, join_userVO.getPassword());
			pstmt.setString(3, join_userVO.getBirthday());
			pstmt.setString(4, join_userVO.getPhone());
			pstmt.setString(5, join_userVO.getAddress());
			pstmt.setString(6, join_userVO.getEmail());
			pstmt.setString(7, join_userVO.getCateName());
			pstmt.setString(8, join_userVO.getID());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
		return result;
	}

	public ArrayList<Join_UserVO> listJoin_User(String join_user_name){
		ArrayList<Join_UserVO> join_userList=new ArrayList<Join_UserVO>();
		String sql = "select * from Join_User where name like '%'||?||'%' order by name desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(join_user_name == "") {
				pstmt.setString(1, "%");
			}else {
				pstmt.setString(1, join_user_name);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Join_UserVO join_userVO = new Join_UserVO();
				join_userVO.setID(rs.getString("ID"));
				join_userVO.setPassword(rs.getString("password"));
				join_userVO.setName(rs.getString("name"));
				join_userVO.setBirthday(rs.getString("birthday"));
				join_userVO.setPhone(rs.getString("phone"));
				join_userVO.setAddress(rs.getString("address"));
				join_userVO.setEmail(rs.getString("email"));
				join_userVO.setCateName(rs.getString("catename"));
				join_userList.add(join_userVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return join_userList;
	}

}

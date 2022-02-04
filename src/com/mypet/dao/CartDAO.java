package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.CartVO;
import com.mypet.util.ConnUtil;

public class CartDAO {
	private CartDAO() { }
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	public ArrayList<Integer> getcNum(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Integer> cNumArray = new ArrayList<Integer>();
		try {
			int cNum = 1;
			con = ConnUtil.getConnection();
			sql = "select cNum from cart where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cNum = rs.getInt(1);
				cNumArray.add(cNum);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt, rs);
		}
		return cNumArray;
	}

	public CartVO selectCart(String userid, int cNum) {
		CartVO cartVO = new CartVO();
		String sql = "select * from cart_view where id = ? and cNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.setInt(2, cNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cartVO.setcNum(rs.getInt(1));
				cartVO.setId(rs.getString(2));
				cartVO.setpNum_cart(rs.getInt(3));
				cartVO.setuName(rs.getString(4));
				cartVO.setpName(rs.getString(5));
				cartVO.setCnt(rs.getInt(6));
				cartVO.setpPrice(rs.getInt(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return cartVO;
	}
	public void insertCart(CartVO cartVO) {
		String sql = "insert into cart (cNum,id,pNum_cart,cnt) values (cart_seq.nextVal,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cartVO.getId());
			pstmt.setInt(2,cartVO.getpNum_cart());
			pstmt.setInt(3,cartVO.getCnt());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}
	public ArrayList<CartVO> listCart(String userid){
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		String sql = "select * from cart_view where id = ? order by cNum desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CartVO cartVO = new CartVO();
				cartVO.setcNum(rs.getInt(1));
				cartVO.setId(rs.getString(2));
				cartVO.setpNum_cart(rs.getInt(3));
				cartVO.setuName(rs.getString(4));
				cartVO.setpName(rs.getString(5));
				cartVO.setCnt(rs.getInt(6));
				cartVO.setpPrice(rs.getInt(7));
				cartList.add(cartVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return cartList;
	}
	public void deleteCart(int cNum) {
		String sql ="delete cart where cNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cNum);
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}
}

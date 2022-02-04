package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.ReviewVO;
import com.mypet.util.ConnUtil;



public class ReviewDAO {
	private ReviewDAO() { }
	private static ReviewDAO instance = new ReviewDAO();
	public static ReviewDAO getInstance() {
		return instance;
	}
	public ArrayList<ReviewVO> selectReview(int pNum){
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		try {
			String sql ="select * from re_view where pNum =?";
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO reviewVO = new ReviewVO();
				reviewVO.setpNum(rs.getInt("pNum"));
				reviewVO.setID(rs.getNString("ID"));
				reviewVO.setContent(rs.getString("content"));
				reviewVO.setrImg(rs.getString("rImg"));
				reviewVO.setwDate(rs.getTimestamp("wDate"));
				reviewVO.setRating(rs.getString("Rating"));
				reviewList.add(reviewVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return reviewList;
	}

	public int insertReview(ReviewVO reviewVO) {
		int result = -1;
		String sql ="insert into review (rNum,pNum,odNum,ID,content,rImg,rating) values (re_seq.nextVal,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn=ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewVO.getpNum());
			pstmt.setInt(2, reviewVO.getOdNum());
			pstmt.setString(3, reviewVO.getID());
			pstmt.setString(4, reviewVO.getContent());
			pstmt.setString(5, reviewVO.getrImg());
			pstmt.setString(6, reviewVO.getRating());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
		return result;
	}
	public void deleteReview(int rNum) {
		String sql ="delete review where rNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}
	public void updateReview(ReviewVO reviewVO) {
		String sql ="update review set content = ?, rImg = ? ,rating = ? where rNum = ?";
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,reviewVO.getContent());
			pstmt.setString(2, reviewVO.getrImg());
			pstmt.setString(3, reviewVO.getRating());
			pstmt.setInt(4, reviewVO.getrNum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}

	}
	public ReviewVO updateSelect(int odNum) {
		String sql ="select * from reView where odNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVO reviewVO = new ReviewVO();
		try {
			conn= ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, odNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				reviewVO.setContent(rs.getString("content"));
				reviewVO.setRating(rs.getString("rating"));
				reviewVO.setrImg(rs.getString("rImg"));
				reviewVO.setrNum(rs.getInt("rNum"));
				reviewVO.setpNum(rs.getInt("pNum"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt,rs);
		}
		return reviewVO;
	}

}

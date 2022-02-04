package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.QnaVO;
import com.mypet.util.ConnUtil;

public class QnaDAO {
	private QnaDAO() {
	}

	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	public ArrayList<QnaVO> listQna() {
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		String sql = "select * from qna "; //where ID
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaVO qnaVO = new QnaVO();
				qnaVO.setqNo(rs.getInt("qNo"));
				qnaVO.setqTitle(rs.getString("qTitle"));
				qnaVO.setID(rs.getString("ID"));
				qnaVO.setqDate(rs.getTimestamp("qDate"));
				qnaVO.setqContent(rs.getString("qContent"));
				
				qnaList.add(qnaVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return qnaList;
	}

	public QnaVO getQna(int qNo) {
		QnaVO qnaVO = null;
		String sql = "select * from qna where qNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qnaVO = new QnaVO();
				qnaVO.setqNo(qNo);
				qnaVO.setqTitle(rs.getString("qTitle"));
				qnaVO.setqContent(rs.getString("qContent"));
				qnaVO.setID(rs.getString("ID"));
				qnaVO.setqDate(rs.getTimestamp("qDate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return qnaVO;
	}

	public void insertqna(QnaVO qnaVO) {
		String sql = "insert into qna( qNo,qTitle, qContent ) values(qna_seq.nextVal,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qnaVO.getqTitle());
			pstmt.setString(2, qnaVO.getqContent());
			
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	 
	public void updateqna(QnaVO qnaVO) {
		String sql = "update qna set qTitle=?, qContent=? where qNo=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qnaVO.getqTitle());
			pstmt.setString(2, qnaVO.getqContent());
			pstmt.setInt(3, qnaVO.getqNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	public void deleteqna(int qno) {
		String sql = "delete from qna where qNo=?";
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt);
		}
	}
	//답변글 입력 폼 보기
	public QnaVO replyqnaui(String qno) {
		QnaVO qVo = new QnaVO();
		String sql = "select * from qna where qNo=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (qno));
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				qVo.setID(rs.getString("ID"));
				qVo.setqTitle(rs.getString("qTitle"));
				qVo.setqContent(rs.getString("qContent"));
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
		return qVo;
	}
	
	}

	

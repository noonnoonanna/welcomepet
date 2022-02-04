package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.MtmVO;
import com.mypet.util.ConnUtil;

public class MtmDAO {

	private MtmDAO() {
	}

	private static MtmDAO instance = new MtmDAO();

	public static MtmDAO getInstance() {
		return instance;
	}

	public ArrayList<MtmVO> listMtm (String id){
		ArrayList<MtmVO> mtmList = new ArrayList<MtmVO>();
		String sql = "select * from mtm where id=? order by qseq desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MtmVO mtmVO = new MtmVO();
				mtmVO.setQseq(rs.getInt("qseq"));
				mtmVO.setTitle(rs.getString("title"));
				mtmVO.setContent(rs.getString("content"));
				mtmVO.setId(rs.getString("id"));
				mtmVO.setIndate(rs.getTimestamp("indate"));
				mtmVO.setReply(rs.getString("reply"));
				mtmVO.setRep(rs.getString("rep"));
				mtmList.add(mtmVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return mtmList;
	}

	public MtmVO getMtm(int qseq) {
		MtmVO mtmVO = null;
		String sql = "select * from mtm where qseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mtmVO = new MtmVO();
				mtmVO.setQseq(qseq);
				mtmVO.setTitle(rs.getString("title"));
				mtmVO.setContent(rs.getString("content"));
				mtmVO.setId(rs.getString("id"));
				mtmVO.setIndate(rs.getTimestamp("indate"));
				mtmVO.setReply(rs.getString("reply"));
				mtmVO.setRep(rs.getString("rep"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return mtmVO;
	}

	public void insertmtm(MtmVO mtmVO, String session_id) {
		String sql = "insert into mtm (qseq, title, content, id) values(mtm_seq.nextval,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mtmVO.getTitle());
			pstmt.setString(2, mtmVO.getContent());
			pstmt.setString(3, session_id);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}



	/*관리자 모드에서 필요한 메소드
	 * */
	public ArrayList<MtmVO> listAllMtm() {
		ArrayList<MtmVO> mtmList  = new ArrayList<MtmVO>();
		//게시판의 데이터를 가지고 오는 뭐리 rep:  1:게시물 2:답변
		String sql = "select * from mtm order by indate desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MtmVO mtmVO = new MtmVO();
				mtmVO.setQseq(rs.getInt("qseq"));
				mtmVO.setTitle(rs.getString("title"));
				mtmVO.setContent(rs.getString("content"));
				mtmVO.setId(rs.getString("id"));
				mtmVO.setIndate(rs.getTimestamp("indate"));
				mtmVO.setReply(rs.getString("reply"));
				mtmVO.setRep(rs.getString("rep"));
				mtmList.add(mtmVO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return mtmList;
	}

	public void updateMtm(MtmVO mtmVO) {
		String sql = "update mtm set reply=?, rep='2' where qseq=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mtmVO.getReply());
			pstmt.setInt(2, mtmVO.getQseq());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}
	//답변달기
	public void replyMtm(String ID,String title,String content) {
		String sql ="insert into mtm (qseq,ID,title,content) values (mtm_seq.nextVal,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, title);
			pstmt.setString(3, content);

			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	public void deletemtm(int qseq) {
		String sql = "delete from mtm where qseq=?";
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			result = pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	//1:1답변 수정
	public void adminupdateMtm(MtmVO mtmVO) {
		String sql = "update mtm set title=?, content=? where qseq=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mtmVO.getTitle());
			pstmt.setString(2, mtmVO.getContent());
			pstmt.setInt(3, mtmVO.getQseq());
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}


	public MtmVO admingetMtm(int qseq) {
		MtmVO mtmVO = null;
		String sql = "select * from mtm where qseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mtmVO = new MtmVO();
				mtmVO.setQseq(qseq);
				mtmVO.setTitle(rs.getString("title"));
				mtmVO.setContent(rs.getString("content"));
				mtmVO.setId(rs.getString("id"));
				mtmVO.setIndate(rs.getTimestamp("indate"));
				mtmVO.setReply(rs.getString("reply"));
				mtmVO.setRep(rs.getString("rep"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return mtmVO;

	}

}



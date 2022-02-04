package com.mypet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypet.dto.CartVO;
import com.mypet.dto.P_orderVO;
import com.mypet.util.ConnUtil;

public class P_orderDAO {

	private P_orderDAO() { }

	private static P_orderDAO instance = new P_orderDAO();

	public static P_orderDAO getInstance() {
		return instance;
	}

	public void insertOrder (String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = ConnUtil.getConnection();
			sql = "insert into P_order(oNum,id) values (order_seq.nextVal,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);//주문 id
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(con, pstmt);
		}
	}
	public void insertDetailOrder(CartVO cartVO,int oNum,String oname,String ophone,String oaddress) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into O_detail(odNum,oNum,pNum,cnt,oname,ophone,oaddress) values (detail_seq.nextVal,?,?,?,?,?,?)";
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,oNum);
			pstmt.setInt(2, cartVO.getpNum_cart());
			pstmt.setInt(3, cartVO.getCnt());
			pstmt.setString(4, oname);
			pstmt.setString(5, ophone);
			pstmt.setString(6, oaddress);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}
	public void directOrder(int oNum,int pNum, int cnt,String oname,String ophone,String oaddress) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into O_detail(odNum,oNum,pNum,cnt,oname,ophone,oaddress) values (detail_seq.nextVal,?,?,?,?,?,?)";
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			pstmt.setInt(2, pNum);
			pstmt.setInt(3, cnt);			
			pstmt.setString(4, oname);
			pstmt.setString(5, ophone);
			pstmt.setString(6, oaddress);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}
	public int getoNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int max = 1;
		try {
			con = ConnUtil.getConnection();
			sql = "select max(oNum) from P_order";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				max = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(con, pstmt, rs);
		}
		return max;
	}

	public void orderCancleConfirm(int odNum) {
		String sql ="update o_detail set user_state = '취소요청', admin_state = '취소요청' where odNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, odNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}
	}

	//사용자가 주문 내역 검색
	public ArrayList<P_orderVO> listOrderById(String id,int oNum) {
		ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
		String sql = "select * from order_view where id=? and oNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, oNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_orderVO orderVO = new P_orderVO();
				orderVO.setOdNum(rs.getInt("odNum"));
				orderVO.setoNum(rs.getInt("oNum"));
				orderVO.setID(rs.getString("ID"));
				orderVO.setIndate(rs.getTimestamp("indate"));
				orderVO.setName(rs.getString("name"));
				orderVO.setOname(rs.getString("oname"));
				orderVO.setOaddress(rs.getString("oaddress"));
				orderVO.setOphone(rs.getString("ophone"));
				orderVO.setpNum(rs.getInt("pNum"));
				orderVO.setCnt(rs.getInt("cnt"));
				orderVO.setpName(rs.getString("pName"));
				orderVO.setpPrice(rs.getInt("pPrice"));
				orderVO.setAdmin_state(rs.getString("admin_state"));
				orderVO.setUser_state(rs.getString("user_state"));
				orderVO.setResult(rs.getInt("result"));
				orderList.add(orderVO);
				System.out.println("byId = " + orderList.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return orderList;
	}

	public ArrayList<Integer> selectoNumIng(String id){
		ArrayList<Integer> oNumList = new ArrayList<Integer>();
		String sql = "select distinct oNum from order_view where id = ? order by oNum desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				oNumList.add(rs.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return oNumList;
	}
	/* *
	 * 관리자 모드에서 사용되는 메소드 * *
	 */
	public ArrayList<P_orderVO> listOrder(String user_name) {
		ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
		String sql = "select * from order_view where ID like '%'||?||'%' order by oNum desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (user_name == "") {
				pstmt.setString(1, "%");
			} else {
				pstmt.setString(1, user_name);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_orderVO orderVO = new P_orderVO();
				orderVO.setOdNum(rs.getInt("odNum"));
				orderVO.setoNum(rs.getInt("oNum"));
				orderVO.setpNum(rs.getInt("pNum"));
				orderVO.setID(rs.getString("ID"));
				orderVO.setpPrice(rs.getInt("pPrice"));
				orderVO.setCnt(rs.getInt("cnt"));
				orderVO.setAdmin_state(rs.getString("admin_state"));
				orderVO.setUser_state(rs.getString("user_state"));
				orderVO.setIndate(rs.getTimestamp("INDATE"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return orderList;
	}

	public void changeResult(int odNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update o_detail set result = 2 where odNum = ?";
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, odNum);
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnUtil.close(conn, pstmt);
		}

	}

	public ArrayList<P_orderVO> PriceRank(String user_name) {
		ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
		String sql = " select a.id, sum(a.pPrice) totalprice, sum(a.cnt) totalcnt, count(a.odNum) odNumRank, b.catename,"
				+ "DENSE_RANK() OVER(ORDER BY count(odNum) DESC) as rank" + 
				" from order_view a" +
				" Inner join Join_user b"+
				" on(a.id=b.id)"+
				" where user_state in('결제완료')" + 
				" group by a.id, b.catename order by sum(a.pPrice) desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_orderVO orderVO = new P_orderVO();
				orderVO.setOdNum(rs.getInt("odNumRank"));
				orderVO.setRank(rs.getInt("rank"));
				orderVO.setID(rs.getString("ID"));
				orderVO.setpPrice(rs.getInt("totalprice"));
				orderVO.setCnt(rs.getInt("totalcnt"));
				orderVO.setCatename(rs.getString("catename"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return orderList;
	}

	public ArrayList<P_orderVO> CntRank(String user_name) {
		ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
		String sql = " select a.id, sum(a.pPrice) totalprice, sum(a.cnt) totalcnt, count(a.odNum) odNumRank, b.catename,"
				+ "DENSE_RANK() OVER(ORDER BY count(odNum) DESC) as rank" + 
				" from order_view a" +
				" Inner join Join_user b"+
				" on(a.id=b.id)"+
				" where user_state in('결제완료')" + 
				" group by a.id, b.catename order by sum(a.cnt) desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_orderVO orderVO = new P_orderVO();
				orderVO.setOdNum(rs.getInt("odNumRank"));
				orderVO.setRank(rs.getInt("rank"));
				orderVO.setID(rs.getString("ID"));
				orderVO.setpPrice(rs.getInt("totalprice"));
				orderVO.setCnt(rs.getInt("totalcnt"));
				orderVO.setCatename(rs.getString("catename"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return orderList;
	}


	public ArrayList<P_orderVO> oNumRank(String user_name) {
		ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
		String sql = " select a.id, sum(a.pPrice) totalprice, sum(a.cnt) totalcnt, count(a.odNum) odNumRank, b.catename,"
				+ "DENSE_RANK() OVER(ORDER BY count(odNum) DESC) as rank" + 
				" from order_view a" +
				" Inner join Join_user b"+
				" on(a.id=b.id)"+
				" where user_state in('결제완료')" + 
				" group by a.id, b.catename order by count(odNum) desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_orderVO orderVO = new P_orderVO();
				orderVO.setOdNum(rs.getInt("odNumRank"));
				orderVO.setRank(rs.getInt("rank"));
				orderVO.setID(rs.getString("ID"));
				orderVO.setpPrice(rs.getInt("totalprice"));
				orderVO.setCnt(rs.getInt("totalcnt"));
				orderVO.setCatename(rs.getString("catename"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return orderList;
	}

	public ArrayList<P_orderVO> cateRank(String user_name) {
		ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
		String sql =" select b.catename,sum(a.cnt) totalcnt,sum(a.pPrice) totalprice,count(a.odnum) odNumRank"+
				" from order_view a"+
				" inner join Join_user b"+
				" on(a.id=b.id)"+
				" group by b.catename order by sum(a.pPrice) desc";  

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				P_orderVO orderVO = new P_orderVO();
				orderVO.setCatename(rs.getString("catename"));
				orderVO.setCnt(rs.getInt("totalcnt"));
				orderVO.setpPrice(rs.getInt("totalprice"));
				orderVO.setOdNum(rs.getInt("odNumRank"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnUtil.close(conn, pstmt, rs);
		}
		return orderList;
	}
	
	public ArrayList<P_orderVO> cancelListOrder(String user_name) {
	      ArrayList<P_orderVO> orderList = new ArrayList<P_orderVO>();
	      String sql = "select * from order_view where ID like '%'||?||'%' and user_state='취소요청' or user_state='취소완료' order by oNum desc";
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         conn = ConnUtil.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         if (user_name == "") {
	            pstmt.setString(1, "%");
	         } else {
	            pstmt.setString(1, user_name);
	         }
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            P_orderVO orderVO = new P_orderVO();
	            orderVO.setOdNum(rs.getInt("odNum"));
	            orderVO.setoNum(rs.getInt("oNum"));
	            orderVO.setpNum(rs.getInt("pNum"));
	            orderVO.setID(rs.getString("ID"));
	            orderVO.setpPrice(rs.getInt("pPrice"));
	            orderVO.setCnt(rs.getInt("cnt"));
	            orderVO.setAdmin_state(rs.getString("admin_state"));
	            orderVO.setUser_state(rs.getString("user_state"));
	            orderVO.setIndate(rs.getTimestamp("INDATE"));
	            orderList.add(orderVO);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         ConnUtil.close(conn, pstmt, rs);
	      }
	      return orderList;
	   }
	   public void updateFinishOrderResult(String oseq) {
	      String sql = "update o_detail set admin_state='배송완료' , user_state ='배송완료' where odNum=?";

	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      try {
	         conn = ConnUtil.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, oseq);
	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         ConnUtil.close(conn, pstmt);
	      }
	   }
	   
	   public void updateOrderResult(String oseq) {
	      String sql = "update o_detail set admin_state='취소완료' , user_state ='취소완료',result=3 where odNum=?";

	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      try {
	         conn = ConnUtil.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, oseq);
	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         ConnUtil.close(conn, pstmt);
	      }
	   }

}
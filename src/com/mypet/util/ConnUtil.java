package com.mypet.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnUtil {

	private static DataSource ds;
	static {
		try {
			InitialContext ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mypet");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}



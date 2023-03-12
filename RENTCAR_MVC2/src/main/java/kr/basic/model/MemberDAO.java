package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	private MemberDAO() {
	}

	static private MemberDAO dao = new MemberDAO();

	static public MemberDAO getInstance() {
		return dao;

	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public String checkMemberId(String id) {
		String SQL = "select pw1 from member where id=?";
		getConnection();

		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("pw1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return null;
	}

	public void getConnection() {
		String URL = "jdbc:mysql://localhost:3306/rentcardb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
//			System.out.println("     rentcardb_member : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

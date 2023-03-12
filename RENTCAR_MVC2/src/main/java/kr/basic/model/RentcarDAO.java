package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RentcarDAO {
	private RentcarDAO() {
	}

	static private RentcarDAO dao = new RentcarDAO();

	static public RentcarDAO getInstance() {
		return dao;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public ArrayList<RentcarBean> carList() {
		String sql = "select * from rentcar";
		getConnection();
		ArrayList<RentcarBean> list = new ArrayList<RentcarBean>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				RentcarBean vo = new RentcarBean(no, name, category, price, usepeople, company, img, info);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public ArrayList<RentcarBean> categoriList(int c) {
		String sql = "select * from rentcar where category = ?";
		getConnection();
		ArrayList<RentcarBean> list = new ArrayList<RentcarBean>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				RentcarBean vo = new RentcarBean(no, name, category, price, usepeople, company, img, info);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public RentcarBean oneCarInfo(int no) {
		RentcarBean oneCar = carList().get(no - 1);
		return oneCar;
	}

	public RentcarBean oneCarInfo(String carName) {
		RentcarBean oneCar = null;
		for (int i = 0; i < carList().size(); i++) {
			if (carList().get(i).getName().equals(carName)) {
				oneCar = carList().get(i);
			}
		}
		return oneCar;
	}

	public void getConnection() {
		String URL = "jdbc:mysql://localhost:3306/rentcardb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
//			System.out.println("     rentcardb_rentcar : " + conn);
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

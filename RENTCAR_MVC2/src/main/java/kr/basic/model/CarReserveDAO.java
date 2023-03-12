package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class CarReserveDAO {
	private CarReserveDAO() {
	}

	static private CarReserveDAO dao = new CarReserveDAO();

	static public CarReserveDAO getInstance() {
		return dao;

	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	int seq_count = 0;

	public void getConnection() {
		String URL = "jdbc:mysql://localhost:3306/rentcardb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
//			System.out.println("      rentcardb_carreserve : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CarReserveBean> getList() {
		String sql = "select * from carreserve";
		getConnection();
		ArrayList<CarReserveBean> list = new ArrayList<CarReserveBean>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reserve_seq = rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				String id = rs.getString("id");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String rday = rs.getString("rday");
				int usein = rs.getInt("usein");
				int usewifi = rs.getInt("usewifi");
				int usenavi = rs.getInt("usenavi");
				int useseat = rs.getInt("useseat");
				String carname = rs.getString("carname");
				int price = rs.getInt("price");
				int rtprice = rs.getInt("rtprice");
				CarReserveBean vo = new CarReserveBean(reserve_seq, no, id, qty, dday, rday, usein, usewifi, usenavi,
						useseat, carname, price, rtprice);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public ArrayList<CarReserveBean> userReserveList(String userId) {
		String sql = "select * from carreserve where id = ?";
		getConnection();
		ArrayList<CarReserveBean> list = new ArrayList<CarReserveBean>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reserve_seq = rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				String id = rs.getString("id");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String rday = rs.getString("rday");
				int usein = rs.getInt("usein");
				int usewifi = rs.getInt("usewifi");
				int usenavi = rs.getInt("usenavi");
				int useseat = rs.getInt("useseat");
				String carname = rs.getString("carname");
				int price = rs.getInt("price");
				int rtprice = rs.getInt("rtprice");
				CarReserveBean vo = new CarReserveBean(reserve_seq, no, id, qty, dday, rday, usein, usewifi, usenavi,
						useseat, carname, price, rtprice);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public CarReserveBean oneCarReserveInfo(int no) {
		CarReserveBean info = null;
		for (int i = 0; i < getList().size(); i++) {
			if (getList().get(i).getNo() == no) {
				info = getList().get(i);
			}
		}
		return info;
	}

	public int rentAllPrice(int days, int basePrice, int pulsCount, int carCount) {
		System.out.println(days + "/" + basePrice + "/" + pulsCount + "/" + carCount);

		int sum = pulsCount * 10000;
		sum += basePrice;
		sum *= days;
		sum *= carCount;

		return sum;
	}

	public int addReserveList(CarReserveBean bean) {
		String SQL = "insert into carreserve(reserve_seq, no, id, qty, "
				+ "dday, rday, usein,usewifi, usenavi, useseat, carname,price,rtprice) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		getConnection();
		seq_count++;
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, seq_count);
			ps.setInt(2, bean.getNo());
			ps.setString(3, bean.getId());
			ps.setInt(4, bean.getQty());
			ps.setInt(5, bean.getDday());
			ps.setString(6, bean.getRday());
			ps.setInt(7, bean.getUsein());
			ps.setInt(8, bean.getUsewifi());
			ps.setInt(9, bean.getUsenavi());
			ps.setInt(10, bean.getUseseat());
			ps.setString(11, bean.getCarname());
			ps.setInt(12, bean.getPrice());
			ps.setInt(13, bean.getRtprice());
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	public int limit(int count, String Id, String carName) {
		ArrayList<CarReserveBean> a = getList();
		int checkCount = 0;
		for (CarReserveBean i : a) {
			if (i.getId().equals(Id) && i.getCarname().equals(carName)) {
				checkCount += i.getQty();
			}
		}
		return checkCount + count;
	}

	public int limit(String Id, String carName) {
		ArrayList<CarReserveBean> a = getList();
		int checkCount = 0;
		for (CarReserveBean i : a) {
			if (i.getId().equals(Id) && i.getCarname().equals(carName)) {
				checkCount += i.getQty();
			}
		}
		return checkCount;
	}

	public int deleteReserveList(int num) {
		String SQL = "delete from carreserve where reserve_seq=?";
		getConnection();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		System.out.println("SQL : " + SQL + num);
		return cnt;
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

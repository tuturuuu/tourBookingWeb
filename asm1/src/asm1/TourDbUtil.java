package asm1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TourDbUtil {
	private DataSource dataSource;

	public TourDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	/*
	 *  Lay tat ca cac tour o trong co so du lieu
	 */
	public List<Tour> getTours() throws SQLException {
		List<Tour> tours = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM  Tour";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			// Lay du lieu tu tung tour va luu vao list tour
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String image = myRs.getString("image");
				String description = myRs.getString("description");
				String startDate = myRs.getString("start_date");
				String dueTime = myRs.getString("duetime");
				float price = myRs.getFloat("price");
				boolean status = myRs.getBoolean("status");
				Tour temp = new Tour(id, name, image, description, startDate, dueTime, price, status);
				tours.add(temp);
			}
		}finally {
			close(myConn, myStmt, myRs);
			
		}
		return tours;
	}

	/*
	 * Them mot tour vao co so du lieu
	 */
	public void addTour(String name, String base64Image, String description, String startDate, String dueTime,
			String price, boolean status) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "insert into Tour (name, image, description, start_date, duetime, price, status) values (?, ?, ?, ?, ?, ?, ?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, name);
			myStmt.setString(2, base64Image);
			myStmt.setString(3, description);
			myStmt.setString(4, startDate);
			myStmt.setString(5, dueTime);
			myStmt.setString(6, price);
			myStmt.setBoolean(7, status);
			myStmt.execute();
		} finally {
			close(myConn, myStmt,  null);
		}
	}

	/*
	 * Xoa mot tour bang id
	 */
	public void deleteTour(String id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "DELETE FROM Tour WHERE id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, id);
			myStmt.execute();
		} finally {
			close(myConn, myStmt,  null);
		}
	}
	
	/*
	 * Tra ve mot tour bang cach su dung id
	 */
	public Tour loadTour(String id) throws SQLException {
				Tour tour = null;
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;
				
				try {
					myConn = dataSource.getConnection();
					String sql = "SELECT * FROM  Tour WHERE id=" + id;
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery(sql);
					if(myRs.next()) {
						String name = myRs.getString("name");
						String image = myRs.getString("image");
						String description = myRs.getString("description");
						String start_date = myRs.getString("start_date");
						String duetime = myRs.getString("duetime");
						String price = myRs.getString("price");
						boolean status = myRs.getBoolean("status");
						tour = new Tour(Integer.parseInt(id), name, image, description, start_date, duetime, Float.parseFloat(price), status);
					}
				}finally {
					close(myConn, myStmt, myRs);
				}
				return tour;
	}

	/*
	 * Update mot tour bang id
	 */
	public void updateTour(String id, String name, String base64Image, String description, String startDate,
			String dueTime, String price, String status) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null ;
		if(status.equals("true")) {
			status = "1";
		} else {
			status = "0";
		}
		try {
			myConn = dataSource.getConnection();
			// Neu nguoi dung nhap image moi -> update image
			// Neu nguoi dung khong nhap image -> khong update image
			if(!base64Image.equals("")) {
			String sql = "update Tour "
					+ "set name = ?, image = ?, description = ?, start_date = ?, duetime =?, price=?, status=?  where id = " + id;
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, name);
			myStmt.setString(2, base64Image);
			myStmt.setString(3, description);
			myStmt.setString(4, startDate);
			myStmt.setString(5, dueTime);
			myStmt.setString(6, price);
			myStmt.setString(7, status);
			myStmt.execute();
			} else {
				String sql = "update Tour set name = ?, description = ?, start_date = ?, duetime =?, price=?, status=?  where id = " + id;
				myStmt = myConn.prepareStatement(sql);
				myStmt.setString(1, name);
				myStmt.setString(2, description);
				myStmt.setString(3, startDate);
				myStmt.setString(4, dueTime);
				myStmt.setString(5, price);
				myStmt.setString(6, status);
				myStmt.execute();
			}
		}
		finally {
			close(myConn, myStmt, null);
		}
	}

	/*
	 * Tim kiem mot tour bang su dung chuoi
	 * Tim kiem dung chung cho trang index va trang adminTourController
	 */
	public List<Tour> searchTours(String searchName, String searchPrice, String searchDate) throws SQLException {
		List<Tour> tours = new ArrayList<>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;		
		try {
			myConn = dataSource.getConnection();
			// Tim kiem nhung tour co ten, gia tien hoac ngay bat dau bang chuoi nguoi dung nhap vao 
			String sql = "SELECT * FROM  Tour WHERE name=? OR price=? OR start_date=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, searchName);
			myStmt.setString(2, searchPrice);
			myStmt.setString(3, searchDate);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				String id = myRs.getString("id");
				String name = myRs.getString("name");
				String image = myRs.getString("image");
				String description = myRs.getString("description");
				String start_date = myRs.getString("start_date");
				String duetime = myRs.getString("duetime");
				String price = myRs.getString("price");
				boolean status = myRs.getBoolean("status");
				tours.add(new Tour(Integer.parseInt(id), name, image, description, start_date, duetime, Float.parseFloat(price), status));
			}
		}finally {
			close(myConn, myStmt, myRs);
			
		}
		return tours;
	}
		
	/*
	 * Lay 4 tour co gia tien cao nhat va loai di nhung tour co ngay ket thuc > ngay hom nay
	 */
	public List<Tour> topTours() throws SQLException {
		List<Tour> tours = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM  Tour WHERE duetime > CURDATE() ORDER BY price DESC LIMIT 4 ";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String image = myRs.getString("image");
				String description = myRs.getString("description");
				String startDate = myRs.getString("start_date");
				String dueTime = myRs.getString("duetime");
				float price = myRs.getFloat("price");
				boolean status = myRs.getBoolean("status");
				Tour temp = new Tour(id, name, image, description, startDate, dueTime, price, status);
				tours.add(temp);
			}
		}finally {
			close(myConn, myStmt, myRs);
			
		}
		return tours;
	}

	/*
	 * Lay du lieu tu nguoi dung da dat ve cua tour du lich
	 */
	public List<Booking> loadCusInfo(String tour_id) throws SQLException {
				List<Booking> bookings = new ArrayList<>();
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;
				try {
					myConn = dataSource.getConnection();
					// Lay thong tin cua bang user va booking bang cach join 2 bang
					// Lay thong tin con lai tour bang cach chuyen doi so tu adminTourController.jsp
					String sql = "select Booking.id, created_date, adult_quant, child_quant, full_name, user_id, tour_id  from Booking inner join User ON Booking.user_id = User.id  WHERE tour_id = " + tour_id;
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery(sql);
					while(myRs.next()) {
						int id = myRs.getInt("id");
						int user_id = myRs.getInt("user_id");
						String created_date = myRs.getString("created_date");
						int adult_quant = myRs.getInt("adult_quant");
						int child_quant = myRs.getInt("child_quant");
						String userFullName = myRs.getString("full_name");
						Booking book = new Booking(id, userFullName, user_id, Integer.parseInt(tour_id), created_date, adult_quant, child_quant);
						bookings.add(book);
					}
				}finally {
					close(myConn, myStmt, myRs);
					
				}
				return bookings;
	}
	
	/*
	 * Dong lai ket noi voi database
	 */
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(myConn != null) {
				myConn.close(); // doesn't really close it.. puts back in connection pool
			}
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}


}

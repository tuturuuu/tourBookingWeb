package asm1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class BookingDbUtil {
	private DataSource dataSource;

	public BookingDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	/*
	 * Tao mot tour moi trong co so du lieu
	 */
	public void bookingTour(String user_id, String tour_id, String adult_quant, String child_quant) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "insert into Booking (user_id, tour_id, created_date, adult_quant, child_quant) values (?, ?, CURDATE(), ?, ?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user_id);
			myStmt.setString(2, tour_id);
			myStmt.setString(3, adult_quant);
			myStmt.setString(4, child_quant);
			myStmt.execute();
		} finally {
			close(myConn, myStmt,  null);
		}
	}

	/*
	 * Tra ve nhung tour ma nguoi dung da dat
	 */
	public List<Booking> loadBookedTour(String user_id) throws SQLException {
		List<Booking> bookings = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			// Join bang booking voi tour de lay thong tin ve tour
			String sql = "select Booking.id, user_id, tour_id, created_date, adult_quant, child_quant, name, image, price from Booking inner join Tour ON Booking.tour_id = Tour.id  WHERE user_id = " + user_id;
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String tour_id = myRs.getString("tour_id");
				String created_date = myRs.getString("created_date");
				String adult_quant = myRs.getString("adult_quant");
				String child_quant = myRs.getString("child_quant");
				String name = myRs.getString("name");
				String image = myRs.getString("image");
				String price = myRs.getString("price");
				Booking book = new Booking(id, name, image, Float.parseFloat(price), Integer.parseInt(user_id), Integer.parseInt(tour_id), created_date, Integer.parseInt(adult_quant), Integer.parseInt(child_quant));
				bookings.add(book);
			}
		}finally {
			close(myConn, myStmt, myRs);
		}
		return bookings;
	}
	
	/*
	 * Dong ket noi voi database
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

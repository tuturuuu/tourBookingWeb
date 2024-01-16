package asm1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDbUtil {
		
	private DataSource dataSource;

	public UserDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	/*
	 * Lay tat ca cac user trong co so du lieu
	 */
	public List<User> getUsers() throws SQLException{
		List<User> users = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM  User";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String userName = myRs.getString("user_name");
				String password = myRs.getString("password");
				String phoneNum = myRs.getString("phone_num");
				String address = myRs.getString("address");
				String fullName = myRs.getString("full_name");
				String role = myRs.getString("role");
				String email = myRs.getString("email");
				boolean status = myRs.getBoolean("status");
				User temp = new User(id, userName, password, phoneNum, address, fullName, role, email, status);
				users.add(temp);
			}
		}finally {
			close(myConn, myStmt, myRs);
			
		}
		return users;
	}

	/*
	 * Them mot user moi trong co so du lieu
	 */
	public void addUser(User newUser) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "insert into User (user_name, password, phone_num, address, full_name, role, email, status) values (?, ?, ?, ?, ?, ?, ?,?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, newUser.getUserName());
			myStmt.setString(2, newUser.getPassWord());
			myStmt.setString(3, newUser.getPhoneNum());
			myStmt.setString(4, newUser.getAddress());
			myStmt.setString(5, newUser.getFullName());
			myStmt.setString(6, newUser.getRole());
			myStmt.setString(7, newUser.getEmail());
			myStmt.setBoolean(8, newUser.getStatus());
			myStmt.execute();
			
		} finally {
			close(myConn, myStmt,  null);
		}
	}

	/*
	 * Tim kiem mot user dua tren mot chuoi
	 */
	public List<User> searchUsers(String search) throws SQLException {
		List<User> users = new ArrayList<>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM  User WHERE email = ? or phone_num = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, search);
			myStmt.setString(2, search);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				String id = myRs.getString("id");
				String userName = myRs.getString("user_name");
				String password = myRs.getString("password");
				String phoneNum = myRs.getString("phone_num");
				String address = myRs.getString("address");
				String fullName = myRs.getString("full_name");
				String role = myRs.getString("role");
				String email = myRs.getString("email");
				boolean status = myRs.getBoolean("status");
				User temp = new User(Integer.parseInt(id), userName, password, phoneNum, address, fullName, role, email, status);
				users.add(temp);
			}
		}finally {
			close(myConn, myStmt, myRs);
		}
		return users;
	}

	/*
	 * Xoa mot user dua tren id
	 */
	public void deleteUser(String id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "DELETE FROM User WHERE id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, id);
			myStmt.execute();
			
		} finally {
			close(myConn, myStmt,  null);
		}
	}

	/*
	 * Lay thong tin user dua tren id
	 */
	public User loadUser(String id) throws SQLException {
		User user = null;
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM  User WHERE id=" + id;
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			if(myRs.next()) {
				String userName = myRs.getString("user_name");
				String password = myRs.getString("password");
				String phoneNum = myRs.getString("phone_num");
				String address = myRs.getString("address");
				String fullName = myRs.getString("full_name");
				String role = myRs.getString("role");
				String email = myRs.getString("email");
				boolean status = myRs.getBoolean("status");
				user = new User( Integer.parseInt(id), userName, password, phoneNum, address, fullName, role, email, status);
			}
		}finally {
			close(myConn, myStmt, myRs);
		}
		return user;
	}

	/*
	 * Cap nhat thong tin ve user
	 */
	public void updateUser(String id, String username, String phoneNum, String email, String fullName, String role, String status) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null ;
		if(status.equals("true")) {
			status = "1";
		} else {
			status = "0";
		}
		try {
			myConn = dataSource.getConnection();
			String sql = "update User "
					+ "set user_name = ?, phone_num = ?, email = ?, full_name = ?, role =?, status=?  where id = " + id;
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, username);
			myStmt.setString(2, phoneNum);
			myStmt.setString(3, email);
			myStmt.setString(4, fullName);
			myStmt.setString(5, role);
			myStmt.setString(6, status);
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
		}	
	}
	/*
	 * Dong ket noi voi co so du lieu
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
				myConn.close(); 
			}
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}

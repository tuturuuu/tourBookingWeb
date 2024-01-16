package asm1;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String phoneNum;
	private String address;
	private String fullName;
	private String role;
	private String email;
	private boolean status;
	
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	public User(int id, String userName, String passWord, String phoneNum, String address, String fullName, String role,
			String email, boolean status) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNum = phoneNum;
		this.address = address;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
		this.status = status;
	}	
	
	public User(String userName, String passWord, String phoneNum, String fullName, String role, String email,
			boolean status) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNum = phoneNum;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
		this.status = status;
	}
	
	public User(String userName, String passWord, String phoneNum, String address, String fullName, String role,
			String email, boolean status) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNum = phoneNum;
		this.address = address;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", phoneNum=" + phoneNum
				+ ", address=" + address + ", fullName=" + fullName + ", role=" + role + ", email=" + email
				+ ", status=" + status + "]";
	}
 
	
	
}

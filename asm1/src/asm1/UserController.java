package asm1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }
    
    @Resource(name="jdbc/asm1")
	private DataSource dataSource;
    private UserDbUtil UserDbUtil;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			UserDbUtil = new UserDbUtil(dataSource);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/*
	 * Chay function dua tren bien command
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String command = request.getParameter("command");
	        switch (command) {
	            case "SEARCH":
	                searchUser(request, response);
	                break;
	            case "LOAD":
	            	loadUser(request, response);
	            	break;
	            case "LIST":
	                listUser(request, response);
	                break;
	            case "UPDATE":
	                updateUser(request, response);
	                break;
	            case "DELETE":
	                deleteUser(request, response);
	                break;
	            default:
	                response.getWriter().println("default case");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String command = request.getParameter("command");
	        switch (command) {
	            case "LOGIN":
	                loginUser(request, response);
	                break;
	            case "CREATE":
	                createUser(request, response);
	                break;
	            case "SIGNOUT":
	                logOut(request, response);
	                break;
	            default:
	                response.getWriter().println("default case");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
/*
 * Cap nhat thong tin ve nguoi dung
 */
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String id = request.getParameter("userId");
		String username = request.getParameter("username");
		String phoneNum = request.getParameter("phone_num");
		String email = request.getParameter("email");
		String fullName = request.getParameter("full_name");
		String role = request.getParameter("role");
		String status = request.getParameter("status");
		UserDbUtil.updateUser(id, username, phoneNum, email, fullName, role, status);
		listUser(request, response);
	}
	
	/*
	 * Tra ve thong tin ve mot nguoi dung dua tren id
	 */
	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String id = request.getParameter("userId");
		String function = request.getParameter("func");
		User theUser = UserDbUtil.loadUser(id);
		request.setAttribute("the_user", theUser);
		if(function == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/updateUserForm.jsp");
			dispatcher.forward(request, response);
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userDetails.jsp");
		dispatcher.forward(request, response);
	}
	
	/*
	 * Xoa mot nguoi dung dua tren id
	 */
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		UserDbUtil.deleteUser(id);
		listUser(request, response);
	}

	/*
	 * Tim nguoi dung qua chuoi searchValue
	 */
	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String search = request.getParameter("searchValue");
		List<User> users  = UserDbUtil.searchUsers(search);
		request.setAttribute("user_list", users);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/adminUserControl.jsp");
	    dispatcher.forward(request, response);
	}
/*
 * Lay thong tin ve tat ca nguoi dung tu co so du lieu
 */
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	    List<User> users = UserDbUtil.getUsers();
	    request.setAttribute("user_list", users);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/adminUserControl.jsp");
	    dispatcher.forward(request, response);
	}

/*
 * Dang xuat 
 */
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("role");
		session.removeAttribute("userId");
		session.invalidate();
		response.sendRedirect("TourController");
	}

	/*
	 * Tao mot nguoi dung moi va kiem tra dieu kien 
	 */
	private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/signInResult.jsp");
		String email = request.getParameter("email");
		String fullName = request.getParameter("full_name");
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String address = request.getParameter("address");
		String phoneNum = request.getParameter("phone_num");
		String role = request.getParameter("role");
		boolean success = true;
		HttpSession  session = request.getSession();
		// Kiem tra tai khoan du dieu kien
		if(!password.equals(confirmPassword)) {
			success = false;
			request.setAttribute("success", success);
			dispatcher.forward(request, response);
			return;
		}
		
		if(email.equals("") || fullName.equals("") || userName.equals("")|| password.equals("")|| confirmPassword.equals("") || phoneNum.equals("") || role.equals("") ) {
			success = false;
			request.setAttribute("success", success);
			dispatcher.forward(request, response);
			return;
		}
		User newUser = new User(userName, password, phoneNum, address, fullName, role, email, true);
		UserDbUtil.addUser(newUser);
		// Dang nhap vao tai khoan vua tao
		if(session.getAttribute("username") == null) {
			session.setAttribute("username", userName);
			session.setAttribute("role", role);
		}
			request.setAttribute("success", success);
			dispatcher.forward(request, response);
	}

	/*
	 *  Dang nhap vao tai khoan
	 */
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// Tim kiem nhung tai khoan co cung email
		List<User> users =  UserDbUtil.searchUsers(email);
		boolean success = false;
		HttpSession  session = request.getSession();
		//Kiem tra xem co dung mat khau khong
		for(int i = 0; i<users.size();i++) {
				if(password.equals(users.get(i).getPassWord())) {
					success = true;
					session.setAttribute("username", users.get(i).getUserName());
					session.setAttribute("role", users.get(i).getRole());
					session.setAttribute("userId", users.get(i).getId());
					break;
				}
		}
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);
	}
}
	

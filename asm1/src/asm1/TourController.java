package asm1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 * Servlet implementation class TourController
 */
@MultipartConfig
@WebServlet("/TourController")
public class TourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourController() {
        super();
    }
    
    @Resource(name="jdbc/asm1")
	private DataSource dataSource;
    private TourDbUtil TourDbUtil;
    
    @Override
	public void init() throws ServletException {
		super.init();
		try {
			TourDbUtil = new TourDbUtil(dataSource);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * Ham kiem tra parameter command
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        String command = request.getParameter("command");
	        if (command == null) {
	            command = "TOP";
	        }
	        switch (command) {
	            case "SEARCH":
	                searchTour(request, response);
	                break;
	            case "CUSTOMER":
	                cusInfo(request, response);
	                break;
	            case "TOP":
	                topTours(request, response);
	                break;
	            case "LOAD":
	            	loadTour(request, response);
	            	break;
	            case "LIST":
	                listTour(request, response);
	                break;
	            case "DELETE":
	                deleteTour(request, response);
	                break;
	            default:
	                response.getWriter().println("default case GET");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
    /*
     * Ham kiem tra parameter command
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String command = request.getParameter("command");
	        switch (command) {
	            case "CREATE":
	                createTour(request, response);
	                break;
	            case "UPDATE":
	                updateTour(request, response);
	                break;
	            default:
	                response.getWriter().println("default case POST");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Lay top 4 tour co gia tien cao nhat de hien thi o trang index.jsp
	 */
	private void topTours(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		List<Tour> tours = TourDbUtil.topTours();
	    request.setAttribute("tour_list", tours);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		 dispatcher.forward(request, response);
	}
	
	/*
	 * Lay tat ca cac tour va chuyen cho adminTourControl.jsp
	 */
	private void listTour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	 	List<Tour> tours = TourDbUtil.getTours();
	    request.setAttribute("tour_list", tours);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTourControl.jsp");
	    dispatcher.forward(request, response);
}
	/*
	 * Lay thong tin cua nguoi dung giua tren 1 tour id chuyen cho customerInfo.jsp
	 */
	private void cusInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String tour_id = request.getParameter("id");
		String tourName = request.getParameter("name");
		String tempPrice = request.getParameter("price");
		List<Booking> bookings = TourDbUtil.loadCusInfo(tour_id);
		float tourPrice = Float.parseFloat(tempPrice);
		request.setAttribute("tour_name", tourName);
		request.setAttribute("tour_price", tourPrice);
		request.setAttribute("bookings", bookings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerInfo.jsp");
		dispatcher.forward(request, response);
	}

	/*
	 * Tao mot tour moi trong co so du lieu
	 */
	private void createTour(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
			 String name = request.getParameter("name");
			 Part filePart = request.getPart("image");
			 String description = request.getParameter("description");
			 String startDate = request.getParameter("start_date");
			 String dueTime= request.getParameter("due_time");
			 String price = request.getParameter("price");
			 String temp = request.getParameter("status");
			 boolean status;
			 if(temp.equals("available")){
					 status = true;
			 }
			 else { 
				 	status = false;
			 }
			 // Xu ly du lieu anh 
			 String imageFileName = filePart.getSubmittedFileName();
			 System.out.println("Selected Image File Name: " + imageFileName);
			 InputStream fileContent = filePart.getInputStream();
			 byte[] imageBytes = fileContent.readAllBytes();  // Read image bytes
			 // Base64 encode the image bytes
			 String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			 // Store the base64 encoded image in the database
			 TourDbUtil.addTour(name, base64Image, description, startDate, dueTime, price, status);
			 listTour(request, response);
	}

	/*
	 * Xoa mot tour dua tren id trong co so du lieu
	 */
	private void deleteTour(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
			String id = request.getParameter("id");
			TourDbUtil.deleteTour(id);
			listTour(request, response);
	}

	/*
	 * Update mot tour trong co so du lieu
	 */
	private void updateTour(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		 String id = request.getParameter("tourId");
		 String name = request.getParameter("name");
		 Part filePart = request.getPart("image");
		 String description = request.getParameter("description");
		 String startDate = request.getParameter("start_date");
		 String dueTime= request.getParameter("due_time");
		 String price = request.getParameter("price");
		 String status = request.getParameter("status");
		 // Xu li du lieu anh
		 InputStream fileContent = filePart.getInputStream();
		 byte[] imageBytes = fileContent.readAllBytes();  // Read image bytes
		 // Base64 encode the image bytes
		 String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		TourDbUtil.updateTour(id, name, base64Image, description, startDate, dueTime, price, status);
		listTour(request, response);
	}
	
	/*
	 * Load tour tu co so du lieu
	 */
	private void loadTour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				String id = request.getParameter("id");
				String function = request.getParameter("func");
				Tour theTour = TourDbUtil.loadTour(id);
				request.setAttribute("the_tour", theTour);
				// Load tour tu co so du lieu ra update form
				if(function == null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/updateTourForm.jsp");
					dispatcher.forward(request, response);
					return;
				} 
				// Load tour tu co so du lieu de hien thi cho nguoi dung
				if(function.equals("booking")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/userBooking.jsp");
					dispatcher.forward(request, response);
					return;
				}
				// Load tour tu co so du lieu de hien thi chi tiet
				RequestDispatcher dispatcher = request.getRequestDispatcher("/tourDetails.jsp");
				dispatcher.forward(request, response);
	}
	
	/*
	 * Tim kiem mot tour dua tren mot chuoi ma nguoi dung nhap
	 */
	private void searchTour(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String searchName = request.getParameter("searchName");
		String searchPrice = request.getParameter("searchPrice");
		String searchDate = request.getParameter("searchDate");
		String diff = request.getParameter("diff");
		List<Tour> tours  = TourDbUtil.searchTours(searchName, searchPrice, searchDate);
		request.setAttribute("tour_list", tours);
		// Search o trang index
		if(diff != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
		//Search o trang admin
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTourControl.jsp");
	    dispatcher.forward(request, response);
	}
}

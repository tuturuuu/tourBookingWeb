package asm1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class BookingController
 */
@MultipartConfig
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
    }

    
    @Resource(name="jdbc/asm1")
   	private DataSource dataSource;
    private BookingDbUtil BookingDbUtil;
       
       @Override
   	public void init() throws ServletException {
   		super.init();
   		try {
   			BookingDbUtil = new BookingDbUtil(dataSource);
   		} catch(Exception e) {
   			throw new ServletException(e);
   		}
   	}
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        String command = request.getParameter("command");
	        switch (command) {
	            case "BOOK":
	                bookingTour(request, response);
	                break;
	            case "LOAD":
	                loadTour(request, response);
	                break;
	            default:
	                response.getWriter().println("default case GET");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	/*
	 * Tao ra mot ve o trong co so du lieu
	 */
	private void bookingTour(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		HttpSession  session = request.getSession();
		//Lay id cua nguoi dung
		int tempUserId = (int) session.getAttribute("userId");
		String tour_id = request.getParameter("tourId");
		String adult_quant =  request.getParameter("quantityAdult");
		String child_quant =  request.getParameter("quantityChild");
		String user_id = Integer.toString(tempUserId);
		BookingDbUtil.bookingTour(user_id, tour_id, adult_quant, child_quant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookResult.jsp");
		dispatcher.forward(request, response);
	}
	
	/*
	 * Lay cac tour ma nguoi dung da dang ky
	 */
	private void loadTour(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		HttpSession session = request.getSession();
		// Neu nguoi dung khong dang nhap -> in ra thong bao
		if(session.getAttribute("userId") == null) {
			response.getWriter().print("You need to login to use this function");
		}
		//Lay id cua nguoi dung
		int tempUserId = (int) session.getAttribute("userId");
		String user_id = Integer.toString(tempUserId);
		List<Booking> bookings = BookingDbUtil.loadBookedTour(user_id);
		request.setAttribute("bookings", bookings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tour.jsp");
		dispatcher.forward(request, response);
	}
}

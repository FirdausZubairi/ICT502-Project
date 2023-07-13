package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.bookingDetailService;
import services.busService;

import java.io.IOException;
import java.util.List;

import bean.BusDest;

/**
 * Servlet implementation class ReadBookingDetail
 */
@WebServlet("/customer/bookingdetail")
public class ReadBookingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookingDetailService BookingDetailService ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		BookingDetailService = new bookingDetailService();
	}
	
    public ReadBookingDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BusDest> listTripCust = BookingDetailService.selectAllBusTripCustomer();
		request.setAttribute("listTripCust", listTripCust);
		System.out.println(listTripCust.isEmpty());
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookingdetail.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}

package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.bookingService;
import services.passengerService;

import java.io.IOException;
import java.sql.SQLException;

import bean.booking;
import bean.passenger;

/**
 * Servlet implementation class passengerControl
 */
@WebServlet("/customer/passengerControl")
public class passengerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private passengerService PassengerService;
	
	public void init() {
		PassengerService = new passengerService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passengerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/bookingdetail-customer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		HttpSession session = request.getSession();
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");

		System.out.println("name: " + name);
		System.out.println("phone: " + phone);
		

		try {
		    System.out.println("hello 2");
		    passenger Passenger = new passenger( name, phone);
		    PassengerService.insertPassenger(Passenger);
		    System.out.println("passenger successfully");

		    response.sendRedirect(request.getContextPath() + "/customer/seatSelect.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	
	
}
	}



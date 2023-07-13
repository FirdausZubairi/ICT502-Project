package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.bookService;
import services.passengerService;
import services.staffService;
import services.ticketService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.book;
import bean.bus;
import bean.destination;
import bean.passenger;
import bean.staff;
import bean.ticket;
import bean.trip;

/**
 * Servlet implementation class CreateBook
 */
@WebServlet("/customer/seatSelect")
public class CreateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookService BookService;
	private ticketService TicketService;
	private passengerService PassengerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		BookService = new bookService();
		TicketService = new ticketService();
		PassengerService = new passengerService();
	}
    public CreateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ticket> listTicket = TicketService.selectAllTicket();
		List<passenger> listPassenger= PassengerService.selectAllPassenger();		
		request.setAttribute("listTicket", listTicket);
		request.setAttribute("listPassenger", listPassenger);
		RequestDispatcher rd = request.getRequestDispatcher("seatSelect.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		ticket Ticket = new ticket();
		passenger Passenger = new passenger();
		
		Ticket.setTicketID(Integer.parseInt(request.getParameter("ticketID")));
		Passenger.setPassID(Integer.parseInt(request.getParameter("passID")));
		
		System.out.println("Ticket ID : " + Ticket.getTicketID());
		System.out.println("Passenger ID : " + Passenger.getPassID());
		
		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
		int passID = Integer.parseInt(request.getParameter("passID"));
	
		String seat = request.getParameter("seat");
		Double totalPrice = Double.parseDouble(request.getParameter("totalPrice")); 
		String paymentMethod = request.getParameter("paymentMethod");
		
		System.out.println("ticketID : " + ticketID);
		System.out.println("passengerID : " + passID);
		System.out.println("seat: " + seat);
		System.out.println("total payment: " + totalPrice);
		System.out.println("payment method: " + paymentMethod);
		
	try {
	    System.out.println("hello 2");
	    book Book = new book(ticketID, passID, seat, totalPrice, paymentMethod);
	    BookService.insertBook(Book);
	    System.out.println("Booking inserted successfully");

	    response.sendRedirect(request.getContextPath() + "/customer/seatSelect");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
//		HttpSession session = request.getSession();
//		
//		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
//		int passID = Integer.parseInt(request.getParameter("passID")); 
//		
//		String seat = request.getParameter("seat");
//		Double totalPrice = Double.parseDouble(request.getParameter("totalPrice")); 
//		String paymentMethod = request.getParameter("paymentMethod");
//
//		System.out.println("username: " + seat);
//		System.out.println("password: " + totalPrice);
//		System.out.println("name: " + paymentMethod);
//
//		System.out.println("hello 1");
//
//		try {
//		    System.out.println("hello 2");
//		    book Book = new book(ticketID, passID, seat, totalPrice, paymentMethod);
//		    BookService.insertBook(Book);
//		    System.out.println("Booking inserted successfully");
//
//		    response.sendRedirect(request.getContextPath() + "/customer/seatSelect");
//		} catch (SQLException e) {
//		    e.printStackTrace();
//		}
		
		
	}

}

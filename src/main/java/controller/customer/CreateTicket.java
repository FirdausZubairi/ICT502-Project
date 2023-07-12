package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.staffService;
import services.ticketService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import bean.staff;
import bean.ticket;

/**
 * Servlet implementation class CreateTicket
 */
@WebServlet("/customer/CreateTicket")
public class CreateTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ticketService TicketService;
	
	public void init() {
		TicketService = new ticketService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create-ticket.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		Date ticketDate = Date.valueOf(request.getParameter("ticketDate"));
		String price = request.getParameter("price");

		System.out.println("type: " + type);
		System.out.println("date: " + ticketDate);
		System.out.println("price: " + price);

		System.out.println("hello 1");

		try {
		    System.out.println("hello 2");
		    ticket Ticket = new ticket(type, ticketDate, price);
		    TicketService.insertTicket(Ticket);
		    System.out.println("Staff inserted successfully");

		    response.sendRedirect(request.getContextPath() + "/customer/SeatSelect.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
		
		
		
	}



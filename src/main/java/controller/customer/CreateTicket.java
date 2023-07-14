package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.busService;
import services.destinationService;
import services.staffService;
import services.ticketService;
import services.tripService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import bean.bus;
import bean.destination;
import bean.passenger;
import bean.staff;
import bean.ticket;

/**
 * Servlet implementation class CreateTicket
 */
@WebServlet("/customer/create-ticket")
public class CreateTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ticketService TicketService;
	private destinationService DestinationService;
	private busService BusService;
	
	public void init() {
		TicketService = new ticketService();
		DestinationService = new destinationService();
		BusService = new busService();
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<bus> listBus = BusService.selectAllBusName();
		List<destination> listDest= DestinationService.selectAllDestination();		
		request.setAttribute("listBus", listBus);
		request.setAttribute("listDestination", listDest);
		RequestDispatcher rd = request.getRequestDispatcher("/customer/create-ticket.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		bus Bus = new bus();
		destination Dest = new destination();
		
		Bus.setName(request.getParameter("name"));
		Dest.setDestinationName(request.getParameter("destinationName"));
		
		System.out.println("model Bus Name : " + Bus.getName());
		System.out.println("model Destination Name : " + Dest.getDestinationName());
		
		int busID = Integer.parseInt(request.getParameter("busID"));
		int destinationID = Integer.parseInt(request.getParameter("destinationID"));
				Date ticketDate = Date.valueOf(request.getParameter("ticketDate"));
		
		System.out.println("busID : " + busID);
		System.out.println("destinationID : " + destinationID);
		System.out.println("Time: " + ticketDate);
		
	int id_ticket = 0;	
	try {
		id_ticket = TicketService.insertTicket(new ticket(ticketDate, busID, destinationID));
	    System.out.println("hello 2");
	    ticket Ticket = new ticket(ticketDate, busID, destinationID);
	    TicketService.insertTicket(Ticket);
	    System.out.println("Ticket inserted successfully");
	    session.setAttribute("ticketID", id_ticket);

	    response.sendRedirect(request.getContextPath() + "/customer/seatSelect");
	} catch (SQLException e) {
	    e.printStackTrace();
		
	}
		
		
	}
}


package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.busService;
import services.ticketService;

import java.io.IOException;
import java.util.List;

import bean.BusDest;
import bean.TBD;
import bean.ticket;

/**
 * Servlet implementation class ReadTicket
 */
@WebServlet("/customer/viewticket")
public class ReadTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ticketService TicketService;
       
	public void init() {
		TicketService = new ticketService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<TBD> listTicket = TicketService.selectAllTicketService();
		request.setAttribute("listTicket", listTicket);
		System.out.println(listTicket.isEmpty());
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewticket.jsp");
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

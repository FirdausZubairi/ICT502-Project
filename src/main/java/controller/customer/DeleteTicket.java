package controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ticketService;
import services.tripService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteTicket
 */
@WebServlet("/customer/DeleteTicket")
public class DeleteTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ticketService TicketService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		TicketService = new ticketService();
	}
	
    public DeleteTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			boolean statusTicket = TicketService.deleteTicket(id);
			if (statusTicket) {
				response.sendRedirect(request.getContextPath() + "/customer/viewticket?id=" + id + "&delete=false");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}

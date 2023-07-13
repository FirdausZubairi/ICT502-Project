package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.destinationService;

import java.io.IOException;
import java.sql.SQLException;

import bean.destination;

/**
 * Servlet implementation class CreateDestination
 */
@WebServlet("/staff/CreateDestination")
public class CreateDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private destinationService DestinationService;
	
	public void init() {
		DestinationService = new destinationService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDestination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/staff/destination.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		String destinationName = request.getParameter("destinationName");
		
		System.out.println("name: " + destinationName);

		try {	
			destination Destination = new destination(destinationName);
		    DestinationService.insertDestination(Destination);
		    System.out.println("Destination inserted successfully");

		    response.sendRedirect(request.getContextPath() + "/staff/bustrip.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

}

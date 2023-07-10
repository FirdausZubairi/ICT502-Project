package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.busService;
import services.staffService;

import java.io.IOException;
import java.sql.SQLException;

import bean.bus;

/**
 * Servlet implementation class CreateBus
 */
@WebServlet("/staff/CreateBus")
public class CreateBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private busService BusService;
	
	public void init() {
		BusService = new busService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBus() {
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
		String name = request.getParameter("name");
		String noPlate = request.getParameter("noPlate");
		
		System.out.println("name: " + name);
		System.out.println("role: " + noPlate);

		try {	
			bus Bus = new bus(name, noPlate);
		    BusService.insertBus(Bus);
		    System.out.println("Bus inserted successfully");

		    response.sendRedirect(request.getContextPath() + "/staff/destination.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

}

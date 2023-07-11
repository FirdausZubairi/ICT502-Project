package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.busService;
import services.tripService;

import java.io.IOException;
import java.sql.SQLException;

import bean.bus;
import bean.trip;

/**
 * Servlet implementation class CreateTrip
 */
@WebServlet("/staff/CreateTrip")
public class CreateTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private tripService TripService;
       
	public void init() {
		TripService = new tripService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTrip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/staff/create-trip.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		String destinationID = request.getParameter("destinationID");
		String busID = request.getParameter("busID");
		String time = request.getParameter("time");
		
		System.out.println("destinationID: " + destinationID);
		System.out.println("busID: " + busID);
		System.out.println("time: " + time);

		try {	
			trip Trip = new trip( time);
		    TripService.insertTrip(Trip);
		    System.out.println("Trip inserted successfully");

		    response.sendRedirect(request.getContextPath() + "/staff/create-trip.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
	}



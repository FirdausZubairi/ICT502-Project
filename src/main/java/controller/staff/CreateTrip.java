package controller.staff;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import services.busService;
import services.destinationService;
import services.staffService;

import services.tripService;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import bean.bus;
import bean.destination;

import bean.trip;

/**
 * Servlet implementation class CreateTrip
 */

@WebServlet("/staff/create-trip")
public class CreateTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private busService BusService;
	private destinationService DestinationService;
	private tripService TripService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		BusService = new busService();
		DestinationService = new destinationService();
		TripService = new tripService();
		
	}
	

    public CreateTrip() {
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
		RequestDispatcher rd = request.getRequestDispatcher("create-trip.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		doGet(request, response);
		bus Bus = new bus();
		destination Dest = new destination();
		
		Bus.setName(request.getParameter("name"));
		Dest.setDestinationName(request.getParameter("destinationName"));
		
		System.out.println("model Bus Name : " + Bus.getName());
		System.out.println("model Destination Name : " + Dest.getDestinationName());
		
		int busID = Integer.parseInt(request.getParameter("busID"));
		int destinationID = Integer.parseInt(request.getParameter("destinationID"));
	
		String time = request.getParameter("time");
		
		System.out.println("busID : " + busID);
		System.out.println("destinationID : " + destinationID);
		System.out.println("Time: " + time);
		
	try {
	    System.out.println("hello 2");
	    trip Trip = new trip(destinationID, busID, time);
	    TripService.insertTrip(Trip);
	    System.out.println("Trip inserted successfully");

	    response.sendRedirect(request.getContextPath() + "/staff/bustrip");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
}
	


}


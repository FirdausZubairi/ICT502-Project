package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.busService;

import java.io.IOException;
import java.sql.SQLException;

import bean.bus;

/**
 * Servlet implementation class UpdateBus
 */
@WebServlet("/staff/update-bus")
public class UpdateBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private busService BusService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	bus Bus = new bus();
		int id = Integer.parseInt(request.getParameter("id"));
		String success = request.getParameter("success");
		System.out.println("success : " + success);
		Bus = BusService.getOneBus(id);
		
		request.setAttribute("Bus", Bus);

		System.out.println(Bus);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-bus.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int busID = Integer.parseInt(request.getParameter("busID"));
		String name = request.getParameter("name");
		String noPlate = request.getParameter("noPlate");
			
		bus Bus = new bus(busID, name, noPlate);
		
		
			try {
				boolean statusUpdate = BusService.updateBus(Bus);
				if(statusUpdate) {
					response.sendRedirect(request.getContextPath() + "/staff/busdetail-staff?id=" + Bus.getBusID() + "&success=true");
				}else {
					response.sendRedirect(request.getContextPath() + "/staff/busdetail-staff?id=" + Bus.getBusID() + "&success=false");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


}

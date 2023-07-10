package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.busService;
import services.staffService;

import java.io.IOException;
import java.util.List;

import bean.BusDest;
import bean.bus;

/**
 * Servlet implementation class ReadBus
 */
@WebServlet("/staff/busdetail-staff")
public class ReadBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private busService BusService;
	
	public void init() {
		BusService = new busService();
	}
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadBus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<bus> listBus = BusService.selectAllBus();
		request.setAttribute("listBus", listBus);
		System.out.println(listBus.isEmpty());
		RequestDispatcher dispatcher = request.getRequestDispatcher("busdetail-staff.jsp");
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

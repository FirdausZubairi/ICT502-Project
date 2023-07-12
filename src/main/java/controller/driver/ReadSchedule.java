package controller.driver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.busService;
import services.scheduleService;

import java.io.IOException;
import java.util.List;

import bean.BusDest;

/**
 * Servlet implementation class ReadSchedule
 */
@WebServlet("/driver/schedule-driver")
public class ReadSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private scheduleService ScheduleService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		ScheduleService = new scheduleService();
	}
	
    public ReadSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BusDest> listBusSchedule = ScheduleService.selectAllBusSchedule();
		request.setAttribute("listBusSchedule", listBusSchedule);
		System.out.println(listBusSchedule.isEmpty());
		RequestDispatcher dispatcher = request.getRequestDispatcher("schedule-driver.jsp");
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

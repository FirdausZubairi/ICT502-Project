package controller.driver;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import services.ChartDOA;
/**
 * Servlet implementation class ChartController
 */
@WebServlet("/driver/dashboarddriver")
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChartDOA chartDOA;
	
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
	
    public ChartController() {
        super();
        chartDOA = new ChartDOA();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int busCount = chartDOA.getCountBus();
		int destCount = chartDOA.getCountDest();
		
		System.out.println("name COUNT: " + busCount);
		System.out.println("dest COUNT: " + destCount);
		
		  request.setAttribute("busCount", busCount);
		  request.setAttribute("destCount", destCount);
		  request.getRequestDispatcher("/driver/dashboarddriver.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}


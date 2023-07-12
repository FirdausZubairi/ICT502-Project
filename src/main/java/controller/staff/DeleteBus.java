package controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.busService;
import services.staffService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteBus
 */
@WebServlet("/staff/DeleteBus")
public class DeleteBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private busService BusService;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		BusService = new busService();
	}
	
    public DeleteBus() {
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
			boolean statusBus = BusService.deleteBus(id);
			if (statusBus) {
				response.sendRedirect(request.getContextPath() + "/staff/busdetail-staff?id=" + id + "&delete=false");
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

package controller.staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.staffService;
import services.tripService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteBusDes
 */
@WebServlet("/staff/DeleteBusDes")
public class DeleteBusDes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private tripService TripService;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		TripService = new tripService();
	}
    public DeleteBusDes() {
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
			boolean statusTrip = TripService.deleteTrip(id,id);
			if (statusTrip) {
				response.sendRedirect(request.getContextPath() + "/staff/bustrip?id=" + id + "&delete=false");
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

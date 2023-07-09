package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import services.staffService;
import bean.staff;

/**
 * Servlet implementation class ReadStaff
 */
@WebServlet("/accountdetails-staff")
public class ReadStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffService StaffService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		StaffService = new staffService();
	}
	
    public ReadStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<staff> listStaff = StaffService.selectAllStaff();
		request.setAttribute("listPatient", listStaff);
//		System.out.println();
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountdetails-staff.jsp");
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

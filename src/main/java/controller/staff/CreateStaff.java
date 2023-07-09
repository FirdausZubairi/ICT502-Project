package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import services.staffService;
import bean.staff;

/**
 * Servlet implementation class CreateStaff
 */
@WebServlet("/staff/CreateStaff")
public class CreateStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffService StaffService;
	
	public void init() {
		StaffService = new staffService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/staff/register-staff.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("name: " + name);
		System.out.println("role: " + role);

		System.out.println("hello 1");

		try {
		    System.out.println("hello 2");
		    staff Staff = new staff(username, password, name, role);
		    StaffService.insertStaff(Staff);
		    System.out.println("Staff inserted successfully");

		    response.sendRedirect(request.getContextPath() + "/staff/accountdetails-staff");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}

}

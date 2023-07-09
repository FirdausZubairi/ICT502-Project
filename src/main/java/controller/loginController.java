package controller;

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
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffService staffService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
        staffService = new staffService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   
		   String username = request.getParameter("username");
	       String password = request.getParameter("password");
	       String role = request.getParameter("role");
	  
	       
	       staff login = new staff( username, password, role);
	       staff stf = null;

	       if (role.equals("clerk")) {
	            try {
					stf = staffService.loginClerk(login);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } else if ( role.equals("driver")){
	            try {
					stf = staffService.loginDriver(login);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	  
	        
	        if (stf != null) {
	            // Login successful	
	            // Set the session based on the returned Login object
	            HttpSession session = request.getSession();
	            session.setAttribute("login", stf);
	            System.out.println("session: "+session);

	            // Perform any necessary actions (e.g., redirect to a home page)
	            if (stf.getRole().equals("clerk")) {
	                // Customer login
	                response.sendRedirect("staff/dashboard-staff.jsp");
	            } else if (stf.getRole().equals("driver")) {
	                // Admin login
	                response.sendRedirect("driver/dashboarddriver.jsp");
	            
	            } else {
	                // Unknown role
	                response.sendRedirect("test.jsp?error=1");
	            }
	        } else {
	            // Login failed
	            // Perform any necessary actions (e.g., show an error message, redirect to login page)
	            response.sendRedirect("login.jsp");
	        }
	    }

}

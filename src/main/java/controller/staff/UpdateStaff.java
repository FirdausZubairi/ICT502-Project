package controller.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.staffService;

import java.io.IOException;
import java.sql.SQLException;

import bean.staff;

/**
 * Servlet implementation class UpdateStaff
 */
@WebServlet("/staff/update-staff")
public class UpdateStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffService StaffService;
	
	public void init() {
		StaffService = new staffService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		staff Staff = new staff();
		int id = Integer.parseInt(request.getParameter("id"));
		String success = request.getParameter("success");
		System.out.println("success : " + success);
		Staff = StaffService.getOneStaff(id);
		
		request.setAttribute("Staff", Staff);

		System.out.println(Staff);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-staff.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int staffID = Integer.parseInt(request.getParameter("staffID"));
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
			
		staff Staff = new staff(staffID, username, name, password, role);
		
		
			try {
				boolean statusUpdate = StaffService.updateStaff(Staff);
				if(statusUpdate) {
					response.sendRedirect(request.getContextPath() + "/staff/accountdetails-staff?id=" + Staff.getStaffID() + "&success=true");
				}else {
					response.sendRedirect(request.getContextPath() + "/staff/update-staff?id=" + Staff.getStaffID() + "&success=false");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


}

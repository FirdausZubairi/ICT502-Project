package controller.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.bookService;
import services.passengerService;

import java.io.IOException;
import java.sql.SQLException;

import bean.book;
import bean.booking;
import bean.passenger;

/**
 * Servlet implementation class CreateBook
 */
public class CreateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookService BookService;
	
	public void init() {
		BookService = new bookService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/ticket.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
		int passID = Integer.parseInt(request.getParameter("passID"));
		int refNo = Integer.parseInt(request.getParameter("refNo"));
		double totalprice = Double.parseDouble(request.getParameter("totalprice"));
		String paymentmethod = request.getParameter("paymentmethod");

		System.out.println("ticketID: " + ticketID);
		System.out.println("passID: " + passID);
		System.out.println("refNo: " + refNo);
		System.out.println("totalprice: " + totalprice);
		System.out.println("paymentmethod" + paymentmethod);

		try {
		    System.out.println("hello 2");
		    book Book = new book(ticketID, passID, refNo, totalprice, paymentmethod);
		    BookService.insertBook(Book);
		    System.out.println("booking successfully");

		    response.sendRedirect(request.getContextPath() + "/customer/seatSelect.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	
	
	}
}




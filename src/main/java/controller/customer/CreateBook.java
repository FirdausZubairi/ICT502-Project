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
import bean.passenger;

/**
 * Servlet implementation class CreateBook
 */
@WebServlet("/customer/CreateBook")
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/seatSelect.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		String seat =request.getParameter("seat");
		double totalPrice =Double.parseDouble(request.getParameter("totalPrice"));
		String paymentMethod =request.getParameter("paymentMethod");

		System.out.println("seat: " + seat);
		System.out.println("totalPrice: " + totalPrice);
		System.out.println("paymentMethod :"  + paymentMethod);
		

		try {
		    System.out.println("hello 2");
		    book Book = new book( seat, totalPrice, paymentMethod);
		    BookService.insertBook(Book);
		    System.out.println("book successfully");

		    response.sendRedirect(request.getContextPath() + "/customer/seatSelect.jsp");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	
	
}
	}



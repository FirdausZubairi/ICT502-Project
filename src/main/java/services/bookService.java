package services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.book;

import helper.EncryptDecryptPass;

public class bookService {
	private EncryptDecryptPass encryptDecryptPass;
	
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	
	private String INSERT_BOOK_SQL = "INSERT INTO book(ticketID, passID, refNo, totalPrice, paymentmethod) VALUES(?,?,?,?,?)";
	
	public bookService() {
		encryptDecryptPass = new EncryptDecryptPass();
	}
	

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	// CREATE book
		public boolean insertBook(book Book) throws SQLException {
			boolean status = false;

			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
				preparedStatement.setInt(1, Book.getTicketID());
				preparedStatement.setInt(2, Book.getPassID());
				preparedStatement.setInt(3, Book.getRefNo());
				preparedStatement.setDouble(4, Book.getTotalPrice());
				preparedStatement.setString(5, Book.getPaymentmethod());

				preparedStatement.executeUpdate();

				status = true;
				
			

			} catch (SQLException e) {
				printSQLException(e);
				status = false;
			}

			return status;
		}
}

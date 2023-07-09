package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.booking;
import bean.staff;
import helper.EncryptDecryptPass;

public class bookingService {
private EncryptDecryptPass encryptDecryptPass;
	
	
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	
	private String INSERT_BOOKING_SQL = "INSERT INTO book(ticketID, passID, RefNo, totalprice, paymentmethod) VALUES(?,?,?,?,?)";
	private String SELECT_ALL_BOOKING = "SELECT * FROM book;";
	
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
	static Connection con = null;
    static PreparedStatement ps = null;
    static Statement s = null;
    static ResultSet rs = null;
    
    
  //CREATE 
  	public boolean insertBook(booking Booking) throws SQLException {
  		boolean status = false;

  		try (Connection connection = getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
  			preparedStatement.setInt(1, Booking.getTicketID());
  			preparedStatement.setInt(2, Booking.getPassID());
  			preparedStatement.setInt(3, Booking.getRefNo());
  			preparedStatement.setDouble(4, Booking.getTotalprice());
  			preparedStatement.setString(5, Booking.getPaymentmethod());

  			preparedStatement.executeUpdate();

  			status = true;

  		} catch (SQLException e) {
  			printSQLException(e);
  			status = false;
  		}

  		return status;
  	}
  	
}

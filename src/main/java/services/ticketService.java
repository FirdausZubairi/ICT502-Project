package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BusDest;
import bean.TBD;
import bean.bus;
import bean.staff;
import bean.ticket;
import helper.EncryptDecryptPass;

public class ticketService {
	private EncryptDecryptPass encryptDecryptPass;

	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";

	private String INSERT_TICKET_SQL = "INSERT INTO ticket( ticketDate, busID, destinationID) VALUES(?,?,?)";
	private String SELECT_ALL_TICKET = "SELECT t.ticketID, t.ticketdate, t.destinationid, t.busid, b.name , d.destinationname from bus b join ticket t on t.busid = b.busid join destination d on t.destinationid = d.destinationid";

	public ticketService() {
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

	// CREATE Ticket
	public int insertTicket(ticket Ticket) throws SQLException {
		
		int id = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKET_SQL, new String[] { "ticketid" })) {
				
			preparedStatement.setDate(1, Ticket.getTicketDate());
			preparedStatement.setInt(2, Ticket.getBusID());
			preparedStatement.setInt(3, Ticket.getDestinationID());
			
			System.out.println(id);
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("Ticket ID: " + rs.getInt(1));
				id = rs.getInt(1);
				System.out.println("Ticket Pass... ");

			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return id;
	}

	// READ Ticket
	public List<ticket> selectAllTicket() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ticket> Ticket = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TICKET);) {
//		            System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ticketID = rs.getInt("ticketID");
				Date ticketDate = rs.getDate("ticketDate");
				int destinationID = rs.getInt("destinationID");
				int busID = rs.getInt("busID");

//						if(doctor_id == session_doc_id) {

				Ticket.add(new ticket(ticketID, ticketDate, destinationID, busID));
//						}

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Ticket;
	}

	// READ ticket JOIN Bus Destination
	public List<TBD> selectAllTicketService() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<TBD> tbd = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TICKET);) {
//		            System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ticketID = rs.getInt("ticketID");
				Date ticketDate = rs.getDate("ticketDate");
				int destinationID = rs.getInt("destinationID");
				int busID = rs.getInt("busID");
				String name = rs.getString("name");
				String destinationName = rs.getString("destinationName");

//						if(doctor_id == session_doc_id) {

				tbd.add(new TBD(ticketID, ticketDate, busID, destinationID, name, destinationName));

//						}

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tbd;
	}

}

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.bus;
import bean.destination;
import bean.staff;
import bean.trip;
import helper.EncryptDecryptPass;

public class destinationService {
	private EncryptDecryptPass encryptDecryptPass;

	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";

	private String INSERT_DESTINATION_SQL = "INSERT INTO destination(destinationName) VALUES(?)";
	private String SELECT_ALL_DESTINATION = "SELECT * FROM destination ORDER BY destinationID";

	public destinationService() {
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

	// CREATE Destination
	public boolean insertDestination(destination Destination) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DESTINATION_SQL)) {
			preparedStatement.setString(1, Destination.getDestinationName());

			preparedStatement.executeUpdate();

			status = true;

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}

	// READ BRIDGE
	public List<destination> selectAllDestination() {

		List<destination> Dest = new ArrayList<>();
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DESTINATION);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int destinationID = rs.getInt("destinationID");
				String destinationName = rs.getString("destinationName");
				System.out.println(destinationID + destinationName);

				Dest.add(new destination(destinationID, destinationName));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}

		return Dest;
	}

}

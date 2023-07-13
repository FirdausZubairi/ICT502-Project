package services;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import bean.trip;
import helper.EncryptDecryptPass;

public class tripService {
	private EncryptDecryptPass encryptDecryptPass;



	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	

	private String INSERT_TRIP_SQL = "INSERT INTO trip(busid, destinationid, time) VALUES(?,?,?)";
	private String DELETE_TRIP_SQL = "DELETE FROM trip WHERE busid = ? AND destinationid = ?";
			
	public tripService() {
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
	

	// CREATE Trip
		public boolean insertTrip(trip Trip) throws SQLException {
			boolean status = false;

			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRIP_SQL)) {
				preparedStatement.setInt(1, Trip.getBusID());
				preparedStatement.setInt(2, Trip.getDestinationID());
				preparedStatement.setString(3, Trip.getTime());

				System.out.println("Bus ID :" + Trip.getBusID());
				System.out.println("Destination ID :" + Trip.getDestinationID());
				
				preparedStatement.executeUpdate();
			

				status = true;

			} catch (SQLException e) {
				printSQLException(e);
				status = false;
			}

			return status;
		}
	// DELETE Trip
		public boolean deleteTrip(int busID, int destinationID) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection();) {
	        	PreparedStatement statement = connection.prepareStatement(DELETE_TRIP_SQL);
	            statement.setInt(1, busID);
	            statement.setInt(2, destinationID);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
}

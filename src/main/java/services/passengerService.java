package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.bus;
import bean.destination;
import bean.passenger;
import helper.EncryptDecryptPass;

public class passengerService {
	private EncryptDecryptPass encryptDecryptPass;
	
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	
	private String INSERT_PASSENGER_SQL = "INSERT INTO passenger(name, phone) VALUES(?,?)";
	private String SELECT_ALL_PASSENGER = "SELECT * FROM passenger";
	
	public passengerService() {
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
	
	//CREATE Passenger
			public boolean insertPassenger(passenger Passenger) throws SQLException {
				boolean status = false;

				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PASSENGER_SQL)) {
					preparedStatement.setString(1, Passenger.getName());
					preparedStatement.setString(2, Passenger.getPhone());

					preparedStatement.executeUpdate();

					status = true;

				} catch (SQLException e) {
					printSQLException(e);
					status = false;
				}

				return status;
			}
	//READ Passenger
			//READ BUS
			public List<passenger> selectAllPassenger() {

				// using try-with-resources to avoid closing resources (boiler plate code)
				List<passenger> Passenger = new ArrayList<>();
				// Step 1: Establishing a Connection
				try (Connection connection = getConnection();

						// Step 2:Create a statement using connection object
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PASSENGER);) {
//		            System.out.println(preparedStatement);
					// Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();

					// Step 4: Process the ResultSet object.
					while (rs.next()) {
						int passID = rs.getInt("passID");
						String name = rs.getString("name");
						String phone = rs.getString("phone");
						
//						if(doctor_id == session_doc_id) {
						
					Passenger.add(new passenger(passID, name, phone));
						
//						}
						
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				return Passenger;
			}
	
}

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BusDest;
import helper.EncryptDecryptPass;

public class bookingDetailService {
	private EncryptDecryptPass encryptDecryptPass;

	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	
	private String SELECT_ALL_BUS_DESTINATION = "SELECT b.busid, b.name, b.noplate, d.destinationid, d.destinationname, t.time FROM bus b JOIN trip t ON b.busid = t.busid JOIN destination d ON t.destinationid = d.destinationid";
	
	public bookingDetailService() {
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
	
	//READ BUS JOIN DESTINATION
			public List<BusDest> selectAllBusTripCustomer() {

				// using try-with-resources to avoid closing resources (boiler plate code)
				List<BusDest> busDest = new ArrayList<>();
				// Step 1: Establishing a Connection
				try (Connection connection = getConnection();

						// Step 2:Create a statement using connection object
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUS_DESTINATION);) {
//		            System.out.println(preparedStatement);
					// Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();

					// Step 4: Process the ResultSet object.
					while (rs.next()) {
						int busID = rs.getInt("busID");
						String name = rs.getString("name");
						String noPlate = rs.getString("noPlate");
						int destinationID = rs.getInt("destinationID");
						String destinationName = rs.getString("destinationName");
						String time = rs.getString("time");
						
//						if(doctor_id == session_doc_id) {
						
					busDest.add(new BusDest(busID, name, noPlate, destinationID, destinationName, time));
						
//						}
						
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				return busDest;
			}
}

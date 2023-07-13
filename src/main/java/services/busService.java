package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.BusDest;
import bean.bus;
import bean.destination;
import bean.staff;
import bean.trip;
import helper.EncryptDecryptPass;

public class busService {
private EncryptDecryptPass encryptDecryptPass;
	
	
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	
	private String INSERT_BUS_SQL = "INSERT INTO bus(name, noPlate) VALUES(?,?)";
	private String SELECT_ALL_BUS_DESTINATION = "SELECT b.busid, b.name, b.noplate, d.destinationid, d.destinationname, t.time FROM bus b JOIN trip t ON b.busid = t.busid JOIN destination d ON t.destinationid = d.destinationid";
	private String SELECT_ALL_BUS = "SELECT * FROM bus";
	private static final String SELECT_ALL_BUS_NAME = "SELECT * FROM bus ORDER BY busID";
	private String SELECT_BUS_ID = "SELECT * FROM bus WHERE busID=?";
	private String UPDATE_BUS_ID = "UPDATE bus set name=?, noPlate=? WHERE busID=?";
	private String DELETE_BUS_SQL = "DELETE from bus WHERE busID = ?";
	
	public busService() {
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
	
	//CREATE Bus
		public boolean insertBus(bus Bus) throws SQLException {
			boolean status = false;

			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BUS_SQL)) {
				preparedStatement.setString(1, Bus.getName());
				preparedStatement.setString(2, Bus.getNoPlate());

				preparedStatement.executeUpdate();

				status = true;

			} catch (SQLException e) {
				printSQLException(e);
				status = false;
			}

			return status;
		}
	//READ BUS JOIN DESTINATION
		public List<BusDest> selectAllBusTrip() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<BusDest> busDest = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUS_DESTINATION);) {
//	            System.out.println(preparedStatement);
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
					
//					if(doctor_id == session_doc_id) {
					
				busDest.add(new BusDest(busID, name, noPlate, destinationID, destinationName, time));
					
//					}
					
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return busDest;
		}
	//READ BUS
		public List<bus> selectAllBus() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<bus> Bus = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUS);) {
//	            System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int busID = rs.getInt("busID");
					String name = rs.getString("name");
					String noPlate = rs.getString("noPlate");
					
//					if(doctor_id == session_doc_id) {
					
				Bus.add(new bus(busID, name, noPlate));
					
//					}
					
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return Bus;
		}
		
		//READ BRIDGE
		public List<bus> selectAllBusName() {

			List<bus> Bus = new ArrayList<>();
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUS_NAME);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int busID = rs.getInt("busID");
					String name = rs.getString("name");
					String noPlate = rs.getString("noPlate");
					

					Bus.add(new bus(busID, name, noPlate));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}

			return Bus;
		}
		
		//UPDATE BUS
		public bus getOneBus(int id) {
			bus Bus = null;
			
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BUS_ID)) {
				preparedStatement.setInt(1, id);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					int busID = rs.getInt("busID");
					String name = rs.getString("name");
					String noPlate = rs.getString("noPlate");
					
//					if(doctor_id == session_doc_id) {
					System.out.println("Bus id : " + busID);
					
					Bus = new bus(busID, name, noPlate);
				}
				
			} catch (SQLException e) {
				printSQLException(e);
			}
			
			return Bus;
		}
		
		public boolean updateBus(bus Bus) throws SQLException{
			boolean status = false;
			
			try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BUS_ID)) {
				preparedStatement.setString(1, Bus.getName());
				preparedStatement.setString(2, Bus.getNoPlate());
				//private String UPDATE_STAFF_ID = "UPDATE staff set username=?, password=?, name=?, role=? WHERE staffID=?";

				System.out.println(Bus.getName());
				preparedStatement.executeUpdate();
				status = true;
			} catch (SQLException e) {
				printSQLException(e);
				status = false;
			}
			
			return status;
		}
		//DELETE STAFF
		public boolean deleteBus(int busID) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection();) {
	        	PreparedStatement statement = connection.prepareStatement(DELETE_BUS_SQL);
	            statement.setInt(1, busID);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	
}

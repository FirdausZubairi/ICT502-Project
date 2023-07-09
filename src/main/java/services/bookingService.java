package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.staff;
import helper.EncryptDecryptPass;

public class bookingService {
	private EncryptDecryptPass encryptDecryptPass;
	
	public bookingService() {
		encryptDecryptPass = new EncryptDecryptPass();
	}
	

	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	private String SELECT_STAFF_USERNAME = "SELECT * FROM staff WHERE username=?;";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	public boolean loginStaff(staff staff) throws SQLException {
		boolean status = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_USERNAME)) {
			preparedStatement.setString(1, staff.getUsername());

			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("password : " + staff.getPassword());
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				System.out.println("password db: " + password);
				System.out.println(encryptDecryptPass.CheckPassword(staff.getPassword(), password));
				if (email.equals(staff.getUsername())
						&& encryptDecryptPass.CheckPassword(staff.getPassword(), password)) {
					status = true;
				} else {
					status = false;
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return status;
	}
}



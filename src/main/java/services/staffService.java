package services;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.staff;
import connection.ConnectionManager;
import helper.EncryptDecryptPass;

public class staffService {
	private EncryptDecryptPass encryptDecryptPass;
	
	
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "dbbt";
	private String jdbcPassword = "system";
	
	private String INSERT_STAFF_SQL = "INSERT INTO staff(username, password, name, role) VALUES(?,?,?,?)";
	private String SELECT_ALL_STAFF = "SELECT * FROM staff";
	private String SELECT_STAFF_ID = "SELECT * FROM staff WHERE staffID=?";
	private String UPDATE_STAFF_ID = "UPDATE staff set username=?, password=?, name=?, role=? WHERE staffID=?";
	private String DELETE_STAFF_SQL = "DELETE from staff WHERE staffID = ?";

	public staffService() {
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
	
	static Connection con = null;
    static PreparedStatement ps = null;
    static Statement s = null;
    static ResultSet rs = null;

	
	//Login Staff (Clerk)
	
	public staff loginClerk(staff staff) throws SQLException {
		staff stf = null;
		try {
			con = ConnectionManager.getConnection();
            String username = staff.getUsername();
            String password = staff.getPassword();
            String role = staff.getRole();          

            // Perform login validation for customers
            String sql1 = "SELECT * FROM staff WHERE username = ? AND password = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Customer login successful
                System.out.println("Clerk login success");
                stf = new staff(username, password, role);
                // Perform any necessary actions or return a success indicator
                return stf;
            }
		}catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during the login validation process
        } 

		return stf;
	}
	
	//Login Staff (Driver)	
	public staff loginDriver(staff staff) throws SQLException {
		staff stf = null;
		try {
			con = ConnectionManager.getConnection();
            String username = staff.getUsername();
            String password = staff.getPassword();
            String role = staff.getRole();            

            // Perform login validation for customers
            String sql1 = "SELECT * FROM staff WHERE username = ? AND password = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Customer login successful
                System.out.println("Driver login success");
                stf = new staff(username, password, role);
                // Perform any necessary actions or return a success indicator
                return stf;
            }
		}catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during the login validation process
        } 

		return stf;
	}
	
	//CREATE STAFF
	public boolean insertStaff(staff Staff) throws SQLException {
		boolean status = false;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL)) {
			preparedStatement.setString(1, Staff.getUsername());
			preparedStatement.setString(2, Staff.getPassword());
			preparedStatement.setString(3, Staff.getName());
			preparedStatement.setString(4, Staff.getRole());

			preparedStatement.executeUpdate();

			status = true;

		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}

		return status;
	}
	
//	public boolean insertClerk(Clerk clerk) throws SQLException {
//		boolean status = false;
//		try (Connection connection = getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLERK_SQL)) {
//			int id = insertStaff(new Users(clerk.getUsername(), fulltime.getPhone(), fulltime.getEmail(),
//					fulltime.getAge(), fulltime.getGender(), fulltime.getRoleId()));
//			preparedStatement.setInt(1, id);
//			preparedStatement.setInt(2, fulltime.getAnnualLeave());
//			preparedStatement.setInt(3, fulltime.getSickLeave());
//			preparedStatement.setString(4, fulltime.getInsurance());
//			preparedStatement.setInt(5, fulltime.getUnpaidLeave());
//
//			preparedStatement.executeUpdate();
//
//			status = true;
//
//		} catch (SQLException e) {
//			printSQLException(e);
//			status = false;
//		}
//
//		return status;
//	}
	
	//READ STAFF
	public List<staff> selectAllStaff() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<staff> Staff = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFF);) {
//            System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int staffID = rs.getInt("staffID");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String role = rs.getString("role");
				int adminID = rs.getInt("adminID");
				
//				if(doctor_id == session_doc_id) {
				
				Staff.add(new staff(staffID, username, password, name, role, adminID));
//				}
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Staff;
	}
	
	//UPDATE STAFF
	public staff getOneStaff(int id) {
		staff Staff = null;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int staffID = rs.getInt("staffID");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String role = rs.getString("role");
				int adminID = rs.getInt("adminID");
				
//				if(doctor_id == session_doc_id) {
				System.out.println("Staff id : " + staffID);
				
				Staff = new staff(staffID, username, password, name, role, adminID);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return Staff;
	}
	
	public boolean updateStaff(staff Staff) throws SQLException{
		boolean status = false;
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STAFF_ID)) {
			preparedStatement.setString(1, Staff.getUsername());
			preparedStatement.setString(2, Staff.getPassword());
			preparedStatement.setString(3, Staff.getName());
			preparedStatement.setString(4, Staff.getRole());
			preparedStatement.setInt(5, Staff.getStaffID());
			//private String UPDATE_STAFF_ID = "UPDATE staff set username=?, password=?, name=?, role=? WHERE staffID=?";

			System.out.println(Staff.getUsername());
			preparedStatement.executeUpdate();
			status = true;
		} catch (SQLException e) {
			printSQLException(e);
			status = false;
		}
		
		return status;
	}
	
	//DELETE STAFF
	public boolean deleteStaff(int staffID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();) {
        	PreparedStatement statement = connection.prepareStatement(DELETE_STAFF_SQL);
            statement.setInt(1, staffID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}

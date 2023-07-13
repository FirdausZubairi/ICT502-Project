package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver"; 			//Driver class
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe"; //Connection URL
	private static final String DB_USER = "	dbbt"; 								//DB Username
	private static final String DB_PASSWORD = "system"; 								//DB Password
	
	public static Connection getConnection() {
		try {
			//1. load the driver
			Class.forName(DB_DRIVER);
			
			try {
				//2. create connection
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
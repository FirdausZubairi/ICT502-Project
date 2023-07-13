package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionManager;

public class ChartDOA {
	public int getCountBus() {
        int CountBus = 0;
        
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS count FROM bus")) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CountBus = resultSet.getInt("count");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CountBus;
        }
	
	public int getCountDest() {
        int CountDest = 0;
        
        try (Connection connection = ConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS count FROM destination")) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CountDest = resultSet.getInt("count");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CountDest;
        }
}
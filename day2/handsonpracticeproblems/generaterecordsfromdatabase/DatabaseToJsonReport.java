package org.day2.handsonpracticeproblems.generaterecordsfromdatabase;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Prakash@123";

        // SQL query to fetch data
        String query = "SELECT * FROM employees;";

        // Create connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Convert the ResultSet to JSON
            JSONArray jsonArray = new JSONArray();

            // Get the result set metadata (column names)
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();

                // Loop through each column and add to the JSON object
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);
                    jsonObject.put(columnName, columnValue);
                }

                // Add the current row JSON object to the array
                jsonArray.put(jsonObject);
            }

            // Write the JSON array to a file
            try (FileWriter file = new FileWriter("src/main/java/com/jsondata/handsonpracticeproblems/generaterecordsfromdatabase/report.json")) {
                file.write(jsonArray.toString(4));  // Pretty print with 4 spaces indentation
            }

            System.out.println("JSON report generated successfully!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}


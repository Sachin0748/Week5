package org.day1;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class EmployeeCSVReport {
    public static void main(String[] args) {
        // Database connection details (modify based on your database)
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // Output CSV file path
        String outputFile = "C:\\Users\\kumar\\OneDrive\\Desktop\\employee_report.csv";

        // SQL query to fetch employee data
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            // Write header row
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Write records to CSV
            while (rs.next()) {
                String[] row = {
                        rs.getString("employee_id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("salary")
                };
                writer.writeNext(row);
            }

            System.out.println("CSV report generated successfully at: " + outputFile);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }
}


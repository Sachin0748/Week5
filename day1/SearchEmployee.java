package org.day1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\employees.csv";

        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee name to search: ");
        String searchName = scanner.nextLine().trim(); // Read and trim input
        scanner.close(); // Close the scanner after input

        boolean found = false; // Flag to check if employee is found

        // Try-with-resources to automatically close CSVReader
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;

            reader.readNext(); // Skip the header row

            // Read each row from CSV
            while ((row = reader.readNext()) != null) {
                String name = row[0].trim(); // Extract employee name

                // Check if name matches (case-insensitive)
                if (name.equalsIgnoreCase(searchName)) {
                    String department = row[1]; // Extract department
                    String salary = row[2]; // Extract salary
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + department);
                    System.out.println("Salary: $" + salary);
                    found = true;
                    break; // Stop searching once found
                }
            }

            // If employee not found, print message
            if (!found) {
                System.out.println("Employee not found in records.");
            }

        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}


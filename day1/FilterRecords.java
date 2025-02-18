package org.day1; // Defines the package name

import com.opencsv.CSVReader; // Import OpenCSV library for reading CSV files
import java.io.FileReader; // Import FileReader for reading files
import java.util.Arrays; // Import Arrays class for array operations

public class FilterRecords {
    public static void main(String[] args){
        // Define the file path of the CSV file
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\student.csv";

        // Try-with-resources to automatically close the CSVReader after execution
        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] columns; // Array to store CSV row data

            reader.readNext(); // Skip the header row

            // Read each row from the CSV file
            while((columns = reader.readNext()) != null){
                // Convert the last column (marks) to an integer
                int marks = Integer.parseInt(columns[columns.length - 1]);

                // Check if marks are greater than 80
                if(marks > 80){
                    // Print the entire row if condition is met
                    System.out.println(Arrays.toString(columns));
                }
            }

        } catch (Exception e) {
            // Handle exceptions and print the error message
            System.out.println(e.getMessage());
        }
    }
}

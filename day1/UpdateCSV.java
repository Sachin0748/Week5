package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        // Define file paths
        String inputFilePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\employees.csv";
        String outputFilePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\updated_employees.csv";

        List<String[]> allRows = new ArrayList<>();

        // Try-with-resources to read the CSV file
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            String[] row;

            while ((row = reader.readNext()) != null) {
                // Add header row without modification
                if (allRows.isEmpty()) {
                    allRows.add(row);
                    continue;
                }

                // Check if employee is in IT department
                if (row[1].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(row[2]); // Convert salary to double
                    salary *= 1.10; // Increase by 10%
                    row[2] = String.format("%.2f", salary); // Format salary with 2 decimal places
                }

                allRows.add(row); // Store the modified row
            }

        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Try-with-resources to write the updated data to a new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            writer.writeAll(allRows); // Write all updated rows back to the new file
            System.out.println("Updated CSV file saved successfully at: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}


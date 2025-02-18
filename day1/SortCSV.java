package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        // File path of the CSV
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\employees.csv";

        List<String[]> records = new ArrayList<>();

        // Try-with-resources to read CSV file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            String[] header = reader.readNext(); // Read and store header separately

            while ((row = reader.readNext()) != null) {
                records.add(row); // Add each row to list
            }

            // Sort records by salary in descending order
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest Paid Employees:");
            System.out.println(Arrays.toString(header)); // Print header
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(Arrays.toString(records.get(i))); // Print record
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing salary values. Ensure salary column contains valid numbers.");
        }
    }
}


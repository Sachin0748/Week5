package org.day1;  // Declares the package name

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        // Specify the file path of the CSV file
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\student.csv";

        int count = 0; // Variable to store the number of data rows

        // Using try-with-resources to automatically close the BufferedReader
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and discard the first line (header) if the file has column names
            bf.readLine();

            // Read each line and count the number of data rows
            while ((line = bf.readLine()) != null) {
                count++;
            }

            // Display the total number of rows in the file (excluding the header)
            System.out.println("There are " + count + " rows in the file.");
        } catch (IOException e) {
            // Print an error message if there is an issue with file reading
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

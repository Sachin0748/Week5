package org.day1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args) {
        // Define the file path where the CSV will be saved
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\output.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header row to the CSV file
            writer.write("ID, Name, Department, Salary\n");

            // Write the employee data records to the CSV file
            writer.write("100, Sachin,Technical, 62000\n");
            writer.write("101, Duggu, Technical, 58000\n");
            writer.write("102, Johnson, Sales, 58000\n");
            writer.write("103, Alice, Sales, 65000\n");
            writer.write("104, Bob, Sales, 70000\n");
            writer.write("105, Boby, Sales, 50000\n");

            // Print a success message after writing to the file
            System.out.println("Successfully data written.");

        } catch (Exception e) {
            // Catch and print any errors that occur during the file writing process
            System.out.println(e.getMessage());
        }
    }
}

package org.day1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\employees.csv";

        // Regular expression for a valid email format
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Regular expression for a valid phone number (10 digits)
        String phoneRegex = "^[0-9]{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        // Try-with-resources to read CSV
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            String[] header = reader.readNext(); // Read header row
            if (header == null) {
                System.out.println("Empty CSV file.");
                return;
            }

            boolean hasInvalidRows = false;

            // Read and validate each row
            while ((row = reader.readNext()) != null) {
                String email = row[1].trim(); // Extract email
                String phone = row[2].trim(); // Extract phone number

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhone = phonePattern.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    hasInvalidRows = true;
                    System.out.println("Invalid Row: " + String.join(", ", row));
                    if (!isValidEmail) {
                        System.out.println("  → Error: Invalid email format");
                    }
                    if (!isValidPhone) {
                        System.out.println("  → Error: Phone number must be exactly 10 digits");
                    }
                }
            }

            if (!hasInvalidRows) {
                System.out.println("All records are valid.");
            }

        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}


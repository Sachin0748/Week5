package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\student.csv";

        // Set to store unique IDs
        Set<String> uniqueIds = new HashSet<>();
        // List to store duplicate records
        List<String[]> duplicateRecords = new ArrayList<>();

        // Read CSV and check for duplicates
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            reader.readNext(); // Skip header row

            while ((row = reader.readNext()) != null) {
                String id = row[0].trim(); // Extract ID column

                // Check if ID is already encountered
                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(row); // Store duplicate record
                }
            }

            // Print duplicate records if found
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String[] duplicate : duplicateRecords) {
                    System.out.println(Arrays.toString(duplicate));
                }
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}


package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        // Define file paths
        String file1 = "C:\\Users\\kumar\\OneDrive\\Desktop\\students1.csv";
        String file2 = "C:\\Users\\kumar\\OneDrive\\Desktop\\students2.csv";
        String outputFile = "C:\\Users\\kumar\\OneDrive\\Desktop\\merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        // Read the first CSV (students1.csv) and store data in a map
        try (CSVReader reader = new CSVReader(new FileReader(file1))) {
            String[] row;
            reader.readNext(); // Skip header row

            while ((row = reader.readNext()) != null) {
                studentMap.put(row[0], row); // Store data with ID as key
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file1: " + e.getMessage());
            return;
        }

        // Read the second CSV (students2.csv) and merge data
        try (CSVReader reader = new CSVReader(new FileReader(file2))) {
            String[] row;
            reader.readNext(); // Skip header row

            while ((row = reader.readNext()) != null) {
                String id = row[0];
                if (studentMap.containsKey(id)) {
                    String[] studentData = studentMap.get(id);
                    String[] mergedRow = new String[studentData.length + row.length - 1];

                    // Merge both records (excluding duplicate ID from second file)
                    System.arraycopy(studentData, 0, mergedRow, 0, studentData.length);
                    System.arraycopy(row, 1, mergedRow, studentData.length, row.length - 1);

                    studentMap.put(id, mergedRow);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file2: " + e.getMessage());
            return;
        }

        // Write merged data to a new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            // Write header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            // Write merged data
            for (String[] row : studentMap.values()) {
                writer.writeNext(row);
            }

            System.out.println("Merged CSV file saved successfully at: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}


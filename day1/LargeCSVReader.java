package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        // Define file path
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\large_data.csv";

        // Number of lines to process at a time
        final int CHUNK_SIZE = 100;
        int recordCount = 0;
        int batchCount = 0;

        // Try-with-resources to ensure efficient file reading
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            reader.readNext(); // Skip header row

            // Process file in chunks of CHUNK_SIZE
            while ((row = reader.readNext()) != null) {
                recordCount++;

                // Process the current row (replace this with actual processing logic)
                // Example: System.out.println(Arrays.toString(row));

                // Print progress every CHUNK_SIZE rows
                if (recordCount % CHUNK_SIZE == 0) {
                    batchCount++;
                    System.out.println("Processed " + recordCount + " records (Batch " + batchCount + ")");
                }
            }

            // Print final count
            System.out.println("Total records processed: " + recordCount);

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}


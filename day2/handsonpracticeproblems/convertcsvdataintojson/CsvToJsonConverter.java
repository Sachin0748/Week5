package org.day2.handsonpracticeproblems.convertcsvdataintojson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            // Read CSV file
            CSVReader reader = new CSVReader(new FileReader("src/main/java/com/jsondata/handsonpracticeproblems/convertcsvdataintojson/input.csv"));
            List<String[]> csvData = reader.readAll();

            // Get the header row (column names)
            String[] headers = csvData.get(0);

            // Create a JSONArray to hold the JSON objects
            JSONArray jsonArray = new JSONArray();

            // Loop through the rows of the CSV data (excluding the header)
            for (int i = 1; i < csvData.size(); i++) {
                String[] row = csvData.get(i);
                JSONObject jsonObject = new JSONObject();

                // Map each column value to the corresponding header
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }

                // Add the JSONObject to the JSONArray
                jsonArray.put(jsonObject);
            }

            // Write the JSON array to a file
            try (FileWriter file = new FileWriter("src/main/java/com/jsondata/handsonpracticeproblems/convertcsvdataintojson/output.json")) {
                file.write(jsonArray.toString(4));  // Indented with 4 spaces
            }

            System.out.println("CSV successfully converted to JSON and saved to output.json");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}


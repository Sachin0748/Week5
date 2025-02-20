package com.jsondata.extra_problem;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLCensor {

    // Method to mask team names
    public static String maskTeamName(String teamName) {
        // Replace everything after the first word with ***
        String[] words = teamName.split(" ");
        return words[0] + " ***";
    }

    // Method to redact player of the match
    public static String redactPlayerOfMatch(String playerName) {
        return "REDACTED";
    }

    // Method to process JSON data
    public static void processJsonFile(String inputFile, String outputFile) {
        try {
            // Read JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get(inputFile)));
            JSONArray matches = new JSONArray(jsonContent);

            // Process each match
            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);

                // Apply censorship
                String team1 = match.getString("team1");
                String team2 = match.getString("team2");
                match.put("team1", maskTeamName(team1));
                match.put("team2", maskTeamName(team2));

                // Redact player of the match
                String playerOfMatch = match.getString("player_of_match");
                match.put("player_of_match", redactPlayerOfMatch(playerOfMatch));
            }

            // Write censored JSON to output file
            Files.write(Paths.get(outputFile), matches.toString(4).getBytes());
            System.out.println("JSON file processed and saved to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to process CSV data
    public static void processCsvFile(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            // Read all data from CSV
            List<String[]> allRows = reader.readAll();

            // Process each row (skip header row)
            for (int i = 0; i < allRows.size(); i++) {
                String[] row = allRows.get(i);

                // Skip header row
                if (i == 0) {
                    writer.writeNext(row);
                    continue;
                }

                // Apply censorship to team names and player of the match
                row[1] = maskTeamName(row[1]);  // team1
                row[2] = maskTeamName(row[2]);  // team2
                row[6] = redactPlayerOfMatch(row[6]);  // player_of_match

                // Write the modified row to the new CSV
                writer.writeNext(row);
            }

            System.out.println("CSV file processed and saved to: " + outputFile);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // File paths for input and output files
        String inputJsonFile = "src/main/java/com/jsondata/extra_problem/input_ipl_data.json";
        String outputJsonFile = "src/main/java/com/jsondata/extra_problem/output_ipl_data.json";
        String inputCsvFile = "src/main/java/com/jsondata/extra_problem/input_ipl_data.csv";
        String outputCsvFile = "src/main/java/com/jsondata/extra_problem/output_ipl_data.csv";

        // Process JSON file
        processJsonFile(inputJsonFile, outputJsonFile);

        // Process CSV file
        processCsvFile(inputCsvFile, outputCsvFile);
    }
}

package org.day2.handsonpracticeproblems.mergetwojsonfiles;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class MergeTwoJsonFile {
    public static void main(String[] args) {
        try {
            // Read the content of the first JSON file
            String file1 = new String(Files.readAllBytes(Paths.get("src/main/java/com/jsondata/handsonpracticeproblems/mergetwojsonfiles/file1.json")));
            // Read the content of the second JSON file
            String file2 = new String(Files.readAllBytes(Paths.get("src/main/java/com/jsondata/handsonpracticeproblems/mergetwojsonfiles/file2.json")));

            // Create JSONObject from both file contents
            JSONObject json1 = new JSONObject(file1);
            JSONObject json2 = new JSONObject(file2);

            // Merge the JSON objects
            JSONObject merged = new JSONObject(json1.toMap()); // Convert json1 to Map and then create new JSONObject
            for (String key : json2.keySet()) {
                merged.put(key, json2.get(key));
            }

            // Save the merged JSON to a new file
            Files.write(Paths.get("merged_file.json"), merged.toString(4).getBytes()); // Pretty print with 4 spaces

            System.out.println("JSON files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


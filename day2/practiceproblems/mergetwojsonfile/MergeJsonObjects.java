package org.day2.practiceproblems.mergetwojsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            // Sample JSON strings
            String json1 = "{\"name\":\"Om Prakash\",\"age\":20}";
            String json2 = "{\"email\":\"omprakash@example.com\"}";

            ObjectMapper objectMapper = new ObjectMapper();

            // Convert JSON strings to JsonNode
            JsonNode jsonNode1 = objectMapper.readTree(json1);
            JsonNode jsonNode2 = objectMapper.readTree(json2);

            // Merge JSON objects
            JsonNode mergedJson = jsonNode1.deepCopy();
            ((ObjectNode) mergedJson).setAll((ObjectNode) jsonNode2);

            // Output the merged JSON
            System.out.println(mergedJson.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

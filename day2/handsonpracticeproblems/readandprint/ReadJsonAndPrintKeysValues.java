package org.day2.handsonpracticeproblems.readandprint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class ReadJsonAndPrintKeysValues {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file into a JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/java/com/jsondata/handsonpracticeproblems/readandprint/student.json"));

            // Iterate through the keys and values in the JSON object
            Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
            while (fields.hasNext()) {
                Entry<String, JsonNode> field = fields.next();
                System.out.println("Key: " + field.getKey() + ", Value: " + field.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


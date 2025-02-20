package org.day2.practiceproblems.validatejsonusingjackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        // Example JSON input as a String
        String jsonString = "{\"name\":\"Prakash\",\"age\":23}";


        try {
            new ObjectMapper().readTree(jsonString);
            System.out.println("JSON is valid!");
        } catch (IOException e) {
            System.out.println("Invalid JSON structure!");
        }
    }
}

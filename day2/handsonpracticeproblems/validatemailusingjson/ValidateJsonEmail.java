package org.day2.handsonpracticeproblems.validatemailusingjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJsonEmail {
    public static void main(String[] args) throws IOException, ProcessingException {
        // Create ObjectMapper for reading JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Load JSON Schema
        JsonNode schemaNode = objectMapper.readTree(new File("src/main/java/com/jsondata/handsonpracticeproblems/validatemailusingjson/schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        // Load JSON data (email to validate)
        JsonNode jsonData = objectMapper.readTree(new File("src/main/java/com/jsondata/handsonpracticeproblems/validatemailusingjson/user.json"));

        // Validate JSON data against the schema
        if (schema.validate(jsonData).isSuccess()) {
            System.out.println("JSON is valid!");
        } else {
            System.out.println("Invalid JSON structure!");
        }
    }
}

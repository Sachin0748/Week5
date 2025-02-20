package org.day2.handsonpracticeproblems.convertjsonxmlformat;

import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Read the JSON content from a file
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/java/com/jsondata/handsonpracticeproblems/convertjsonxmlformat/file.json")));

            // Convert JSON to a JSONObject
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Convert JSONObject to XML
            String xmlContent = XML.toString(jsonObject);

            // Save the XML content to a new file
            Files.write(Paths.get("src/main/java/com/jsondata/handsonpracticeproblems/convertjsonxmlformat/output.xml"), xmlContent.getBytes());

            System.out.println("JSON successfully converted to XML and saved to output.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

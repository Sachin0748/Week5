package org.day2.practiceproblems.readandextractfields;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndExtract {
    public static void main(String[] args) {

        String filePath = "src/main/java/com/jsondata/practiceproblems/readandextractfields/students.json";

        try {

            FileReader fr = new FileReader(filePath);
            StringBuilder json = new StringBuilder();
            int  line;
            while ((line = fr.read()) != -1) {
                json.append((char) line);
            }

            JSONArray jsonArray = new JSONArray(json.toString());
            System.out.println(jsonArray);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = jsonArray.getJSONObject(i);
                String name = student.getString("name");  // Corrected field name
                String email = student.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

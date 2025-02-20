package org.day2.handsonpracticeproblems.convertjavatojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsondata.practiceproblems.convertjavatojsonarray.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        // Create a list of Student objects
        List<com.jsondata.practiceproblems.convertjavatojsonarray.Student> students = new ArrayList<>();
        students.add(new Student("Prakash", 22, "prakash@example.com"));
        students.add(new Student("Anand", 21, "anand@example.com"));

        // Convert the list of students into a JSON array
        convertListToJsonArray(students);
    }

    // Convert List to JSON Array
    public static void convertListToJsonArray(List<Student> students) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the list of students into a JSON array string
            String jsonArray = objectMapper.writeValueAsString(students);

            // Print the JSON array
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package org.day2.handsonpracticeproblems.filtejsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAge {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Load the JSON file into a List of Student objects
            List<Student> students = objectMapper.readValue(new File("src/main/java/com/jsondata/practiceproblems/parsejsonandfilter/student.json"), new TypeReference<List<Student>>() {});

            // Filter the students list where age > 25
            List<Student> filteredStudents = students.stream()
                    .filter(student -> student.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered students
            filteredStudents.forEach(student -> System.out.println(student));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


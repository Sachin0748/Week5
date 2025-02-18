package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private String department;
    private double cgpa;

    // Constructor
    public Student(int id, String name, int age, String department, double cgpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Student { " +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Department='" + department + '\'' +
                ", CGPA=" + cgpa +
                " }";
    }
}

public class CSVToStudent {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\student.csv";

        List<Student> students = new ArrayList<>();

        // Try-with-resources to read CSV
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            reader.readNext(); // Skip header row

            // Read and convert each row into a Student object
            while ((row = reader.readNext()) != null) {
                int id = Integer.parseInt(row[0].trim());
                String name = row[1].trim();
                int age = Integer.parseInt(row[2].trim());
                String department = row[3].trim();
                double cgpa = Double.parseDouble(row[4].trim());

                // Create a Student object and add it to the list
                Student student = new Student(id, name, age, department, cgpa);
                students.add(student);
            }

            // Print all student objects
            System.out.println("Student Records:");
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number values. Ensure correct data format in CSV.");
        }
    }
}


package org.day2.practiceproblems.createjsonobject;


import org.json.JSONArray;
import org.json.JSONObject;

public class StudentObject {
    public static void main(String[] args) {
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("Name","Om Prakash");
        jsonStudent.put("Age",23);


        JSONArray studentMarks = new JSONArray();
        studentMarks.put("SE");
        studentMarks.put("OS");
        studentMarks.put("DSA");
        studentMarks.put("Oops");
        studentMarks.put("CN");

        jsonStudent.put("Subject", studentMarks);

        System.out.println(jsonStudent);

    }
}

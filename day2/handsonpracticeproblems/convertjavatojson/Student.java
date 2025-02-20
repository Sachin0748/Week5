package org.day2.handsonpracticeproblems.convertjavatojson;


public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters (Jackson uses these methods for serialization)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}


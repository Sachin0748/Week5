package org.day2.handsonpracticeproblems.filtejsondata;

public class Student {
    private String name;
    private int age;

    // Default constructor for Jackson
    public Student() {
    }

    // Constructor with parameters
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}



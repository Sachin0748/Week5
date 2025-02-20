package org.day2.practiceproblems.convertjavatojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
    public String color;
    public String type;
    public String brand;

    Car(String clr, String type, String brand){
        this.color = clr;
        this.type = type;
        this.brand = brand;
    }
}
public class ConvertJavaToJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("red", "CNG", "Volvo");
        try {
            String jsonCar = objectMapper.writeValueAsString(car);
            System.out.println(jsonCar);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}

package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args){
        String filePath = "C:\\Users\\kumar\\OneDrive\\Desktop\\Capgemini\\Week5\\src\\main\\java\\org\\day1\\student.csv";

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] line;
            while((line = reader.readNext()) != null){
                System.out.println(line[0] + " " + line[1] + " " + line[2] + " " + line[3]);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

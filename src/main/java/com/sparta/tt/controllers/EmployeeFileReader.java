package com.sparta.tt.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileReader {

    public EmployeeFileReader(String fileExtension) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        switch (fileExtension){
            case "json" -> {
                try {
                    List<EmployeeDTO> employees = mapper.readValue(new File("src/main/resources/employees02.json"), new TypeReference<List<EmployeeDTO>>() {});
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            case "xml" -> {
                try {
                    List<EmployeeDTO> employees = xmlMapper.readValue(new File("src/main/resources/employees03.xml"), new TypeReference<List<EmployeeDTO>>() {});
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
       /*     try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/employees.csv"))) {
                reader.readLine();
                String line = reader.readLine();
                while(line != null) {
                    System.out.println(Arrays.toString(line.split(",")));
                    line = reader.readLine();
                }*/
            case "csv" -> {
                List<EmployeeDTO> employees = new ArrayList<>();

                String employeeLine;
                try {
                    BufferedReader f = new BufferedReader(new FileReader("src/main/resources/employees01.csv"));
                    f.readLine();
                    String line = f.readLine();
                    while(line != null){
                        String[] employeeSplit = line.split(",");
                        if (employeeSplit.length==6) {
                            EmployeeDTO newEmployee = new EmployeeDTO(Integer.parseInt(employeeSplit[0]), employeeSplit[1].toString(), employeeSplit[2].toString(), employeeSplit[3].toString(), employeeSplit[4].toString(), employeeSplit[5].toString());
                            //System.out.println(newEmployee.toString());
                            employees.add(newEmployee);
                        }
                        line = f.readLine();
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

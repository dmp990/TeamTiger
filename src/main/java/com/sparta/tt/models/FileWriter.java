package com.sparta.tt.models;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.tt.controllers.EmployeeDTO;
import com.sparta.tt.phase_two.Spartan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWriter {
    private final String path = "src/main/resources/";
    public FileWriter(String filename, ArrayList<EmployeeDTO> employees) throws IOException {
        String[] extension = filename.split("\\.");
        String ext = extension[extension.length - 1];

        switch (ext) {
            case "json" ->
                    jsonWriter(employees, filename);
            case "xml" ->
                    xmlWriter(employees, filename);
            default -> System.out.println("Invalid format");
        }

    }

    public void jsonWriter(ArrayList<EmployeeDTO> employees, String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(path + filename), employees);
    }

    public void xmlWriter(ArrayList<EmployeeDTO> employees, String filename) throws IOException {
        ObjectMapper mapper = new XmlMapper();
        ObjectWriter writer = mapper.writer();
        writer.writeValue(new File(path + filename), employees);

    }
}
package com.sparta.tt.phase_two;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class JsonWriter {
    private final String path = "src/main/resources/";
    public JsonWriter(String filename) throws IOException {
        String[] extension = filename.split("\\.");
        String ext = extension[extension.length - 1];

        switch (ext) {
            case "json" ->
                    jsonWriter(new Spartan("Manish", "java", "1999-10-12"));
            case "xml" ->
                    xmlWriter(new Spartan("Manish", "java",  new Date(1990, 01, 01).toString()));
            default -> System.out.println("Invalid format");
        }

    }

    public void jsonWriter(Spartan jsonDataObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(path + "output.json"), jsonDataObject);
    }

    public void xmlWriter(Spartan xmlDataObject) throws IOException {
        ObjectMapper mapper = new XmlMapper();
        ObjectWriter writer = mapper.writer();
        writer.writeValue(new File(path + "output.xml"), xmlDataObject);

    }
}
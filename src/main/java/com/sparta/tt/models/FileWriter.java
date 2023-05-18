package com.sparta.tt.models;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.tt.FileHandlerConfig;
import com.sparta.tt.controllers.EmployeeDTO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriter {

    public static final Logger fileWriterLogger = Logger.getLogger(EmployeeDTO.class.getName());
    static {
        fileWriterLogger.setUseParentHandlers(false);
        fileWriterLogger.setLevel(Level.ALL);
        fileWriterLogger.addHandler(FileHandlerConfig.getFileHandler());
    }

    private final String path = "src/main/resources/";
    public FileWriter(String filename, ArrayList<EmployeeDTO> employees) throws IOException {
        fileWriterLogger.log(Level.INFO,"FileWriter constructor() method called");
        String[] extension = filename.split("\\.");
        String ext = extension[extension.length - 1];

        switch (ext) {
            case "json" -> {
                fileWriterLogger.log(Level.INFO,"jsonWriter() call (started)");
                jsonWriter(employees, filename);
                fileWriterLogger.log(Level.INFO,"jsonWriter() call (finished)");
            }
            case "xml" -> {
                fileWriterLogger.log(Level.INFO,"xml() call (started)");
                xmlWriter(employees, filename);
                fileWriterLogger.log(Level.INFO,"xml() call (finished)");
            }
            default -> {
                fileWriterLogger.log(Level.INFO,"default call (started)");
                System.out.println("Invalid format");
                fileWriterLogger.log(Level.INFO,"default call (finished)");
            }
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
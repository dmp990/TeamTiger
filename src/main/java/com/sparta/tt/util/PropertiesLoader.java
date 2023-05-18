package com.sparta.tt.util;

import com.sparta.tt.FileHandlerConfig;
import com.sparta.tt.controllers.EmployeeDTO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesLoader {

    public static final Logger propertiesLoaderLogger = Logger.getLogger(PropertiesLoader.class.getName());
    static {
        propertiesLoaderLogger.setUseParentHandlers(false);
        propertiesLoaderLogger.setLevel(Level.ALL);
        propertiesLoaderLogger.addHandler(FileHandlerConfig.getFileHandler(propertiesLoaderLogger.getName()));
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
            propertiesLoaderLogger.log(Level.INFO,"properties file loaded in the getProperties() method");
        } catch (IOException e) {
            propertiesLoaderLogger.log(Level.WARNING,"getProperties() throws an IO exception");
            e.printStackTrace();
        }
        return properties;
    }
}

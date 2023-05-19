package com.sparta.tt;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileHandlerConfig {
    public static final Logger fileHandlerConfigLogger = Logger.getLogger(FileHandlerConfig.class.getName());
    static {
        fileHandlerConfigLogger.setUseParentHandlers(false);
        fileHandlerConfigLogger.setLevel(Level.INFO);
        fileHandlerConfigLogger.addHandler(FileHandlerConfig.getFileHandler(fileHandlerConfigLogger.getName()));
    }
    public static FileHandler getFileHandler(String loggerName) {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("src/main/resources/"+loggerName+".log", true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IllegalArgumentException | SecurityException e) {
            fileHandlerConfigLogger.log(Level.WARNING,"FileHandlerConfig has thrown an IllegalArgumentException or SecurityException");
            e.printStackTrace();
        } catch (IOException e) {
            fileHandlerConfigLogger.log(Level.WARNING,"FileHandlerConfig has thrown an IOException");
            e.printStackTrace();
        }
        return fileHandler;
    }

}

package com.sparta.tt;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogHandlerConfig {
    public static final Logger fileHandlerConfigLogger = Logger.getLogger(LogHandlerConfig.class.getName());
    static {
        fileHandlerConfigLogger.setUseParentHandlers(false);
        fileHandlerConfigLogger.setLevel(Level.OFF);
        fileHandlerConfigLogger.addHandler(LogHandlerConfig.getFileHandler(fileHandlerConfigLogger.getName()));
    }
    public static FileHandler getFileHandler(String loggerName) {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("src/main/resources/logs/"+loggerName+".log", true);
            fileHandler.setLevel(Level.OFF);
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

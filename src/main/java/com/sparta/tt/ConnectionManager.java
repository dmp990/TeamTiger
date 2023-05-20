package com.sparta.tt;

import com.sparta.tt.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {

    public static final Logger ConnectionManagerLogger = Logger.getLogger(ConnectionManager.class.getName());
    static {
        ConnectionManagerLogger.setUseParentHandlers(false);
        ConnectionManagerLogger.setLevel(Level.ALL);
        ConnectionManagerLogger.addHandler(LogHandlerConfig.getFileHandler(ConnectionManagerLogger.getName()));
    }

    private static Connection connection;

    public static Connection createConnection() {
        ConnectionManagerLogger.log(Level.INFO,"Connection Manager createConnection has been called");
        Properties properties = PropertiesLoader.getProperties();
        String url = properties.getProperty("url");
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            ConnectionManagerLogger.log(Level.WARNING,"Connection Manager createConnection() throws SQLException");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        ConnectionManagerLogger.log(Level.INFO,"Connection Manager has closed the connection ");
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
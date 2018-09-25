package ru.innopolis.classwork12.realExample.dao.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {
    private  static ConnectionManager connectionManager;

    private ConnectionManagerImpl(){
    }

    public static ConnectionManager getInstance(){
        if(connectionManager == null){
            connectionManager = new ConnectionManagerImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mobiles",
                    "postgres",
                    "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

package com.ifpb.model.databese;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static String url;
    private static String user;
    private static String senha;
    private static String driver;
    private static ConnectionFactory instance = null;

    public static ConnectionFactory getIsntance(){
        if( instance == null ){
            synchronized ((ConnectionFactory.class)){
                if( instance == null ){
                    instance = new ConnectionFactory();
                }
            }
        }
        return instance;
    }


    private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    static{

        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        try{
            properties.load(inputStream);
            inputStream.close();
            url = properties.getProperty("database.url");
            user = properties.getProperty("database.user");
            senha = properties.getProperty("database.password");
            driver = properties.getProperty("database.driver");

        } catch (IOException e) {
            logger.severe("Falha ao carregar arquivo de configuração");
        }

    }


    public Connection getConnection() throws ConnectionException {
        Connection connection = null;
        try{

            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,senha);

        } catch (ClassNotFoundException e) {
            throw new ConnectionException("Erro ao carregar o drive para a conexão!");
        } catch (SQLException e) {
            throw new ConnectionException("Erro ao tentar se conectar com o banco!");
        }
        return connection;
    }
}

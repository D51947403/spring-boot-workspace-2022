package com.singraul.boot.restapi.product.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//This is only to hikari pool connection
//This is not a part of this project
public class HikariCPDemo {
	private static HikariDataSource dataSource = null;
	 
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");
 
        dataSource = new HikariDataSource(config);
    }
 
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tt_product");
            while (resultSet.next()) {
                System.out.println("Product ID :" + resultSet.getInt(1));
                System.out.println("Product Name :" + resultSet.getString(2));
                System.out.println("Description :" + resultSet.getString(3));
                System.out.println("Price :" + resultSet.getString(4));
            }
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}

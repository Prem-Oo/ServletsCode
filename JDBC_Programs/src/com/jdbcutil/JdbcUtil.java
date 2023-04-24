package com.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getJDBCconnection() throws SQLException {
		
	String url="jdbc:mysql://localhost:3306/localdb";
	String user="root";
	String password="mysql@123";
	
	Connection connection =DriverManager.getConnection(url, user, password);
	return connection;
	
	
	}
	public static void closeConnection(ResultSet resultSet,Statement statement,Connection connection) throws SQLException {
		if(resultSet!=null)resultSet.close();
		if(statement!=null)statement.close();
		if(connection!=null)connection.close();
	}
}

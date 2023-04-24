package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Test {

	public static void main(String[] args) throws SQLException {
		// load and register driver
//		Driver	driver=new Driver();
//		DriverManager.registerDriver(driver);
		
		// setting connection b/w java and DB
		String url="jdbc:mysql://localhost:3306/localdb";
		String user="root";
		String password="mysql@123";
		
		Connection connection =DriverManager.getConnection(url, user, password);
		
		//creating statement object
		Statement statement=connection.createStatement();
		
		// using stmt obj to execute query
		String sqlSelectQuery="select stu_id,stu_name,course,marks from students";
		ResultSet resultSet=statement.executeQuery(sqlSelectQuery);
		
		//process the resultset to get data
		System.out.println("stuId\tName\tCourse\tMarks");
		while(resultSet.next()) {
			int stu_id=resultSet.getInt(1);	
			String name=resultSet.getString(2);	
			String course=resultSet.getString("course");	
			int marks=resultSet.getInt("marks");	
			System.out.println(stu_id+"\t"+name+"\t"+course+"\t"+marks);
			}
		
		resultSet.close();
		statement.close();
		connection.close();

	}

}

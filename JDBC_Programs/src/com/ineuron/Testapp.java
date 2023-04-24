package com.ineuron;

//Question1
//Give the menu to the user as the operation listed below on student table
//1. Create 2. Read 3. Update 4. Delete
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Testapp {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/localdb";
		String user="root";
		String password="mysql@123";
		
		Connection connection=DriverManager.getConnection(url,user,password);
		Statement statement=connection.createStatement();
		
		System.out.println("select option number to perform operation");
		System.out.println("1) create\n2) Read\n3) Update\n4) Delete");
		Scanner sc=new Scanner(System.in);
		int option =sc.nextInt();
		
		switch(option) {
		//Create
		case 1:{
			System.out.println("enter student name");
			String name=sc.next();
		
			
			System.out.println("enter subject name");
			String subject=sc.next();
			
			System.out.println("enter marks");
			int marks=sc.nextInt();
			
			
			String query=String.format("insert into student(`sname`,`subject`,`marks`) values('%s','%s',%d)",name,subject,marks);
			int rows=statement.executeUpdate(query);
			System.out.println("no. of rows affected:"+rows);
			break;
		}
		//Read
		case 2:{
			String readQuery=String.format("select * from student");
			ResultSet resultSet=statement.executeQuery(readQuery);
			System.out.println("ID\tName\tSubject\tMarks");
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String subject=resultSet.getString(3);;
				int marks=resultSet.getInt(4);
				System.out.println(id+"\t"+name+"\t"+subject+"\t"+marks);
			}
			resultSet.close();
			break;
			}
			//Update
		case 3:{
			System.out.println("enter name to update his marks");
			String name=sc.next();
			System.out.println("enter marks");
			int marks=sc.nextInt();
			String updateQuery=String.format("update student set marks=%d where sname='%s'",marks,name);
			int rows=statement.executeUpdate(updateQuery);
			System.out.println("no. of rows affected:"+rows);
			break;
		}
			//Delete
		case 4:{
			System.out.println("enter student name to delete data");
			String name=sc.next();
			String deleteQuery=String.format("delete from student where sname='%s'",name);
			int rows=statement.executeUpdate(deleteQuery);
			System.out.println("no. of rows affected:"+rows);
		break;	
		}
		}
		statement.close();
		connection.close();
		sc.close();
	}

}

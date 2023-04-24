package com.ineuron;

//Question3
//perform CRUD operation using preparedStatement
//1. insert 2. update 3. select 4. delete
import java.sql.*;
import java.util.Scanner;

import com.jdbcutil.JdbcUtil;

public class PreparedStmt {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("select option number to perform operation");
		System.out.println("1) create\n2) Read\n3) Update\n4) Delete");
		Scanner sc=new Scanner(System.in);
		int option =sc.nextInt();
		Connection connection=JdbcUtil.getJDBCconnection();
		PreparedStatement pstmt=null;
		switch(option) {
		//Create
		case 1:{
			System.out.println("enter student name");
			String name=sc.next();
		
			
			System.out.println("enter subject name");
			String subject=sc.next();
			
			System.out.println("enter marks");
			int marks=sc.nextInt();
			
			
			String query="insert into student(`sname`,`subject`,`marks`) values(?,?,?)";
			 pstmt=connection.prepareStatement(query);
			if(pstmt!=null) {
				pstmt.setString(1, name);
				pstmt.setString(2, subject);
				pstmt.setInt(3, marks);
			}
			
			int rows=pstmt.executeUpdate();
			System.out.println("no. of rows affected:"+rows);
			JdbcUtil.closeConnection(null, pstmt, connection);
			break;
		}
		//Read
		case 2:{
			String readQuery=String.format("select * from student");
			pstmt=connection.prepareStatement(readQuery);
			ResultSet resultSet=pstmt.executeQuery();
			System.out.println("ID\tName\tSubject\tMarks");
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String subject=resultSet.getString(3);;
				int marks=resultSet.getInt(4);
				System.out.println(id+"\t"+name+"\t"+subject+"\t"+marks);
			}
			JdbcUtil.closeConnection(resultSet, pstmt, connection);
			break;
			}
			//Update
		case 3:{
			System.out.println("enter name to update his marks");
			String name=sc.next();
			System.out.println("enter marks");
			int marks=sc.nextInt();
			String updateQuery="update student set marks=? where sname=?";
			pstmt=connection.prepareStatement(updateQuery);
			if(pstmt!=null) {
				pstmt.setInt(1,marks);
				pstmt.setString(2, name);
			}
			int rows=pstmt.executeUpdate();
			System.out.println("no. of rows affected:"+rows);
			JdbcUtil.closeConnection(null, pstmt, connection);
			break;
		}
			//Delete
		case 4:{
			System.out.println("enter student name to delete data");
			String name=sc.next();
			String deleteQuery="delete from student where sname=?";
			pstmt=connection.prepareStatement(deleteQuery);
			if(pstmt!=null) {
				pstmt.setString(1, name);
			}
			int rows=pstmt.executeUpdate();
			System.out.println("no. of rows affected:"+rows);
			JdbcUtil.closeConnection(null, pstmt, connection);
		break;	
		}
		}
		sc.close();
		
	}

}

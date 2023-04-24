package com.ineuron;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.jdbcutil.JdbcUtil;

//Question2
//perform insertion opertion and also perform retrieval operation on the following
//data
//name =>
//address=>
//gender =>
//DOB => dd-MM-yyyy
//DOJ => MM-dd-yyyy
//DOM => yyyy-MM-dd


public class SQLdate {

	public static void main(String[] args) throws SQLException, ParseException {
		
		Scanner sc=new Scanner(System.in);
		Connection	connection=JdbcUtil.getJDBCconnection();
		ResultSet rs=null;
		System.out.println("select operation : 1.insertion\t2.retrival");
		int option=sc.nextInt();	
		
		switch(option) {
		case 1:{
			System.out.print("enter name :: ");
			String name=sc.next();
			System.out.print("enter address :: ");
			String address=sc.next();
			System.out.print("enter gender :: ");
			String gender=sc.next();
			System.out.print("enter DOB => dd-MM-yyyy :: ");
			String dob=sc.next();
			System.out.print("enter DOJ => MM-dd-yyyy :: ");
			String doj=sc.next();
			System.out.print("enter DOM => yyyy-MM-dd :: ");
			String dom=sc.next();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udate=sdf.parse(dob);
			long l=udate.getTime();
			java.sql.Date sdob=new java.sql.Date(l);
			System.out.println(sdob);
			
			SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date udoj=sdf1.parse(doj);
		
			long l1=udoj.getTime();
			java.sql.Date sdoj=new java.sql.Date(l1);	
			System.out.println(sdoj);
			
			java.sql.Date sdom= java.sql.Date.valueOf(dom);
			System.out.println(sdom);
			
			String insertQuery="insert into users values(?,?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(insertQuery);
			if(pstmt!=null) {
				pstmt.setString(1, name);
				pstmt.setString(2,address);
				pstmt.setString(3,gender);
				pstmt.setDate(4,sdob);
				pstmt.setDate(5,sdoj);
				pstmt.setDate(6,sdom);
				
			}
			int rows=pstmt.executeUpdate();
			System.out.println("no. of rows affected:"+rows);
			JdbcUtil.closeConnection(null, pstmt, connection);
			break;
		}
		case 2:{
			String selectQuery="select * from users";
		PreparedStatement pstmt=connection.prepareStatement(selectQuery);
		if(pstmt!=null)
			rs=pstmt.executeQuery();
		System.out.println("Name\tAddress\tgender\tDOB\t\tDOJ\t\tDOM");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)
			+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
		}
			JdbcUtil.closeConnection(rs, pstmt, connection);
			break;
	
		}
	

	}
		sc.close();

}
}

package in.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.dto.Student;
import in.util.jdbcUtil;

public class StudentDAO implements IStudentDAO {

	Connection connection =null;
	

	
	@Override
	public Student findbyID(int id) {
		String sqlSelectQuery = "select sid, sname, subject, marks from student where sid=?";
		PreparedStatement pstmt = null;
		
		Student student=null;
		try {
			connection = jdbcUtil.getJDBCconnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					student=new Student();
					student.setSid(rs.getInt(1));
					student.setSname(rs.getString(2));
					student.setSubject(rs.getString(3));
					student.setMarks(rs.getInt(4));
				} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return student;
	}

	@Override
	public String updatebyID(Student newStudent) {
		String sqlUpdateQuery = "update student set sname=?, subject=?, marks=? where sid=? ";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = jdbcUtil.getJDBCconnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			if (pstmt != null) {
				pstmt.setString(1, newStudent.getSname());
				pstmt.setString(2, newStudent.getSubject());
				pstmt.setInt(3, newStudent.getMarks());
				pstmt.setInt(4, newStudent.getSid());
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					
					status = "success";
				} else {
					status = "failure";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

	@Override
	public String delete(int id) {
		String sqlDeleteQuery = "delete from student where sid=?";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = jdbcUtil.getJDBCconnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			if (pstmt != null) {
				pstmt.setInt(1, id);
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					
					status = "success";
				} else {
					status = "failure";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

	@Override
	public String save(Student student) {
		String sqlInsertQuery = "insert into student(`sname`,`subject`,`marks`) values(?,?,?)";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = jdbcUtil.getJDBCconnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, student.getSname());
				pstmt.setString(2, student.getSubject());
				pstmt.setInt(3, student.getMarks());
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					
					status = "success";
				} else {
					status = "failure";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

}

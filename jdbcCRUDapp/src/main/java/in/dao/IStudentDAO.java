package in.dao;

import in.dto.Student;

public interface IStudentDAO {
	String save(Student student);
	Student findbyID(int id);
	String updatebyID(Student newStudent);
	String delete(int id);
}

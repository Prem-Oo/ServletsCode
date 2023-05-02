package in.service;

import in.dto.Student;

public interface IStudentService {
	String save(Student student);
	Student findbyID(int id);
	String updatebyID(Student newStudent);
	String delete(int id);

}

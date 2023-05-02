package in.controller;

import in.dto.Student;

public interface IStudentController {
	String save(Student student);
	Student findbyID(int id);
	String updatebyID(Student newStudent);
	String delete(int id);
}

package in.service;

import in.Factory.StudentDAOFactory;
import in.dao.IStudentDAO;
import in.dto.Student;

public class StudentService implements IStudentService {

	IStudentDAO dao;

	@Override
	public Student findbyID(int id) {
		dao=StudentDAOFactory.getStudentDAO();
		return dao.findbyID(id);
	}

	@Override
	public String updatebyID(Student newStudent) {
		dao=StudentDAOFactory.getStudentDAO();
		return dao.updatebyID(newStudent);
	}

	@Override
	public String delete(int id) {
		dao=StudentDAOFactory.getStudentDAO();
		return dao.delete(id);
	}

	@Override
	public String save(Student student) {
		dao=StudentDAOFactory.getStudentDAO();
//		System.out.println("Implementation class Obj is (ser):: "+dao.getClass().getName());
		return dao.save(student);
		
	}

	

}

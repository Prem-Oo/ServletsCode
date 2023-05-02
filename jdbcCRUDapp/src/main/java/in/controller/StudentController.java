package in.controller;

import in.Factory.StudentServiceFactory;
import in.dto.Student;
import in.service.IStudentService;

public class StudentController implements IStudentController {

	IStudentService service=StudentServiceFactory.getStudentService();
	@Override
	public Student findbyID(int id) {
		return service.findbyID(id);
	}

	@Override
	public String updatebyID(Student student) {
		return service.updatebyID(student);
	}

	@Override
	public String delete(int id) {
		return service.delete(id);
	}

	@Override
	public String save(Student student) {
//		System.out.println(" save inside controller called");
//		System.out.println("Implementation class Obj is (cont):: "+service.getClass().getName());
		return service.save(student);
		
	}

}

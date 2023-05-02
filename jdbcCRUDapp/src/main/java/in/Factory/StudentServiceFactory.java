package in.Factory;

import in.service.IStudentService;
import in.service.StudentService;

public class StudentServiceFactory {
private static IStudentService service=null;
	
	public static IStudentService getStudentService() {
		if(service==null) 
			 service = new StudentService();
		return service;
	}
}

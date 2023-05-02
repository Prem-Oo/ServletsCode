package in.Factory;

import in.controller.IStudentController;
import in.controller.StudentController;

public class StudentControllerFactory {
	private static IStudentController controller=null;
	
	public static IStudentController getStudentController() {
		if(controller==null) {
			 controller = new StudentController();
		}
		return controller;
	}
}

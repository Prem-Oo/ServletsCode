package in.Factory;

import in.dao.IStudentDAO;
import in.dao.StudentDAO;

public class StudentDAOFactory {
private static IStudentDAO dao=null;
	
	public static IStudentDAO getStudentDAO() {
		if(dao==null) 
			 dao = new StudentDAO();
		return dao;
	}
}

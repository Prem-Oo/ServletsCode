package in.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.Factory.StudentControllerFactory;
import in.controller.IStudentController;
import in.dto.Student;

public class TestApp {

	public static void main(String[] args) {
		IStudentController studentController = null;
		String status = null, name = null, subject=null;
		Integer marks=0;
		Integer id = null;
		Student studentRecord = null;

		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("Your Option :: [1,2,3,4,5]:: ");
				Integer option = Integer.parseInt(br.readLine());

				studentController = StudentControllerFactory.getStudentController();

				switch (option) {
				case 1:
					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the subject:: ");
					subject = br.readLine();

					System.out.print("Enter marks:: ");
					marks = Integer.parseInt( br.readLine());

					Student student = new Student();
					student.setSname(name);
					student.setSubject(subject);
					student.setMarks(marks);
					

					status = studentController.save(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record inserted succesfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record insertion failed...");
					} else {
						System.out.println("Some problem occured...");
					}
					break;
				case 2:
					System.out.print("Enter the id:: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentController.findbyID(id);
					if (studentRecord != null)
						System.out.println(studentRecord);
					else
						System.out.println("Record not available for the given id ::" + id);
					break;

				case 3:
					System.out.print("Enter the id of the record to be updated:: ");
					id = Integer.parseInt(br.readLine());
					studentRecord = studentController.findbyID(id);
					if (studentRecord != null) {

						Student newStudent = new Student();
						newStudent.setSid(id);
						
						System.out.print("StudentName ::[Old Name is :: " + studentRecord.getSname() + "]:  ");
						String newName = br.readLine();
						if (newName == null || newName.equals("")) {
							newStudent.setSname(studentRecord.getSname());
						} else {
							newStudent.setSname(newName);
						}

						System.out.print("Subject ::[Old Subject is :: " + studentRecord.getSubject() + "]: ");
						String newSubject = br.readLine();
						if (newSubject == null || newSubject.equals("")) {
							newStudent.setSubject(studentRecord.getSubject());
						} else {
							newStudent.setSubject(newSubject);
						}

						System.out.print("marks ::[Old marks is :: " + studentRecord.getMarks() + "]:  ");
						try {
							int marks1 = Integer.parseInt(br.readLine());
							if (marks1 == marks) {
								newStudent.setMarks(studentRecord.getMarks());
							} else {
								newStudent.setMarks(marks1);
							}
						} catch (Exception e) {
							// TODO: handle exception
							newStudent.setMarks(studentRecord.getMarks());
						}
						

					

						status = studentController.updatebyID(newStudent);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Record updated succesfully...");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed...");
						} else {
							System.out.println("Some problem occured...");
						}

					} else
						System.out.println("Record not available for the given id ::" + id);
					break;

				case 4:
					System.out.print("Enter the id:: ");
					id = Integer.parseInt(br.readLine());
					status = studentController.delete(id);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted succesfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record deletion failed...");
					} else {
						System.out.println("Record not available for the given id to delete...");
					}
					break;
				case 5:
					System.out.println("Thanks for using the application");
					System.exit(0);

				default:
					System.out.println("Plz enter the option like 1,2,3,4,5 for operation");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}

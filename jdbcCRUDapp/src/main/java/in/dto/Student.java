package in.dto;

public class Student {
	private Integer sid;
	private String sname;
	private String subject;
	private Integer marks;
	
	public Student() {
		System.out.println("student obj created");
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student Details ::"+sname+","+subject+","+marks;
	}
	
	
	
}

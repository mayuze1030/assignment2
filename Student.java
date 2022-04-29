package entity;

public class Student {

	private int id;
	private String name;
	private String MathMark;
	private String department;
	
	public Student() {
		
	}

public Student(int id, String name, String mathMark, String department) {
	this.id = id;
	this.name = name;
	this.MathMark = mathMark;
	this.department = department;
    }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMathMark() {
	return MathMark;
}

public void setMathMark(String mathMark) {
	MathMark = mathMark;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", MathMark=" + MathMark + ", department=" + department + "]";
}
  
}
package test;

import java.util.List;
import java.util.Scanner;

import dao1.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;


/*
 * ǰ̨
 */
public class Test {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("");
			System.out.println("\t1.Check All the Student Information");
			System.out.println("\t2.Add Student Information");
			System.out.println("\t3.Exit");
	        
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
			findAll();
			break;
			case 2 :
			save();
			break;
			case 3:
				return;
			}
		}while(true) ;
			
		
	}
  public static void findAll() {
	  StudentDao StudentDao = new StudentDaoImpl(); 
	  List <Student> StuList = StudentDao.finaAll();
	  
	
	  if(StuList==null) {
		  System.out.println("There are No Student here");
	  }else {
		  System.out.println("ID:\tName:\tMathMark:\tDepartment:");
		  for(Student stu:StuList) {
			  System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getMathMark()+"\t"+stu.getDepartment());
			  
	  }
	  
	 
	  }
  }
  public static void save() {
	  Scanner scan = new Scanner(System.in);
	  System.out.println("Please Enter Student Id");
	  int id = scan.nextInt();
	  System.out.println("Please Enter Student Name");
	  String name = scan.next();
	  System.out.println("Please Enter Student MathMark");
	  String mathMark = scan.next();
	  System.out.println("Please Enter Student Department");
	  String department = scan.next();
	  
	  Student stu = new Student(id,name,mathMark,department);
	  StudentDao studentDao = new StudentDaoImpl();
	  int n = studentDao.save(stu);
	  
	  if(n>0) {
		  System.out.println("Add Student Successful!!");
	  }else {
		  System.out.println("Add Student Failed!!"); 
	  }
	  
	  
  }
}

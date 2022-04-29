package dao1;
 import entity.Student;
 import java.util.List;
public interface StudentDao {
	/*
	 *check all the student
	 */
  public List<Student> finaAll();
  /*
   * find by student id
   */
   public  Student findById(int id);
   public List<Student> find(String name , String department);
     /*
      * add student
      */
   public  int save(Student stu) ;

	  
   
   
   public int delete(int id);
	

}

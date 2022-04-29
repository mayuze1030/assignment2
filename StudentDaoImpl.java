package dao.impl;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;



import dao1.StudentDao;
import entity.Student;
import util.DButil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> finaAll()  {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		List<Student> stuList = new  ArrayList<Student>(); 
		try {
			
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://127.0.0.1:3306/student1";
	String user = "root";
	String password = "password";
	
	
	
	conn = DriverManager.getConnection(url,user,password);
	
	
	  stmt =  conn.createStatement();
	
	 String sql = "select*from student"; 
	rs =  stmt.executeQuery(sql);
	
	while(rs.next()) {
		
		int id = rs.getInt("id");
		String name = rs.getString("Name");
		String mathMark = rs.getString("MathMark");
		String department = rs.getString("Department");
		
		 
		Student stu = new Student( id,  name,  mathMark,  department);
		
		stuList.add(stu);
	}
	
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
			DButil.closeAll(rs, stmt, conn);
		}
		return stuList;
	
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> find(String name, String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Student stu) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
	int n =0;
	try { 
	conn = DButil.getConnection();
	
	
	
	 String sql = "insert into student values(?,?,?,?)"; 
	  pstmt =  conn.prepareStatement(sql);
	  
	  pstmt.setInt(1, stu.getId());
	  pstmt.setString(2, stu.getName());
	  pstmt.setString(3, stu.getMathMark());
	  pstmt.setString(4, stu.getDepartment());
	
	  
	
	
	n =  pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
			DButil.closeAll(rs, pstmt, conn);
		
		}
		return n;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
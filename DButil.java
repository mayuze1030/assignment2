package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DButil {

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/student1";
			String user = "root";
			String password = "password";
			conn = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
return conn;

	}
	
	public static  void closeAll(ResultSet rs ,Statement stmt , Connection conn ) {
		try {
			if(rs!=null) {
			rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt!=null) {
				 stmt.close();
				}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
			conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
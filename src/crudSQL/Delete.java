package crudSQL;

import java.sql.*;
import java.util.Scanner;
public class Delete {
	
	static final String URL="jdbc:mysql://localhost:3306/employee";
	static final String USER="root";
	static final String PASSWORD="pass@word1";
	static final String QUERY="delete from student where id=?";
	
	public static void main(String[] args) {

		try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(QUERY);){
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter student id");
			int id=sc.nextInt();
			ps.setInt(1, id);
			int b=ps.executeUpdate();
			if(b==1) {
				System.out.println("Student deleted successfully");
			} else {
				System.out.println("No student found with the given id");
			}
		}catch(SQLException e) {
			
		}
	}
}

package crudSQL;

import java.sql.*;
import java.util.Scanner;
public class Insertion {
	
	static final String URL="jdbc:mysql://localhost:3306/employee";
	static final String USER="root";
	static final String PASSWORD="pass@word1";
	static final String QUERY="insert into student (id,name,city,course,marks) values(?,?,?,?,?);";

	public static void main(String[] args) {

		try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				Statement st= con.createStatement();
				PreparedStatement ps=con.prepareStatement(QUERY);){
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter student id");
			int id=sc.nextInt();
			System.out.println("enter student name");
			String name=sc.next();
			System.out.println("enter student city");
			String city=sc.next();
			System.out.println("enter student city");
			String course=sc.next();
			System.out.println("enter student marks");
			int marks=sc.nextInt();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setString(4, course);
			ps.setInt(5, marks);
			int b=ps.executeUpdate();
			if(b==1) {
				System.out.println("Student details added successfully");
			}
		}catch(SQLException e) {
			
		}
		
		
	}

}

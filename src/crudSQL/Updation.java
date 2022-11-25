package crudSQL;

import java.sql.*;
import java.util.Scanner;
public class Updation {
	static final String URL="jdbc:mysql://localhost:3306/employee";
	static final String USER="root";
	static final String PASSWORD="pass@word1";
	static final String QUERY="update student set marks = ? where id = ?;";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(QUERY);){
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter student id");
			int id=sc.nextInt();
			System.out.println("enter marks to update");
			int marks=sc.nextInt();
			
			ps.setInt(1, marks);
			ps.setInt(2, id);
			int b=ps.executeUpdate();
			if(b==1) {
				System.out.println("Student marks updated successfully");
			}
			else {
				System.out.println("No student found with the given id");
			}
		}catch(SQLException e) {
			
		}
		
	}
}

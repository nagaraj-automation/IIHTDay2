package crudSQL;

import java.sql.*;

public class Retriever {
	
	static final String URL="jdbc:mysql://localhost:3306/employee";
	static final String USER="root";
	static final String PASSWORD="pass@word1";
	static final String QUERY="select * from student where id=?";
	
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				Statement st=con.createStatement();
				ResultSet rs= st.executeQuery(QUERY);){
			
			while(rs.next()) {
				System.out.print("\nid = "+ rs.getInt("id"));
				System.out.print("\t\tname = "+ rs.getString("name"));
				System.out.print("\t\tcity = "+ rs.getString("city"));
				System.out.print("\t\tsubject = "+ rs.getString("course"));
				System.out.print("\t\tmarks = "+ rs.getInt("marks"));
			}
			
		} catch(SQLException e) {
			
		}
	}

}

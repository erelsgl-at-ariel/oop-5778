package db;

import java.sql.*;

import javax.naming.NameNotFoundException;

/**
 * A demo of selecting from tables in SQLite.
 * @author erelsgl
 */
public class DataQueryDemo {
	
//	static double getSalary(String name) {
//		try (ResultSet rs = stmt.executeQuery("SELECT salary FROM employees WHERE name='"+name+"'")) {
//			if (rs.next()) {
//				return rs.getDouble("salary");
//			} else {
//				throw new NameNotFoundException("Employee "+name+" not found");
//			}
//			System.out.println();
//		}
//	}
	
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			try (Statement stmt = connection.createStatement()) {
				try (ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE name='Paul'")) {
					while (rs.next()) {
						System.out.println(
							"id=" + rs.getInt("id")+" "+
							"name=" + rs.getString("name")+" "+
							"age=" + rs.getInt("age")+" "+
							"address=" + rs.getString("id")+" "+
							"salary=" + rs.getFloat("salary"));
					}
					//System.out.println(rs.getInt("id"));
					System.out.println();
				}
				try (ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {
					while (rs.next()) {
						System.out.println(
							"id=" + rs.getInt("id")+" "+
							"name=" + rs.getString("name")+" "+
							"age=" + rs.getInt("age")+" "+
							"address=" + rs.getString("id")+" "+
							"salary=" + rs.getFloat("salary"));
					}
					System.out.println();
				}
				try (ResultSet rs = stmt.executeQuery(
						"SELECT id, name, age \n" + 
						"FROM employees \n" + 
						"WHERE id=1;")) {
					while (rs.next()) {
						System.out.println(
							"id=" + rs.getInt("id")+" "+
							"name=" + rs.getString("name")+" "+
							"age=" + rs.getInt("age")+" ");
					}
					System.out.println();
				}
				try (ResultSet rs = stmt.executeQuery("SELECT name,age,salary FROM employees ORDER BY salary ASC")) {
					while (rs.next()) {
						System.out.println(
							"name=" + rs.getString("name")+" "+
							"age=" + rs.getInt("age")+" "+" "+
							"salary=" + rs.getFloat("salary"));
					}
					System.out.println();
				}
				try (ResultSet rs = stmt.executeQuery("SELECT MAX(age) FROM employees WHERE salary>=20000")) {
					while (rs.next()) {
						System.out.println(
							"age=" + rs.getInt("MAX(age)"));
					}
					System.out.println();
				}
				
				try (ResultSet rs = stmt.executeQuery("SELECT MAX(age) FROM employees WHERE salary>=20000")) {
					while (rs.next()) {
						System.out.println(
							"age=" + rs.getInt("MAX(age)"));
					}
					System.out.println();
				}
			}
		}
	}
}
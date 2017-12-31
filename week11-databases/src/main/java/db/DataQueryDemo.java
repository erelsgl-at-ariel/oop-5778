package db;

import java.sql.*;

/**
 * A demo of selecting from tables in SQLite.
 * @author erelsgl
 */
public class DataQueryDemo {
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			try (Statement stmt = connection.createStatement()) {
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
				try (ResultSet rs = stmt.executeQuery("SELECT id,name,age FROM employees WHERE id=1")) {
					while (rs.next()) {
						System.out.println(
							"id=" + rs.getInt("id")+" "+
							"name=" + rs.getString("name")+" "+
							"age=" + rs.getInt("age")+" ");
					}
					System.out.println();
				}
				try (ResultSet rs = stmt.executeQuery("SELECT name,age,salary FROM employees WHERE salary>=20000")) {
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
			}
		}
	}
}
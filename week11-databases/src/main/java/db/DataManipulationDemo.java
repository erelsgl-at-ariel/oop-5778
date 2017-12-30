package db;

import java.sql.*;

/**
 * A demo of inserting, deleting and updating rows in SQLite.
 * @author erelsgl
 */
public class DataManipulationDemo {
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:company.db")) {
			System.out.println("Opened database successfully");
			try (Statement stmt = connection.createStatement()) {
				int numRows = stmt.executeUpdate(
					"DELETE FROM employees WHERE id IN (1,2,3,4)"
				);
				System.out.println(numRows+" rows deleted");
				
				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,address,salary)\n" + 
						"       VALUES (1, 'Paul', 32, 'California', 20000.00)");
				System.out.println(numRows+" rows inserted");

				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,address,salary)\n" + 
						"       VALUES (2, 'Allen', 25, 'Texas', 15000.00 ), \n" + 
						"              (3, 'Teddy', 23, 'Norway', 20000.00 )");
				System.out.println(numRows+" rows inserted");

				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,salary)\n" + 
						"       VALUES (4, 'Mark', 25, 65000.00 )");
				System.out.println(numRows+" rows inserted");
				
				numRows = stmt.executeUpdate(
						"UPDATE employees SET salary=25000 WHERE id=1 OR id=3");
				System.out.println(numRows+" rows updated");
			}
		}
	}
}

package db;

import java.sql.*;

/**
 * A demo of inserting, deleting and updating rows in SQLite.
 * @author erelsgl
 */
public class DataManipulationDemo {
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			try (Statement stmt = connection.createStatement()) {
				int numRows;
				numRows = stmt.executeUpdate(
					"DELETE FROM employees"
				);
				System.out.println(numRows+" rows deleted");
				
				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,address,salary)\n" + 
						"       VALUES (10, 'Paul', 32, 'California', 20000.00)");
				System.out.println(numRows+" rows inserted");

				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,address,salary)\n" + 
						"       VALUES (21, 'Allen', 25, 'Texas', 15000.00 ), \n" + 
						"              (35, 'Teddy', 23, 'Norway', 20000.00 )");
				System.out.println(numRows+" rows inserted");

				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,salary)\n" + 
						"       VALUES (47, 'Mark', 25, 65000.00 )");
				System.out.println(numRows+" rows inserted");
				

				numRows = stmt.executeUpdate(
						"INSERT INTO employees (id,name,age,salary)\n" + 
						"       VALUES (48, 'Mark', 25, 65000.00 )");
				System.out.println(numRows+" rows inserted");
				
				numRows = stmt.executeUpdate(
						"UPDATE employees SET salary=25000 WHERE id=1 OR id=3");
				System.out.println(numRows+" rows updated");
			}
		}
	}
}

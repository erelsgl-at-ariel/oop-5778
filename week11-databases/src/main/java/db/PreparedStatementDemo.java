package db;

import java.sql.*;

/**
 * A demo of preparing statements.
 * @author erelsgl
 */
public class PreparedStatementDemo {
	
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE name=?")) {
				stmt.setString(1, "Paul");
				System.out.println(stmt);
				ResultSetPrinter.print(stmt.executeQuery());

				stmt.setString(1, "Teddy");
				System.out.println(stmt); 
				ResultSetPrinter.print(stmt.executeQuery());

				stmt.setString(1, "Robert'; DROP TABLE employees");
				System.out.println(stmt);
				ResultSetPrinter.print(stmt.executeQuery());
			}
		}
	}
}
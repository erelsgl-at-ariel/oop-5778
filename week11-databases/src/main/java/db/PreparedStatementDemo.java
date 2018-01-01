package db;

import java.sql.*;

import javax.naming.NameNotFoundException;

/**
 * A demo of preparing statements.
 * @author erelsgl
 */
public class PreparedStatementDemo {

	static double getSalary(Connection connection, String name) throws SQLException, NameNotFoundException {
		try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE name=?")) {
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getDouble("salary");
				} else {
					throw new NameNotFoundException("Employee "+name+" not found");
				}
			}
		}
	}
	
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
//			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE name=?")) {
//				stmt.setString(1, "Paul");
//				System.out.println(stmt);
//				ResultSetPrinter.print(stmt.executeQuery());
//
//				stmt.setString(1, "Teddy");
//				System.out.println(stmt); 
//				ResultSetPrinter.print(stmt.executeQuery());
//
//				stmt.setString(1, "Robert'; DROP TABLE employees");
//				System.out.println(stmt);
//				ResultSetPrinter.print(stmt.executeQuery());
//			}
			System.out.println(getSalary(connection, "Paul"));
			System.out.println(getSalary(connection, "Robert'; DROP TABLE employees"));
		}
	}
}
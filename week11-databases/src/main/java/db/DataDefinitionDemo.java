package db;

import java.sql.*;

/**
 * A demo of creating tables and deleting tables in SQLite.
 * @author erelsgl
 */
public class DataDefinitionDemo {
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			try (Statement stmt = connection.createStatement()) {
//				stmt.executeUpdate("DROP TABLE IF EXISTS employees;");
//				System.out.println("Table dropped successfully");

				stmt.executeUpdate(
						"CREATE TABLE employees\n" + 
						"(id        INT PRIMARY KEY     NOT NULL,\n" + 
						" name      TEXT    NOT NULL,\n" + 
						" age       INT     NOT NULL,\n" + 
						" address   CHAR(50),\n" + 
						" salary    REAL);\n" + 
						""
				);
				System.out.println("Table created successfully");
			}
		}
	}
}

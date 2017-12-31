package db;

import java.sql.*;

/**
 * A demo of preparing statements.
 * @author erelsgl
 */
public class PreparedStatementDemo {
	
	private static void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(rsmd.getColumnName(i) + "=" + columnValue);
		    }
		    System.out.println("");
		}		
	}
	
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE name=?")) {
				stmt.setString(1, "Paul");
				System.out.println(stmt); 
				try (ResultSet rs = stmt.executeQuery()) {
					printResultSet(rs);
					System.out.println();
				}

				stmt.setString(1, "Teddy");
				System.out.println(stmt); 
				try (ResultSet rs = stmt.executeQuery()) {
					printResultSet(rs);
					System.out.println();
				}

				stmt.setString(1, "Robert'; DROP TABLE employees");
				System.out.println(stmt); 
				try (ResultSet rs = stmt.executeQuery()) {
					printResultSet(rs);
					System.out.println();
				}
			}
		}
	}
}
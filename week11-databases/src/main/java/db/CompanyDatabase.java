package db;

import java.sql.*;

public class CompanyDatabase {
	
	/**
	 * Connect to a local SQLite database
	 *
	static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:company.db");
	}*/
	
	
	/**
	 * Connect to a remote MySQL database
	 */
	static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			/* database= */ "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11213398", 
			/* username= */ "sql11213398",
			/* password= */ "jNlyMq3Kdd");
	}
	
}

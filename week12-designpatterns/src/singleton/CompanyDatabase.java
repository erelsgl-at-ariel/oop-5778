package singleton;

import java.sql.*;

/**
 * A singleton class for holding a DB connection.
 * 
 * @author erelsgl
 *
 */
public class CompanyDatabase {
	private static volatile Connection INSTANCE = null;
	
	public static Connection getConnection() throws SQLException {
		if (INSTANCE==null) {
			synchronized(CompanyDatabase.class) {
				if (INSTANCE==null || INSTANCE.isClosed()) {
					INSTANCE = newConnection();
					Runtime.getRuntime().addShutdownHook(new Thread(
						() -> {
							try {
								INSTANCE.close();
							} catch (SQLException ex) {
								throw new RuntimeException(ex);
							}
						}
					));
				}
			}
		} 
		return INSTANCE;
	}
	
	/**
	 * Connect to a local SQLite database
	 */
	private static Connection newConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:test.db");
	}
	
	
//	/**
//	 * Connect to a remote MySQL database
//	 */
//	private static Connection newConnection() throws SQLException {
//		return DriverManager.getConnection(
//			/* database= */ "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11213398", 
//			/* username= */ "sql11213398",
//			/* password= */ "jNlyMq3Kdd");
//	}

	
//	/**
//	 * Connect to Boaz's home server
//	 */
//	private static Connection newConnection() throws SQLException {
//		return DriverManager.getConnection(
//			/* database= */ "jdbc:mysql://5.29.193.52:3306/oop_course_ariel", 
//			/* username= */ "oop2",
//			/* password= */ "Lambda2();");
//		
//	}
}

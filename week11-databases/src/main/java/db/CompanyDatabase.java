package db;

import java.sql.*;

public class CompanyDatabase {
	static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlite:company.db");
	}
}

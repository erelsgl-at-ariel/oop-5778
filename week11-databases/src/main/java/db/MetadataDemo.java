package db;

import java.sql.*;

/**
 * A demo of reading database metadata.
 * Based on: https://www.udemy.com/how-to-connect-java-jdbc-to-mysql/learn/v4/t/lecture/2081068?start=0 
 * @author erelsgl
 */
public class MetadataDemo {
	public static void main( String args[] ) throws Throwable {
		try (Connection connection = CompanyDatabase.getConnection()) {
			System.out.println("Opened database successfully");
			DatabaseMetaData metadata = connection.getMetaData();
			ResultSetPrinter.print(
				metadata.getTables(null, null, null,null));
			ResultSetPrinter.print(
				metadata.getColumns(null, null, null, null));
		}
	}
}

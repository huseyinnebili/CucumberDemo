package practiceDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DatabaseMetaData_Sakila {

	String dbUserName = "root";
	String dbPassword = "2112522Hn.";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/sakila";

	@Test

	public void dbMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String driver_name = dbMetaData.getDriverName();
		System.out.println("Driver name -> " + driver_name);

		String connection = dbMetaData.getConnection().toString();
		System.out.println("Connection -> " + connection);

		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println("Product Version -> " + dbVersion);

		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println("Product Name -> " + dbName);

		
		
		conn.close();
	
	}

}

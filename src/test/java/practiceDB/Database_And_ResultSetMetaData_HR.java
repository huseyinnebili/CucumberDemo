package practiceDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Database_And_ResultSetMetaData_HR {

	String dbUserName = "root";
	String dbPassword = "2112522Hn.";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	@Test

	public void dbMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String driver_name = dbMetaData.getDriverName();

		String connection = dbMetaData.getConnection().toString();

		System.out.println("Driver name => " + driver_name);

		System.out.println(connection);

	}

	@Test

	public void rsMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int colum_count = rsMetaData.getColumnCount();
		System.out.println("Colum Count -> " + colum_count);

		String second_colum_name = rsMetaData.getColumnName(1);
		System.out.println("Second colum name ->" + second_colum_name);

		
		
		System.out.println("---------- To print all column names through for loop ---------- ");

		for (int i = 1; i <= colum_count; i++) {

			String column_names = rsMetaData.getColumnName(i);

			System.out.println(column_names);
		}

	
		System.out.println("---------- To print all column type through for loop ---------- ");

		for (int i = 1; i <= colum_count; i++) {

			String column_type = rsMetaData.getColumnTypeName(i);

			System.out.println(column_type);
		}
		
		
		
		rs.close();
		conn.close();
		st.close();
	}

}

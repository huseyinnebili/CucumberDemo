package employeesDD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMetaData_JDBCDemo6_Employees {

	public static String dbUsername = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String connection = dbMetaData.getConnection().toString();
		System.out.println("Connection -> " + connection);

		String driver_name = dbMetaData.getDriverName();
		System.out.println(driver_name);

		String database_version = dbMetaData.getDriverVersion();
		System.out.println(database_version);

		int max_table_name_length = dbMetaData.getMaxTableNameLength();
		System.out.println("Max Table Name Length -> " + max_table_name_length);

	}

}

package employeesDD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;



public class JDBCDemo5_Employees_MetaData {

	static String dbUserName = "root";
	static String dbPassword = "2112522Hn.";
	static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	@Test
	public void getDataBaseMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String connection = dbMetaData.getConnection().toString();
		System.out.println("Connection -> " + connection);

		String driver_name = dbMetaData.getDriverName().toString();
		System.out.println("Driver Name -> " + driver_name);

		String driver_version = dbMetaData.getDriverVersion().toString();
		System.out.println("Driver Version -> " + driver_version);

	}

	@Test
	public void getResultSetMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT * FROM COUNTRIES RIGHT JOIN LOCATIONS ON COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID WHERE REGION_ID >=(SELECT MIN(REGION_ID) FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')GROUP BY COUNTRY_NAME HAVING COUNT(REGION_ID)<>3 ORDER BY REGION_ID LIMIT 15;");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int column_count = rsMetaData.getColumnCount();

		System.out.println("----------------- Column Names -----------------");

		for (int i = 1; i <= column_count; i++) {

			String column_name = rsMetaData.getColumnName(i);

			System.out.println(column_name);

		}

		System.out.println("----------------- Column Types Name -----------------");

		for (int i = 1; i <= column_count; i++) {

			String column_type = rsMetaData.getColumnTypeName(i);

			System.out.println(column_type);

		}
		
		String column_six=rsMetaData.getColumnName(6).toString();
		
		Assert.assertEquals(column_six, "postal_code");

		System.out.println("------------------------------------");
	}
}

package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class ResultsetMetaData_JDBCDemo6_Employees {

	public static String dbUserName = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	@Test
	public void getColumn_Name() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM COUNTRIES\r\n" + "RIGHT JOIN LOCATIONS\r\n" + "ON\r\n"
				+ "COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID\r\n" + "WHERE REGION_ID  BETWEEN \r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')\r\n" + "AND\r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='JAPAN')\r\n"
				+ "GROUP BY COUNTRIES.COUNTRY_ID\r\n" + "HAVING COUNT(REGION_ID)>=1\r\n"
				+ "ORDER BY COUNT(REGION_ID)\r\n" + "LIMIT 5;");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int column_count = rsMetaData.getColumnCount();

		System.out.println("---------- Column Names ----------");

		for (int i = 1; i <= column_count; i++) {

			System.out.println(rsMetaData.getColumnName(i));
		}

	}

	@Test
	public void getColumn_Type_Name() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM COUNTRIES\r\n" + "RIGHT JOIN LOCATIONS\r\n" + "ON\r\n"
				+ "COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID\r\n" + "WHERE REGION_ID  BETWEEN \r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')\r\n" + "AND\r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='JAPAN')\r\n"
				+ "GROUP BY COUNTRIES.COUNTRY_ID\r\n" + "HAVING COUNT(REGION_ID)>=1\r\n"
				+ "ORDER BY COUNT(REGION_ID)\r\n" + "LIMIT 5;");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int column_count = rsMetaData.getColumnCount();

		System.out.println("---------- Column Type Names ----------");

		for (int i = 1; i <= column_count; i++) {

			System.out.println(rsMetaData.getColumnTypeName(i));
		}

	}

}

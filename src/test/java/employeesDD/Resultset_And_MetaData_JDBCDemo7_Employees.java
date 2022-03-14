package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Resultset_And_MetaData_JDBCDemo7_Employees {

	public static String dbUserName = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	@Test
	public void getResultSetMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM COUNTRIES\r\n" + "RIGHT JOIN LOCATIONS\r\n" + "ON\r\n"
				+ "COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID\r\n" + "WHERE REGION_ID >=\r\n"
				+ "(SELECT MIN(REGION_ID) FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')\r\n" + "GROUP BY COUNTRY_NAME\r\n"
				+ "HAVING COUNT(REGION_ID)<>3\r\n" + "ORDER BY REGION_ID\r\n" + "LIMIT 15;");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int column_count = rsMetaData.getColumnCount();

		List<String> list = new ArrayList<>();

		for (int i = 1; i <= column_count; i++) {

			String column_name = rsMetaData.getColumnName(i);

			// System.out.println(column_name);

			list.add(column_name);
		}

		System.out.println(list);

		conn.close();
		rs.close();
		st.close();

	}

	@Test
	public void getResultSet() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM COUNTRIES\r\n" + "RIGHT JOIN LOCATIONS\r\n" + "ON\r\n"
				+ "COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID\r\n" + "WHERE REGION_ID >=\r\n"
				+ "(SELECT MIN(REGION_ID) FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')\r\n" + "GROUP BY COUNTRY_NAME\r\n"
				+ "HAVING COUNT(REGION_ID)<>3\r\n" + "ORDER BY REGION_ID\r\n" + "LIMIT 15;");

		while (rs.next()) {

			String first_column = rs.getObject(1).toString();
			String second_column = rs.getObject(2).toString();

			System.out.println(first_column + " " + second_column + " ");
		}
		
		System.out.println("--------------------------");

		conn.close();
		rs.close();
		st.close();
	}
}

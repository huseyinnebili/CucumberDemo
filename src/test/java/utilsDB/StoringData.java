package utilsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringData {

	// @Test
	public void getAndStoreData() throws SQLException {

		ConfigsReader.readProperties(ConstantsDB.CONFIGURATION_FILEPATH);

		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
				ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,DEPARTMENT_ID FROM EMPLOYEES;");

		List<Map<String, String>> listOfMap = new LinkedList<>();

		while (rs.next()) {

			Map<String, String> map = new LinkedHashMap<>();

			map.put("EMPLOYEE_ID", rs.getString("EMPLOYEE_ID"));
			map.put("FIRST_NAME", rs.getString("FIRST_NAME"));
			map.put("LAST_NAME", rs.getString("LAST_NAME"));
			map.put("EMAIL", rs.getString("EMAIL"));
			map.put("PHONE_NUMBER", rs.getString("PHONE_NUMBER"));
			map.put("DEPARTMENT_ID", rs.getString("DEPARTMENT_ID"));

			listOfMap.add(map);
		}

		System.out.println(listOfMap);

		conn.close();
		rs.close();
		st.close();
	}

	@Test
	public void retrieveAndStoreEnhanced() throws SQLException {

		ConfigsReader.readProperties(ConstantsDB.CONFIGURATION_FILEPATH);

		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
				ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES  WHERE EMPLOYEE_ID <120;");

		ResultSetMetaData rsMD = rs.getMetaData();

		int column_count = rsMD.getColumnCount();

		List<Map<String, String>> listOfMap = new LinkedList<>();

		while (rs.next()) {

			Map<String, String> map = new LinkedHashMap<>();

			for (int i = 1; i <= column_count; i++) {

				String ColumnName = rsMD.getColumnName(i);
				String ColumValue = rs.getString(i);

				map.put(ColumnName, ColumValue);

			}

			listOfMap.add(map);

			System.out.println(listOfMap);

		}

	}
}
package employeesDD;

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
import utilsDB.ConfigsReader;
import utilsDB.ConstantsDB;

public class Resultset_And_MetaData_JDBCDemo8_Employees {

	@Test
	public void retrieveDataHardCodding() throws SQLException {

		ConfigsReader.readProperties(ConstantsDB.CONFIGURATION_FILEPATH);

		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
				ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY>\r\n"
				+ "(SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME='Diana');");

		List<Map<String, String>> listOfMap = new LinkedList<>();

		while (rs.next()) {

			Map<String, String> map = new LinkedHashMap<>();

			map.put("EMPLOYEE_ID", rs.getString("EMPLOYEE_ID"));
			map.put("FIRST_NAME", rs.getString("FIRST_NAME"));
			map.put("LAST_NAME", rs.getString("LAST_NAME"));
			map.put("EMAIL", rs.getString("EMAIL"));
			map.put("PHONE_NUMBER", rs.getString("PHONE_NUMBER"));

			listOfMap.add(map);

		}

		System.out.println(listOfMap);

		conn.close();
		rs.close();
		st.close();

	}

	@Test
	public void retrieveDataWithEnhancedLoop() throws SQLException {

		ConfigsReader.readProperties(ConstantsDB.CONFIGURATION_FILEPATH);

		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
				ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY>\r\n"
				+ "(SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME='Diana');");

		ResultSetMetaData rsMD = rs.getMetaData();

		int column_count = rsMD.getColumnCount();

		List<Map<String, String>> listOfMap = new LinkedList<>();

		while (rs.next()) {

			Map<String, String> map = new LinkedHashMap<>();

			for (int i = 1; i <= column_count; i++) {

				String column_name = rsMD.getColumnName(i);
				String column_value = rs.getString(i);

				map.put(column_name, column_value);

			}

			listOfMap.add(map);

		}

		System.out.println(listOfMap);

	}

}
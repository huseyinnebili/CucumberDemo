package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo2_Employees {

	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";
	public static String dbUserName = "root";
	public static String dbPassword = "2112522Hn.";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st
				.executeQuery("SELECT *, CONCAT(UPPER(FIRST_NAME),' ',UPPER(LAST_NAME)) AS FULL_NAME FROM EMPLOYEES;");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		System.out.println("Coulmn1 Name = " + rsMetaData.getColumnName(1));

		int column_count = rsMetaData.getColumnCount();

		
		System.out.println("------------- Column Names -----------");

		for (int i = 1; i <= column_count; i++) {

			String column_name = rsMetaData.getColumnName(i);

			System.out.println(column_name);

		}

		List<String> list = new ArrayList<>();

		while (rs.next()) {

			String full_name = rs.getObject("FULL_NAME").toString();

			list.add(full_name);

		}

		System.out.println(

				"--------- SELECT CONCAT(UPPER(FIRST_NAME),' ',UPPER(LAST_NAME)) AS FULL_NAME FROM EMPLOYEES;---------------- ");

		for (String ls : list) {

			System.out.println(ls);
		}

		ResultSet rs_2 = st.executeQuery(

				"SELECT CONCAT(LOWER(FIRST_NAME),' ',LOWER(LAST_NAME) ) AS FULL_NAME FROM EMPLOYEES WHERE LENGTH(FIRST_NAME) BETWEEN 1 AND 5;");

		List<String> list_2 = new ArrayList<>();

		while (rs_2.next()) {

			String full_name_2 = rs_2.getObject("FULL_NAME").toString();

			list_2.add(full_name_2);

		}

		System.out.println(

				"------ SELECT CONCAT(LOWER(FIRST_NAME),' ',LOWER(LAST_NAME) ) AS FULL_NAME FROM EMPLOYEES WHERE LENGTH(FIRST_NAME) BETWEEN 1 AND 5; ----------");

		for (String ls : list_2) {

			System.out.println(ls);
		}

		ResultSet rs_3 = st.executeQuery(

				"SELECT CONCAT( SUBSTRING(FIRST_NAME ,1,3),' ',SUBSTRING(LAST_NAME,1,3),'  ',EMAIL) AS EMPLOYEE_INFO FROM EMPLOYEES WHERE EMAIL LIKE 'D%';");

		List<String> list_3 = new ArrayList<>();

		while (rs_3.next()) {

			String employee_info = rs_3.getObject("EMPLOYEE_INFO").toString();

			list_3.add(employee_info);

		}

		System.out.println(

				"---------- SELECT CONCAT( SUBSTRING(FIRST_NAME ,1,3),' ',SUBSTRING(LAST_NAME,1,3),'  ',EMAIL) AS EMPLOYEE_INFO FROM EMPLOYEES WHERE EMAIL LIKE 'D%'; ---------");

		for (String ls : list_3) {

			System.out.println(ls);
		}

		rs.close();
		rs_2.close();
		rs_3.close();
		conn.close();
		st.close();
	}

}

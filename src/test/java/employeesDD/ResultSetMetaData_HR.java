package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ResultSetMetaData_HR {

	String dbUserName = "root";
	String dbPassword = "2112522Hn.";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	@Test

	public void getResultSetMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES WHERE LENGTH(FIRST_NAME) =5;");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int column_count = rsMetaData.getColumnCount();
		System.out.println("Column Count -> " + column_count);

		System.out.println("------------- Column Names ----------------");

		for (int i = 1; i <= column_count; i++) {

			String column_name = rsMetaData.getColumnName(i);

			System.out.println(column_name);
		}

		System.out.println("------------- Column Types ----------------");

		for (int i = 1; i <= column_count; i++) {

			String column_type = rsMetaData.getColumnTypeName(i);

			System.out.println(column_type);
		}

		rs.close();
		conn.close();
		st.close();

	}

	@Test

	public void getResultSetMetaData_2() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT *,CONCAT( SUBSTRING(FIRST_NAME ,1,3),' ',SUBSTRING(LAST_NAME,1,3),'  ',EMAIL) AS EMPLOYEE_INFO FROM EMPLOYEES WHERE EMAIL LIKE 'D%';");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int column_count = rsMetaData.getColumnCount();

		System.out.println("Column Count -> " + column_count);

		System.out.println("------------- Column Names ----------------");

		for (int i = 1; i <= column_count; i++) {

			String column_name = rsMetaData.getColumnName(i);

			System.out.println(column_name);
		}

		System.out.println("------------- Column Types ----------------");

		for (int i = 1; i <= column_count; i++) {

			String column_type = rsMetaData.getColumnTypeName(i);

			System.out.println(column_type);
		}

		rs.close();
		conn.close();
		st.close();
	}

}

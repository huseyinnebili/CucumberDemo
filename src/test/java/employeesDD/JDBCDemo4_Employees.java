package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo4_Employees {

	public static String dbUsername = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT *,CONCAT(FIRST_NAME,' ',LAST_NAME) AS FULL_NAME  FROM EMPLOYEES WHERE YEAR(HIRE_DATE) =1999;");

		System.out.println(" --------- Full Names ----------------");

		while (rs.next()) {

			String first_name = rs.getObject("full_name").toString();

			System.out.println(first_name);

		}

		ResultSet rs_2 = st.executeQuery(
				"SELECT *,CONCAT(FIRST_NAME,' ',LAST_NAME) AS FULL_NAME  FROM EMPLOYEES WHERE YEAR(HIRE_DATE) =1999;");

		System.out.println(" --------- Hire Dates ----------------");

		while (rs_2.next()) {

			String dates = rs_2.getObject("hire_date").toString();

			System.out.println(dates);
		}

	}

}

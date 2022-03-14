package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo1_Employees {

	public static String dbUsername = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		System.out.println("Database connection is succesfull!..");

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES WHERE LENGTH(FIRST_NAME) =5;");

		List<String> list = new ArrayList<>();

		while (rs.next()) {

			String first_name_list = rs.getObject("first_name").toString();

			list.add(first_name_list);

		}

		for (String ls : list) {

			System.out.println(ls);
		}

		System.out.println(
				"----------- SELECT CONCAT(FIRST_NAME,' ',LAST_NAME)AS FULL_NAME FROM EMPLOYEES WHERE LENGTH(FIRST_NAME)<=6 AND LENGTH(LAST_NAME)<=8; --------------");

		ResultSet rs_2 = st.executeQuery(
				"SELECT CONCAT(FIRST_NAME,' ',LAST_NAME)AS FULL_NAME FROM EMPLOYEES WHERE LENGTH(FIRST_NAME)<=6 AND LENGTH(LAST_NAME)<=8;");

		List<String> list_2 = new ArrayList<>();

		while (rs_2.next()) {

			String full_names = rs_2.getObject("FULL_NAME").toString();

			list_2.add(full_names);

		}

		for (String ls : list_2) {

			System.out.println(ls);
		}

		rs.close();
		rs_2.close();
		conn.close();
		st.close();

	}

}

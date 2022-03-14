package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCDemo3_Employees {

	public static String dbUsername = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st
				.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY>\r\n" + "(SELECT MIN(SALARY) FROM EMPLOYEES);");

		List<String> list = new ArrayList<>();

		while (rs.next()) {

			String salary_list = rs.getObject("salary").toString();

			list.add(salary_list);

		}

		for (String list_salary : list) {

			System.out.println(list_salary);

			if (list_salary.contains("11500.00")) {

				System.out.println("Test passed!...");
			}

		}

		ResultSet rs_2 = st.executeQuery("SELECT FIRST_NAME,LAST_NAME,EMAIL FROM EMPLOYEES WHERE SALARY >=5000;");

		Map<String, String> map = new HashMap<>();

		while (rs_2.next()) {

			map.put(rs_2.getObject("first_name").toString(), rs_2.getObject("last_name").toString());
		}

		System.out.println("----------- The key(first_name) list ------------");

		for (Map.Entry<String, String> entry : map.entrySet()) {

			System.out.println(entry.getKey());

		}

		System.out.println("----------- The value (last_name) list ------------");

		for (Map.Entry<String, String> entry_2 : map.entrySet()) {

			System.out.println(entry_2.getValue());
		}
	}
}

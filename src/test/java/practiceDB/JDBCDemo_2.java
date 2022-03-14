package practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo_2 {

	public static String dbUsername = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES");

		System.out.println("------------ Printing First_Name ----------------");

		List<String> list = new ArrayList<>();

		while (rs.next()) {

			String first_names = rs.getObject(2).toString();

			list.add(first_names);

		}

		for (String ls : list) {

			System.out.println(ls);
		}

		ResultSet rs_2 = st.executeQuery("SELECT DISTINCT * FROM EMPLOYEES WHERE DEPARTMENT_ID IS NOT NULL");

		System.out.println("------------ Printing Department_Id ----------------");

		List<String> department_id_lists = new ArrayList<>();

		while (rs_2.next()) {

			String department_id = rs_2.getObject("DEPARTMENT_ID").toString();

			department_id_lists.add(department_id);

			for (String department_id_list : department_id_lists) {

				System.out.println(department_id_list);
			}

		}

		rs.close();
		rs_2.close();
		st.close();
		conn.close();
		
	}

}

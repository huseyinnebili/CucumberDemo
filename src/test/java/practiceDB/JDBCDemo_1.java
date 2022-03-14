package practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo_1 {

	public static String dbUserName = "root";
	public static String dbPassword = "2112522Hn.";

	// jdbc:mysql://ipaddress:port/db_name
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		// creating a connection to the database
		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		System.out.println("Database connection is succesfull!..");

		// creating a statement
		Statement st = conn.createStatement();

		// executing a query
		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES");

		// getting values from the ResultSet
		rs.next();
		String first_name_1 = rs.getString("FIRST_NAME");
		System.out.println(first_name_1);

		// this line moves to the next row
		rs.next();
		String first_name_2 = rs.getString(2);
		System.out.println(first_name_2);

		// getting values through getObject(columIndex)
		rs.next();
		String first_name_3 = rs.getObject(2).toString();
		System.out.println(first_name_3);

		System.out.println("------- Printing the rest of the first names --------------");
		// getting values through while loop

		while (rs.next()) {

			String first_names = rs.getObject(2).toString();

			System.out.println(first_names);
		}

		rs.close();

		System.out.println("-------- Printing lastnames --------------");

		ResultSet rs_2 = st.executeQuery("SELECT * FROM EMPLOYEES");

		while (rs_2.next()) {

			String last_names = rs_2.getObject(3).toString();

			System.out.println(last_names);
		}

		rs_2.close();
		st.close();
		conn.close();

	}

}

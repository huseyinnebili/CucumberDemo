package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo6_Employees {

	public static String dbUsername = "root";
	public static String dbPassword = "2112522Hn.";
	public static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM COUNTRIES\r\n" + "RIGHT JOIN LOCATIONS\r\n" + "ON\r\n"
				+ "COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID\r\n" + "WHERE REGION_ID  BETWEEN \r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')\r\n" + "AND\r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='JAPAN')\r\n"
				+ "GROUP BY COUNTRIES.COUNTRY_ID\r\n" + "HAVING COUNT(REGION_ID)>=1\r\n"
				+ "ORDER BY COUNT(REGION_ID)\r\n" + "LIMIT 5;");

		System.out.println("---------- Country Names ----------------");
		
		while (rs.next()) {

			String text_of_second_column = rs.getObject(2).toString();

			System.out.println(text_of_second_column);

		}
		
		ResultSet rs_2 = st.executeQuery("SELECT * FROM COUNTRIES\r\n" + "RIGHT JOIN LOCATIONS\r\n" + "ON\r\n"
				+ "COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID\r\n" + "WHERE REGION_ID  BETWEEN \r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')\r\n" + "AND\r\n"
				+ "(SELECT REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME='JAPAN')\r\n"
				+ "GROUP BY COUNTRIES.COUNTRY_ID\r\n" + "HAVING COUNT(REGION_ID)>=1\r\n"
				+ "ORDER BY COUNT(REGION_ID)\r\n" + "LIMIT 5;");
		
		System.out.println("----------- Street Address -----------------");
		
		while(rs_2.next()) {
			
			String street_name=rs_2.getObject(5).toString();
			System.out.println(street_name);
		}


		conn.close();
		rs.close();
		st.close();

	}

}

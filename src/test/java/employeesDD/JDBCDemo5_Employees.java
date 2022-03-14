package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo5_Employees {

	static String dbUserName = "root";
	static String dbPassword = "2112522Hn.";
	static String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT * FROM COUNTRIES RIGHT JOIN LOCATIONS ON COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID WHERE REGION_ID >=(SELECT MIN(REGION_ID) FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')GROUP BY COUNTRY_NAME HAVING COUNT(REGION_ID)<>3 ORDER BY REGION_ID LIMIT 15;");

		System.out.println("--------------- Country Names ---------------------");
		
		while(rs.next()) {
			
			String column_2=rs.getObject(2).toString();
			
			System.out.println(column_2);
		}
		
		ResultSet rs_2 = st.executeQuery(
				"SELECT * FROM COUNTRIES RIGHT JOIN LOCATIONS ON COUNTRIES.COUNTRY_ID=LOCATIONS.COUNTRY_ID WHERE REGION_ID >=(SELECT MIN(REGION_ID) FROM COUNTRIES WHERE COUNTRY_NAME='ITALY')GROUP BY COUNTRY_NAME HAVING COUNT(REGION_ID)<>3 ORDER BY REGION_ID LIMIT 15;");

		
		System.out.println("------------- Street  Adress --------------------");
		
		while(rs_2.next()) {
			
			String column_5=rs_2.getObject(5).toString();
			
			System.out.println(column_5);
			
		}
	}

}

package employeesDD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Test;




public class JDBCDemo4_Employees_MetaData {

	String dbUserName = "root";
	String dbPassword = "2112522Hn.";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/hr";

	@Test
	public void getDataBaseMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String connection = dbMetaData.getConnection().toString();
		System.out.println("Connection -> " + connection);

		String dbProductName = dbMetaData.getDatabaseProductName().toString();
		System.out.println("Database Product Name -> " + dbProductName);

		String driverName = dbMetaData.getDriverName().toString();
		System.out.println("Driver Name -> " + driverName);

		conn.close();

		
		
	}

	@Test
	public void getResultSetMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		Statement st = conn.createStatement();
		
		ResultSet rs=st.executeQuery("SELECT *,CONCAT(FIRST_NAME,' ',LAST_NAME) AS FULL_NAME  FROM EMPLOYEES WHERE YEAR(HIRE_DATE) =1999;");
		
		ResultSetMetaData rsMetaData=rs.getMetaData();
		
		int column_count=rsMetaData.getColumnCount();
		System.out.println("Column Count -> "+column_count);
		
		
		System.out.println("----------- Column Name ------------");
		
		for(int i=1;i<=column_count;i++) {
			
			String column_name=rsMetaData.getColumnName(i);
			
			System.out.println(column_name);
			
			
		}
		
		System.out.println("----------- Column Type Name ------------");
		
		for(int i=1;i<=column_count;i++) {
			
			String column_type=rsMetaData.getColumnTypeName(i);
			
			System.out.println(column_type);
		}
		
		String first_name=rsMetaData.getColumnName(2);
		Assert.assertEquals(first_name, "first_name");
		
		System.out.println("---------------------------------------");
		
}
	
}

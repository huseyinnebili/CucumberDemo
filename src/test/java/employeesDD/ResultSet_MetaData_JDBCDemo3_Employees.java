package employeesDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

public class ResultSet_MetaData_JDBCDemo3_Employees {

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
		System.out.println("The column count -> " + column_count);

		System.out.println("----------- The column names ---------------");

		for (int i = 1; i <= column_count; i++) {

//		   String column_name=rsMetaData.getColumnName(i);
//		   System.out.println(column_name);

		}

		System.out.println("----------- The column type names ---------------");

		for (int i = 1; i <= column_count; i++) {

			String column_type_names = rsMetaData.getColumnTypeName(i);
			System.out.println(column_type_names);
		}

	}

}

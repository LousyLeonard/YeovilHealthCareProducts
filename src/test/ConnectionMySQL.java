package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionMySQL {
	public static void main(final String [] args){
		try {
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "password");
			//			System.out.println("Connection Success");
			final String query = "SELECT * FROM Student";
			final Statement stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println("Name: " + rs.getString("Name") + " ... " + "Age: " + rs.getString("Age"));
			}
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}
	}
}

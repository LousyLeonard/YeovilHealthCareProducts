package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	public static void main(final String [] args){
		try {
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/products", "root", "password");
			System.out.println("Connection Success");
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}
	}
}

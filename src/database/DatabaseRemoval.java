package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

/**
 * @author tommy.hamblin
 *
 */
public class DatabaseRemoval {

	public static void dropDatabase() throws MySQLSyntaxErrorException
	{
		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/YeovilHealthcare?allowMultiQueries=true", DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);

			// Builds query to drop database
			final String query = DatabaseConstants.USE_DATABASE +  DatabaseConstants.DROP_PRODUCT_KEYWORD_TABLE + DatabaseConstants.DROP_IMAGE_TABLE + DatabaseConstants.DROP_PRODUCT_TABLE  + DatabaseConstants.DROP_KEYWORD_TABLE + DatabaseConstants.DROP_BRAND_TABLE;
			final Statement stmt = conn.createStatement();

			// Executes the query
			stmt.executeUpdate(query);

			// Closes the database connection
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}
	}
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

/**
 * @author tommy.hamblin
 *
 */
public class DatabaseCreation {

	public static void createDatabase() throws MySQLSyntaxErrorException
	{
		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/YeovilHealthcare?allowMultiQueries=true", DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);

			// Builds the database and table creation script query
			final String query = DatabaseConstants.CREATE_DATABASE + DatabaseConstants.USE_DATABASE + DatabaseConstants.CREATE_BRAND_TABLE + DatabaseConstants.CREATE_PRODUCT_TABLE + DatabaseConstants.CREATE_IMAGE_TABLE + DatabaseConstants.CREATE_KEYWORD_TABLE + DatabaseConstants.CREATE_PRODUCT_KEYWORD_TABLE;
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
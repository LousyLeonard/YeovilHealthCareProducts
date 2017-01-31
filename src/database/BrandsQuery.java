package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import core.Brand;

/**
 * @author tommy.hamblin
 *
 */
public class BrandsQuery {	

	public static ArrayList<Brand> getAllBrands() {
		final String query = DatabaseConstants.BRAND_SELECT_STATEMENT;

		return doQuery(query);
	}
	
	public static ArrayList<Brand> getTopTenBrands() {
		final String query = DatabaseConstants.BRAND_TOP_10;

		return doQuery(query);
	}
	
	private static ArrayList<Brand> doQuery(String query)
	{
		ArrayList<Brand> brands = new ArrayList<Brand>();

		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Creates a new brand object with the result set output
				Brand brand = new Brand();
				brand.setBrand(rs.getString(DatabaseConstants.BRAND_NAME));

				// Adds the brand object to the brands arraylist
				brands.add(brand);
			}

			// Closes the database connection
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}

		return brands;
	}
	
}

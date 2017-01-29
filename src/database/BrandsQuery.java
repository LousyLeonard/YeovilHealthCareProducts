package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import core.Brand;

/**
 * @author tommy.hamblin
 *
 */
public class BrandsQuery {

	/** Initialises a brand object. */
	private static Brand brand;

	/** Initialises an arraylist of brands. */
	private static ArrayList<Brand> brandsList;

	public static ArrayList<Brand> getAllBrands(final String searchField)
	{
		brandsList = new ArrayList<Brand>();

		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final String query = DatabaseConstants.BRAND_SELECT_STATEMENT;
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Creates a new brand object with the result set output
				brand = new Brand();
				brand.setBrand(rs.getString(DatabaseConstants.BRAND_NAME));

				// Adds the brand object to the brands arraylist
				brandsList.add(brand);
			}

			// Closes the database connection
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}

		return brandsList;
	}
}

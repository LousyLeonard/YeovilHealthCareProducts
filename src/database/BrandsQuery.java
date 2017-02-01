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

	// Returns all brands
	public static ArrayList<Brand> getAllBrands() {
		final String query = DatabaseConstants.BRAND_SELECT_STATEMENT;

		return doQuery(query);
	}

	// Returns the unique ID of a brand
	public static Integer getBrandID(final String brandName)
	{
		final String query = DatabaseConstants.SELECT_ALL_BRANDS + DatabaseConstants.APOSTROPHE + brandName + DatabaseConstants.APOSTROPHE + DatabaseConstants.SEMI_COLON;

		final ArrayList<Brand> brands = doQuery(query);
		if (brands.isEmpty()) {
			return -1;
		}

		return brands.get(0).getBrandID();
	}

	public static ArrayList<Brand> getTopTenBrands() {
		final String query = DatabaseConstants.BRAND_TOP_10;

		return doQuery(query);
	}

	private static ArrayList<Brand> doQuery(final String query)
	{
		final ArrayList<Brand> brands = new ArrayList<Brand>();

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
				final Brand brand = new Brand();
				brand.setBrand(rs.getString(DatabaseConstants.BRAND_NAME));
				brand.setBrandID(Integer.parseInt(rs.getString(DatabaseConstants.BRAND_PRIMARY_ID)));

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

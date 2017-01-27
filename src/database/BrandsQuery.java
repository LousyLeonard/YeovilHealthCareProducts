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

	/** Constant for the brand name. */
	private static final String BRAND_NAME = "Brand_Name";

	/** Initialises an arraylist of brands. */
	private static ArrayList<Brand> brands;

	/** Constant for the database connection. */
	private static final String DATABASE_CONNECTION = "jdbc:mysql://localhost/YeovilHealthcare";

	/** Constant for the database password. */
	private static final String DATABASE_PASSWORD = "password";

	/** Constant for the database username. */
	private static final String DATABASE_USERNAME = "root";

	/** Constant for the JDBC driver. */
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/** Constant for the SQL select statement. */
	private static final String SELECT_STATEMENT = "SELECT b.Brand_Name FROM YeovilHealthcare.Brand AS b";

	public static ArrayList<Brand> getAllBrands(final String searchField)
	{
		brands = new ArrayList<Brand>();

		try
		{
			Class.forName(JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DATABASE_CONNECTION, DATABASE_USERNAME, DATABASE_PASSWORD);
			final String query = SELECT_STATEMENT;
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Creates a new brand object with the result set output
				brand = new Brand();
				brand.setBrand(rs.getString(BRAND_NAME));

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

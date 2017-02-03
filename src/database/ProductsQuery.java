package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Product;

/**
 * @author tommy.hamblin
 *
 */
public class ProductsQuery {

	/** Initialises a product object. */
	private static Product product = null;

	/** Initialises a products arraylist. */
	private static ArrayList<Product> products = null;

	/** Initialises the database connection. */
	private static Connection conn = null;

	/** Initialises a prepared sql statement. */
	private static PreparedStatement stmt = null;

	// Returns all products
	public static ArrayList<Product> getAllProducts(final String searchField)
	{
		// Builds query from constants
		final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN + DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.SEMI_COLON;

		try 
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);
			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			stmt = conn.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println(e);
		}
		
		return doQuery(query);
	}

	// Returns all products for a brand name
	public static ArrayList<Product> getProductsByBrand(final String searchField)
	{
		// Builds query from constants
		final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN + DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.BRAND_WHERE_CLAUSE;

		// Replaces parameters with search field value
		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);
			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchField);
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println(e);
		}


		return doQuery(query);
	}

	// Returns all products as searched on by keyword
	public static ArrayList<Product> getProductsByKeyword(final String searchField)
	{
		// Builds query from constants
		final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN + DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.PRODUCT_KEYWORD_LEFT_JOIN + DatabaseConstants.KEYWORD_LEFT_JOIN + DatabaseConstants.KEYWORD_WHERE_CLAUSE;

		// Replaces parameters with search field value
		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);
			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchField);
			stmt.setString(2, searchField);
			stmt.setString(3, searchField);
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println(e);
		}

		return doQuery(query);
	}

	// Executes the query with the appropriate SQL statement
	private static ArrayList<Product> doQuery(final String query)
	{
		products = new ArrayList<Product>();

		try
		{
			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Create a new product object with the result set output
				product = new Product();
				product.setProductName(rs.getString(DatabaseConstants.PRODUCT_NAME));
				product.setBrand(rs.getString(DatabaseConstants.BRAND_NAME));
				product.setProductPrice(Double.parseDouble(rs.getString(DatabaseConstants.PRODUCT_PRICE)));
				product.addImagePath(rs.getString(DatabaseConstants.IMAGE_FILEPATH));

				// Adds the product object to the products arraylist
				products.add(product);
			}

			// Closes the database connection
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}

		return products;

	}

}
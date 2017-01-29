package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import core.Product;

/**
 * @author tommy.hamblin
 *
 */
public class ProductsQuery {

	/** Instantiates a product object. */
	private static Product product = null;

	/** Instantiates a products arraylist. */
	private static ArrayList<Product> products = null;

	public static ArrayList<Product> getAllProducts(final String searchField)
	{
		products = new ArrayList<Product>();

		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN + DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.SEMI_COLON;
			final Statement stmt = conn.createStatement();

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

	public static ArrayList<Product> getProductsByBrand(final String searchFieldEntry)
	{
		products = new ArrayList<Product>();

		try
		{

			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN + DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.BRAND_WHERE_CLAUSE + searchFieldEntry + DatabaseConstants.SEMI_COLON;
			final Statement stmt = conn.createStatement();

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

	public static ArrayList<Product> getProductsByKeyword(final String searchFieldEntry)
	{
		products = new ArrayList<Product>();

		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN + DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.PRODUCT_KEYWORD_LEFT_JOIN + DatabaseConstants.KEYWORD_LEFT_JOIN + DatabaseConstants.KEYWORD_WHERE_CLAUSE_PART1 + searchFieldEntry + DatabaseConstants.KEYWORD_WHERE_CLAUSE_PART2 + searchFieldEntry + DatabaseConstants.KEYWORD_WHERE_CLAUSE_PART3 + searchFieldEntry + DatabaseConstants.SEMI_COLON;
			final Statement stmt = conn.createStatement();

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
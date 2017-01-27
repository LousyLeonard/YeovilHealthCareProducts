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

	/** SQL inner join of the brand table on the product table. */
	private static final String BRAND_INNER_JOIN = "INNER JOIN Brand AS b ON b.Brand_ID = p.Brand_ID ";

	/** Constant for the Brand Name. */
	private static final String BRAND_NAME = "Brand_Name";

	/** Constant for the SQL where clause for brand name. */
	private static final String BRAND_WHERE_CLAUSE = "WHERE b.Brand_Name = ";

	/** Constant for closing statement. */
	private static final String CLOSE = ";";

	/** Constant for the database connection. */
	private static final String DATABASE_CONNECTION_CONSTANT = "jdbc:mysql://localhost/YeovilHealthcare";

	/** Constant for the database password. */
	private static final String DATABASE_PASSWORD = "password";

	/** Constant for the database username. */
	private static final String DATABASE_USERNAME = "root";

	/** Constant for the Image Filepath. */
	private static final String IMAGE_FILEPATH = "Image_Filepath";

	/** SQL inner join of the image table on the product table. */
	private static final String IMAGE_INNER_JOIN = "INNER JOIN Image AS i ON i.Product_ID = p.Product_ID;";

	/** Constant for the JDBC Driver. */
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/** SQL inner join of the keyword table on the product_keyword table. */
	private static final String KEYWORD_LEFT_JOIN = "LEFT JOIN Keyword AS k ON k.Keyword_ID = pk.Keyword_ID ";

	/** Constant for the SQL where clause for product name. */
	private static final String KEYWORD_WHERE_CLAUSE_PART1 = "WHERE p.Product_Name = ";

	/** Where clause continuation. */
	private static final String KEYWORD_WHERE_CLAUSE_PART2 = " OR b.Brand_Name = ";

	/** Where clause continuation. */
	private static final String KEYWORD_WHERE_CLAUSE_PART3 = " OR k.Keyword_Text = ";

	/** Instantiates a product object. */
	private static Product product = null;

	/** SQL left join of the product_keyword table on the product table. */
	private static final String PRODUCT_KEYWORD_LEFT_JOIN = "LEFT JOIN Product_Keyword AS pk ON pk.Product_ID = p.Product_ID ";

	/** Constant for the Product Name. */
	private static final String PRODUCT_NAME = "Product_Name";

	/** Constant for the Product Price. */
	private static final String PRODUCT_PRICE = "Product_Price";

	/** Instantiates a products arraylist. */
	private static ArrayList<Product> products = null;

	/** Constant for the SQL select statement. */
	private static final String SELECT_STATEMENT = "SELECT p.Product_Name, b.Brand_Name, p.Product_Price, i.Image_Filepath FROM YeovilHealthcare.Product AS p ";

	public static ArrayList<Product> getAllProducts(final String searchField)
	{
		products = new ArrayList<Product>();

		try
		{
			Class.forName(JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DATABASE_CONNECTION_CONSTANT, DATABASE_USERNAME, DATABASE_PASSWORD);
			final String query = SELECT_STATEMENT + BRAND_INNER_JOIN + IMAGE_INNER_JOIN;
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Create a new product object with the result set output
				product = new Product();
				product.setProductName(rs.getString(PRODUCT_NAME));
				product.setBrand(rs.getString(BRAND_NAME));
				product.setProductPrice(Double.parseDouble(rs.getString(PRODUCT_PRICE)));
				product.addImagePath(rs.getString(IMAGE_FILEPATH));

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

			Class.forName(JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DATABASE_CONNECTION_CONSTANT, DATABASE_USERNAME, DATABASE_PASSWORD);
			final String query = SELECT_STATEMENT + BRAND_INNER_JOIN + IMAGE_INNER_JOIN + BRAND_WHERE_CLAUSE + searchFieldEntry + CLOSE;
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Create a new product object with the result set output
				product = new Product();
				product.setProductName(rs.getString(PRODUCT_NAME));
				product.setBrand(rs.getString(BRAND_NAME));
				product.setProductPrice(Double.parseDouble(rs.getString(PRODUCT_PRICE)));
				product.addImagePath(rs.getString(IMAGE_FILEPATH));

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
			Class.forName(JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DATABASE_CONNECTION_CONSTANT, DATABASE_USERNAME, DATABASE_PASSWORD);
			final String query = SELECT_STATEMENT + BRAND_INNER_JOIN + IMAGE_INNER_JOIN + PRODUCT_KEYWORD_LEFT_JOIN + KEYWORD_LEFT_JOIN + KEYWORD_WHERE_CLAUSE_PART1 + searchFieldEntry + KEYWORD_WHERE_CLAUSE_PART2 + searchFieldEntry + KEYWORD_WHERE_CLAUSE_PART3 + searchFieldEntry + CLOSE;
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Create a new product object with the result set output
				product = new Product();
				product.setProductName(rs.getString(PRODUCT_NAME));
				product.setBrand(rs.getString(BRAND_NAME));
				product.setProductPrice(Double.parseDouble(rs.getString(PRODUCT_PRICE)));
				product.addImagePath(rs.getString(IMAGE_FILEPATH));

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
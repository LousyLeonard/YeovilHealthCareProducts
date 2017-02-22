package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import core.Product;

/**
 * @author tommy.hamblin
 *
 */
public class ProductsQuery {

	// Returns all products
	public static ArrayList<Product> getAllProducts(final ArrayList<String> searchField, final Integer pageNo) {
		// Builds query from constants
		
		final StringBuilder query = new StringBuilder(DatabaseConstants.PRODUCT_SELECT_STATEMENT 
				+ DatabaseConstants.BRAND_INNER_JOIN
				+ DatabaseConstants.IMAGE_INNER_JOIN 
				+ DatabaseConstants.PRODUCT_KEYWORD_LEFT_JOIN
				+ DatabaseConstants.KEYWORD_LEFT_JOIN);
		
		if (!searchField.isEmpty()) {
			query.append(DatabaseConstants.SEARCH_CLAUSE);

		}
		
		query.append(DatabaseConstants.LIMIT_AND_OFFSET + (pageNo - 1)* 20);
		query.append(DatabaseConstants.SEMI_COLON);

		return doQuery(query.toString(), searchField);
	}

	// Returns all products for a brand name
	public static ArrayList<Product> getProductsByBrand(final ArrayList<String> searchField) {
		// Builds query from constants
		final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT 
				+ DatabaseConstants.BRAND_INNER_JOIN
				+ DatabaseConstants.IMAGE_INNER_JOIN 
				+ DatabaseConstants.BRAND_WHERE_CLAUSE;

		return doQuery(query, searchField);
	}

	// Executes the query with the appropriate SQL statement
	private static ArrayList<Product> doQuery(final String query, final ArrayList<String> searchField) {

		final ArrayList<Product> products = new ArrayList<Product>();

		try {
			Class.forName(DatabaseConstants.JDBC_DRIVER);
			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION,
					DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final PreparedStatement stmt = conn.prepareStatement(query);

			String finalQuery;
			if (searchField != null) {
				finalQuery = query.replace("?", searchField.toString());
			} else {
				finalQuery = query;
			}

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(finalQuery);

			while (rs.next()) {
				// Create a new product object with the result set output
				final Product product = new Product();
				product.setProductName(rs.getString(DatabaseConstants.PRODUCT_NAME));
				product.setBrand(rs.getString(DatabaseConstants.BRAND_NAME));
				product.setProductPrice(Double.parseDouble(rs.getString(DatabaseConstants.PRODUCT_PRICE)));
				product.addImagePath(rs.getString(DatabaseConstants.IMAGE_FILEPATH));

				// Adds the product object to the products arraylist
				products.add(product);
			}

			// Closes the database connection
			conn.close();
		} catch (final Exception e) {
			System.err.println(e);
		}

		return products;

	}

	public static Integer getNumberOfPages() {
		// Builds query from constants
		final String query = DatabaseConstants.PRODUCT_SELECT_STATEMENT + DatabaseConstants.BRAND_INNER_JOIN
				+ DatabaseConstants.IMAGE_INNER_JOIN + DatabaseConstants.SEMI_COLON;

		final ArrayList<Product> products = doQuery(query, null);

		Integer numberOfPages = products.size() / 20;
		if (products.size() % 20 != 0) {
			numberOfPages++;
		}
		return numberOfPages;
	}

}
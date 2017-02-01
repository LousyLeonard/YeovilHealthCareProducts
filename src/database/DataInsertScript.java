package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import core.Product;
import database.IDGenerator.Table;

/**
 * @author tommy.hamblin
 *
 */
public class DataInsertScript {

	public static void insertData(final Product product)
	{
		try
		{
			// Generate new unique Id's
			final IDGenerator generator = IDGenerator.getInstance();
			final Integer productID = generator.getNewUniqueID(Table.PRODUCT);

			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final Statement stmt = conn.createStatement();
			stmt.executeQuery(DatabaseConstants.USE_DATABASE);

			// Builds the Insert script query
			Integer brandID = BrandsQuery.getBrandID(product.getBrand());
			// Checks to see if a brand exists before creating one
			if (brandID == -1) {
				brandID = generator.getNewUniqueID(Table.BRAND);
				final String brandInsert = DatabaseConstants.BRAND_TABLE_INSERTS + brandID + DatabaseConstants.COMMA + DatabaseConstants.APOSTROPHE + product.getBrand() + DatabaseConstants.APOSTROPHE + DatabaseConstants.CLOSE;
				stmt.executeUpdate(brandInsert);
			}

			final String productInsert = DatabaseConstants.PRODUCT_TABLE_INSERTS  + productID + DatabaseConstants.COMMA + DatabaseConstants.APOSTROPHE + product.getProductName() + DatabaseConstants.APOSTROPHE + DatabaseConstants.COMMA + product.getProductPrice() + DatabaseConstants.COMMA + brandID + DatabaseConstants.CLOSE;
			stmt.executeUpdate(productInsert);

			// Iterates through the images in an arraylist to add the to the products
			final ArrayList<String> images = product.getImagePaths();
			for (final String image : images)
			{
				final Integer imageID = generator.getNewUniqueID(Table.IMAGE);
				final String imageInsert = DatabaseConstants.IMAGE_TABLE_INSERTS  + imageID + DatabaseConstants.COMMA + DatabaseConstants.APOSTROPHE + image + DatabaseConstants.APOSTROPHE + DatabaseConstants.COMMA + productID + DatabaseConstants.CLOSE;
				stmt.executeUpdate(imageInsert);
			}

			// Iterates through the keywords in an arraylist to add the to the products
			final ArrayList<String> keywords = product.getKeywords();
			for(final String keyword : keywords)
			{
				Integer keywordID = KeywordsQuery.getKeywordID(keyword);

				if (keywordID == -1) {
					keywordID = generator.getNewUniqueID(Table.KEYWORD);
					final String keywordInsert = DatabaseConstants.KEYWORD_TABLE_INSERTS + keywordID + DatabaseConstants.COMMA + DatabaseConstants.APOSTROPHE + keyword + DatabaseConstants.APOSTROPHE + DatabaseConstants.CLOSE;
					stmt.executeUpdate(keywordInsert);
				}

				final String productKeywordInsert = DatabaseConstants.PRODUCT_KEYWORD_INSERTS  + productID + DatabaseConstants.COMMA + keywordID + DatabaseConstants.CLOSE;
				stmt.executeUpdate(productKeywordInsert);
			}

			// Closes the connection with the database
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}
	}

}

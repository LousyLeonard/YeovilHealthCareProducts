package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
			IDGenerator generator = IDGenerator.getInstance();
			// Must only call me once per entry! if a product gets added in between calls I'll change! 
			// (for ex lines 34 and 36)
			Integer productID = generator.getNewUniqueID(Table.PRODUCT);
			
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);

			// Builds the Insert script query
			/** okay so brand is funny, you'll need to check whether it exists before creating a new one! */
			final String brandInsert = DatabaseConstants.BRAND_TABLE_INSERTS  + product.getBrand() + DatabaseConstants.CLOSE;
			final String productInsert = DatabaseConstants.PRODUCT_TABLE_INSERTS  + product.getProductName() + DatabaseConstants.COMMA + product.getProductPrice() + DatabaseConstants.COMMA + (IDGenerator.getInstance().getNewUniqueID(Table.BRAND)) + DatabaseConstants.CLOSE;
			/** TODO although we've said one image for now that could change, iterate over the array! new entry for each*/
			final String imageInsert = DatabaseConstants.IMAGE_TABLE_INSERTS  + product.getImagePaths() + DatabaseConstants.COMMA + (IDGenerator.getInstance().getNewUniqueID(Table.PRODUCT)) + DatabaseConstants.CLOSE;
			/** TODO keywords wont work like this. You need a new keyword entry for each keyword, iterate over the array!*/
			final String keywordInsert = DatabaseConstants.KEYWORD_TABLE_INSERTS  + product.getKeywords() + DatabaseConstants.CLOSE;
			final String productKeywordInsert = DatabaseConstants.PRODUCT_KEYWORD_INSERTS  + (IDGenerator.getInstance().getNewUniqueID(Table.PRODUCT)) + DatabaseConstants.COMMA + (IDGenerator.getInstance().getNewUniqueID(Table.KEYWORD)) + DatabaseConstants.CLOSE;

			final String query = DatabaseConstants.USE_DATABASE + brandInsert + productInsert + imageInsert + keywordInsert + productKeywordInsert;
			final Statement stmt = conn.createStatement();
			//Executing the query on the database
			stmt.executeQuery(query);
			// Closes the connection with the database
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}
	}

}

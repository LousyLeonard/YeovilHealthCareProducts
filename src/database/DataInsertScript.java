package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import core.Product;

/**
 * @author tommy.hamblin
 *
 */
public class DataInsertScript {

	/** Select statement to find the max ID in the Brand table. */
	private static final String BRAND_ID_MAX = "SELECT MAX(Brand_ID) FROM Brand";

	/** Insert statement for the Brand table. */
	private static final String BRAND_TABLE_INSERTS = "INSERT INTO Brand(Brand_Name) VALUES (";

	/** Constant for the Insert statement close segment. */
	private static final String CLOSE = "); ";

	/** Constant for a comma symbol. */
	private static final String COMMA = ", ";

	/** Insert statement for the Image table. */
	private static final String IMAGE_TABLE_INSERTS = "INSERT INTO Image (Image_Filepath, Product_ID) VALUES (";

	/** Select statement to find the max ID in the Keyword table. */
	private static final String KEYWORD_ID_MAX = "SELECT MAX(Keyword_ID) FROM Keyword";

	/** Insert statement for the Keyword table. */
	private static final String KEYWORD_TABLE_INSERTS = "INSERT INTO Keyword (Keyword_Text) VALUES (";

	/** Select statement to find the max ID in the Product table. */
	private static final String PRODUCT_ID_MAX = "SELECT MAX(Product_ID) FROM Product";

	/** Insert statement for the Product-Keyword table. */
	private static final String PRODUCT_KEYWORD_INSERTS = "INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (";

	/** Insert statement for the Product table. */
	private static final String PRODUCT_TABLE_INSERTS = "INSERT INTO Product(Product_Name, Product_Price, Brand_ID) VALUES (";

	/** Constant to call the database that is to be queried. */
	private static final String USE_DATABASE = "USE YeovilHealthcare; ";


	public static void insertData(final Product product)
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/YeovilHealthcare", "root", "password");

			// Builds the Insert script query
			final String brandInsert = BRAND_TABLE_INSERTS  + product.getBrand() + CLOSE;
			final String productInsert = PRODUCT_TABLE_INSERTS  + product.getProductName() + COMMA + product.getProductPrice() + COMMA + BRAND_ID_MAX + CLOSE;
			final String imageInsert = IMAGE_TABLE_INSERTS  + product.getImagePaths() + COMMA + PRODUCT_ID_MAX + CLOSE;
			final String keywordInsert = KEYWORD_TABLE_INSERTS  + product.getKeywords() + CLOSE;
			final String productKeywordInsert = PRODUCT_KEYWORD_INSERTS  + PRODUCT_ID_MAX + COMMA + KEYWORD_ID_MAX + CLOSE;

			final String query = USE_DATABASE + brandInsert + productInsert + imageInsert + keywordInsert + productKeywordInsert;
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

package database;

public abstract class DatabaseConstants {

	/** Constant for the Insert statement close segment. */
	public static final String CLOSE = "); ";

	/** Constant for a comma symbol. */
	public static final String COMMA = ", ";

	/** Constant for the database connection. */
	public static final String DATABASE_CONNECTION_CONSTANT = "jdbc:mysql://localhost/YeovilHealthcare";

	/** Constant for the database password. */
	public static final String DATABASE_PASSWORD = "password";

	/** Constant for the database username. */
	public static final String DATABASE_USERNAME = "root";

	/** Constant for the Image Filepath. */
	public static final String IMAGE_FILEPATH = "Image_Filepath";

	/** Constant for the JDBC Driver. */
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/** Constant to call the database that is to be queried. */
	public static final String USE_DATABASE = "USE YeovilHealthcare; ";
	
	/** Select statement to find the max ID in the Product table. */
	public static final String GENERIC_MAX_ID_QUERY = "SELECT MAX(#primaryidcolumn) as maxid FROM #table";
	
	/** Select statement to find the max ID in the Product table. */
	public static final String PRODUCT_PRIMARY_ID = "Product_ID";
	public static final String PRODUCT_TABLE = "product";
	public static final String PRODUCT_NAME = "Product_Name";
	public static final String PRODUCT_PRICE = "Product_Price";
	
	/** Select statement to find the max ID in the Product table. */
	public static final String BRAND_PRIMARY_ID = "Brand_ID";
	public static final String BRAND_TABLE = "brand";
	
	/** Select statement to find the max ID in the Product table. */
	public static final String KEYWORD_PRIMARY_ID = "Keyword_ID";
	public static final String KEYWORD_TABLE = "keyword";
	
	/** Select statement to find the max ID in the Product table. */
	public static final String IMAGES_PRIMARY_ID = "Images_ID";
	public static final String IMAGES_TABLE = "images";


}

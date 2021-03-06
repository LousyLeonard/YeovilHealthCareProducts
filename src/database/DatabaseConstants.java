package database;

/**
 * @author tommy.hamblin
 *
 */
public abstract class DatabaseConstants {

	/** Constant for an apostrophe. */
	public static final String APOSTROPHE = "'";

	/** SQL inner join of the brand table on the product table. */
	public static final String BRAND_INNER_JOIN = "INNER JOIN Brand AS b ON b.Brand_ID = p.Brand_ID ";

	/** Constant for the brand name. */
	public static final String BRAND_NAME = "Brand_Name";

	/** Constant for the brand ID. */
	public static final String BRAND_PRIMARY_ID = "Brand_ID";

	/** Constant for the brand select statement. */
	public static final String BRAND_SELECT_STATEMENT = "SELECT b.Brand_Name FROM YeovilHealthcare.Brand AS b";

	/** Constant for the brand table. */
	public static final String BRAND_TABLE = "Brand";

	/** Insert statement for the Brand table. */
	public static final String BRAND_TABLE_INSERTS = "INSERT INTO Brand(Brand_ID, Brand_Name) VALUES (";

	/** Selects 10 brands. */
	public static final String BRAND_TOP_10 = "SELECT b.Brand_Name, b.Brand_ID, count(p.Brand_ID) AS count_product FROM Brand AS b INNER JOIN Product AS p on b.Brand_ID = p.Brand_ID GROUP BY b.Brand_Name ORDER BY count_product DESC limit 10";

	/** Constant for the SQL where clause for brand name. */
	public static final String BRAND_WHERE_CLAUSE = "WHERE b.Brand_Name = '?';";

	/** Constant for the Insert statement close segment. */
	public static final String CLOSE = "); ";

	/** Constant for a comma symbol. */
	public static final String COMMA = ", ";

	/** Constant for brand create table script. */
	public static final String CREATE_BRAND_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Brand (Brand_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Brand_Name CHAR(100)); ";

	/** Constant for create database script. */
	public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS YeovilHealthcare DEFAULT CHARACTER SET utf8; ";

	/** Constant for image create table script. */
	public static final String CREATE_IMAGE_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Image (Image_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Image_Filepath CHAR(255), Product_ID INT, FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID)); ";

	/** Constant for keyword create table script. */
	public static final String CREATE_KEYWORD_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Keyword (Keyword_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Keyword_Text CHAR(100)); ";

	/** Constant for product_keyword create table script. */
	public static final String CREATE_PRODUCT_KEYWORD_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Product_Keyword (Product_ID INT, Keyword_ID INT, PRIMARY KEY(Product_ID, Keyword_ID), FOREIGN KEY (Product_ID) REFERENCES Product(Product_ID), FOREIGN KEY (Keyword_ID) REFERENCES Keyword(Keyword_ID));";

	/** Constant for product create table script. */
	public static final String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Product (Product_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Product_Name CHAR(255), Product_Price DECIMAL(10,2), Brand_ID INT, FOREIGN KEY(Brand_ID) REFERENCES Brand(Brand_ID)); ";

	/** Constant for the database connection. */
	public static final String DATABASE_CONNECTION = "jdbc:mysql://localhost/YeovilHealthcare";

	/** Constant for the database password. */
	public static final String DATABASE_PASSWORD = "password";

	/** Constant for the database username. */
	public static final String DATABASE_USERNAME = "root";

	/** Constant for drop brand table script. */
	public static final String DROP_BRAND_TABLE = "DROP TABLE IF EXISTS YeovilHealthcare.Brand; ";

	/** Constant for drop image table script. */
	public static final String DROP_IMAGE_TABLE = "DROP TABLE IF EXISTS YeovilHealthcare.Image; ";

	/** Constant for drop keyword table script. */
	public static final String DROP_KEYWORD_TABLE = "DROP TABLE IF EXISTS YeovilHealthcare.Keyword; ";

	/** Constant for drop product keyword table script. */
	public static final String DROP_PRODUCT_KEYWORD_TABLE = "DROP TABLE IF EXISTS YeovilHealthcare.Product_Keyword; ";

	/** Constant for drop product table script. */
	public static final String DROP_PRODUCT_TABLE = "DROP TABLE IF EXISTS YeovilHealthcare.Product; ";

	/** Select statement to find the max ID in the Product table. */
	public static final String GENERIC_MAX_ID_QUERY = "SELECT MAX(#primaryidcolumn) as maxid FROM #table";

	/** Constant for the Image Filepath. */
	public static final String IMAGE_FILEPATH = "Image_Filepath";

	/** SQL inner join of the image table on the product table. */
	public static final String IMAGE_INNER_JOIN = "INNER JOIN Image AS i ON i.Product_ID = p.Product_ID ";

	/** Insert statement for the Image table. */
	public static final String IMAGE_TABLE_INSERTS = "INSERT INTO Image (Image_ID, Image_Filepath, Product_ID) VALUES (";

	/** Constant for the images ID. */
	public static final String IMAGES_PRIMARY_ID = "Image_ID";

	/** Constant for the product table. */
	public static final String IMAGES_TABLE = "Image";

	/** Constant for the JDBC Driver. */
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/** SQL inner join of the keyword table on the product_keyword table. */
	public static final String KEYWORD_LEFT_JOIN = "LEFT JOIN Keyword AS k ON k.Keyword_ID = pk.Keyword_ID ";

	/** Constant for the keyword ID. */
	public static final String KEYWORD_PRIMARY_ID = "Keyword_ID";

	/** Constant for the product table. */
	public static final String KEYWORD_TABLE = "Keyword";

	/** Insert statement for the Keyword table. */
	public static final String KEYWORD_TABLE_INSERTS = "INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (";

	/** Constant for keyword text. */
	public static final String KEYWORD_TEXT = "Keyword_Text";

	/** Constant for the SQL where clause for product name. */
	public static final String KEYWORD_WHERE_CLAUSE = "WHERE p.Product_Name = '?' OR b.Brand_Name = '?' OR k.Keyword_Text = '?';";

	public static final String TOTAL_NUMBER_OF_PAGES = "SELECT COUNT(p.Product_ID) as Product_Count FROM YeovilHealthcare.Product AS p ";
	
	/** Constant for the SQL where clause for product name. */
	public static final String SEARCH_CLAUSE = "WHERE p.Product_Name IN(?) OR b.Brand_Name IN(?) OR k.Keyword_Text IN(?)";

	/** Insert statement for the Product-Keyword table. */
	public static final String PRODUCT_KEYWORD_INSERTS = "INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (";

	/** SQL left join of the product_keyword table on the product table. */
	public static final String PRODUCT_KEYWORD_LEFT_JOIN = "LEFT JOIN Product_Keyword AS pk ON pk.Product_ID = p.Product_ID ";

	/** Constant for the Product Name. */
	public static final String PRODUCT_COUNT = "Product_Count";
	
	/** Constant for the Product Name. */
	public static final String PRODUCT_NAME = "Product_Name";

	/** Constant for the Product Price. */
	public static final String PRODUCT_PRICE = "Product_Price";

	/** Constant for the product ID. */
	public static final String PRODUCT_PRIMARY_ID = "Product_ID";

	/** Constant for the product select statement. */
	public static final String PRODUCT_SELECT_STATEMENT = "SELECT p.Product_Name, b.Brand_Name, p.Product_Price, i.Image_Filepath FROM YeovilHealthcare.Product AS p ";

	/** Constant for the product table. */
	public static final String PRODUCT_TABLE = "Product";

	/** Insert statement for the Product table. */
	public static final String PRODUCT_TABLE_INSERTS = "INSERT INTO Product(Product_ID, Product_Name, Product_Price, Brand_ID) VALUES (";

	/** Select statement for all brands. */
	public static final String SELECT_ALL_BRANDS = "SELECT * FROM BRAND AS b WHERE b.Brand_Name = ";

	/** Select statement for all keywords. */
	public static final String SELECT_ALL_KEYWORDS = "SELECT * FROM KEYWORD AS k WHERE k.Keyword_Text = ";

	/** Constant for closing statement. */
	public static final String SEMI_COLON = ";";

	/** Constant to call the database that is to be queried. */
	public static final String USE_DATABASE = "USE YeovilHealthcare; ";
	
	/** Constant to configure the limit and the offset. */
	public static final String LIMIT_AND_OFFSET = " LIMIT 20 OFFSET ";
}

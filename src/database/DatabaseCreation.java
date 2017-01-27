package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author tommy.hamblin
 *
 */
public class DatabaseCreation {

	/** Constant for brand create table script. */
	private static final String CREATE_BRAND_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Brand (Brand_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Brand_Name CHAR(100)); ";

	/** Constant for create database script. */
	private static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS YeovilHealthcare DEFAULT CHARACTER SET utf8; ";

	/** Constant for image create table script. */
	private static final String CREATE_IMAGE_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Image (Image_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Image_Filepath CHAR(255), Product_ID INT, FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID)); ";

	/** Constant for keyword create table script. */
	private static final String CREATE_KEYWORD_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Keyword (Keyword_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Keyword_Text CHAR(100)); ";

	/** Constant for product_keyword create table script. */
	private static final String CREATE_PRODUCT_KEYWORD_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Product_Keyword (Product_ID INT, Keyword_ID INT, PRIMARY KEY(Product_ID, Keyword_ID), FOREIGN KEY (Product_ID) REFERENCES Product(Product_ID), FOREIGN KEY (Keyword_ID) REFERENCES Keyword(Keyword_ID));";

	/** Constant for product create table script. */
	private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS YeovilHealthcare.Product (Product_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, Product_Name CHAR(255), Product_Price DECIMAL(10,2), Brand_ID INT, FOREIGN KEY(Brand_ID) REFERENCES Brand(Brand_ID)); ";

	/** Constant to call the database that is to be queried. */
	private static final String USE_DATABASE = "USE YeovilHealthcare; ";

	public static void createDatabase()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/YeovilHealthcare", "root", "password");

			// Builds the database and table creation script query
			final String query = CREATE_DATABASE + USE_DATABASE + CREATE_BRAND_TABLE + CREATE_PRODUCT_TABLE + CREATE_IMAGE_TABLE + CREATE_KEYWORD_TABLE + CREATE_PRODUCT_KEYWORD_TABLE;
			final Statement stmt = conn.createStatement();

			// Executes the query
			stmt.executeQuery(query);

			// Closes the database connection
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}
	}
}
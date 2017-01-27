package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import core.Product;

public class BrandQuery {

	private static final String SELECT_STATEMENT = "SELECT p.Product_Name, b.Brand_Name, p.Product_Price, i.Image_Filepath FROM YeovilHealthcare.Product AS p ";
	private static final String BRAND_INNER_JOIN = "INNER JOIN Brand AS b ON b.Brand_ID = p.Brand_ID ";
	private static final String IMAGE_INNER_JOIN = "INNER JOIN Image AS i ON i.Product_ID = p.Product_ID ";
	private static final String WHERE_CLAUSE = "WHERE b.Brand_Name = ";
	private static final String CLOSE = ";";

	public static ArrayList<Product> getAllProducts(final String searchField)
	{
		final ArrayList<Product> products = new ArrayList<Product>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/YeovilHealthcare", "root", "password");
			final String query = SELECT_STATEMENT + BRAND_INNER_JOIN + IMAGE_INNER_JOIN + WHERE_CLAUSE + searchField + CLOSE;
			final Statement stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				final Product product = new Product();
				product.setProductName(rs.getString("Product_Name"));
				product.setBrand(rs.getString("Brand_Name"));
				product.setProductPrice(Double.parseDouble(rs.getString("Product_Price")));
				product.addImagePath(rs.getString("Image_Filepath"));

				products.add(product);
			}

			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}

		return products;
	}
}

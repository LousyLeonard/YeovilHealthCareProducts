package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import core.Brand;

public class BrandsQuery {

	private static final String SELECT_STATEMENT = "SELECT b.Brand_Name FROM YeovilHealthcare.Brand AS b";

	public static ArrayList<Brand> getAllBrands(final String searchField)
	{
		final ArrayList<Brand> brands = new ArrayList<Brand>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/YeovilHealthcare", "root", "password");
			final String query = SELECT_STATEMENT;
			final Statement stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				final Brand brand = new Brand();
				brand.setBrand(rs.getString("Brand_Name"));
				brands.add(brand);
			}

			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}

		return brands;
	}
}

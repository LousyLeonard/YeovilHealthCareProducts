package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDGenerator {

	public enum Table {
		PRODUCT, BRAND, KEYWORD, IMAGE;
	}

	private static IDGenerator instance;

	private IDGenerator () {

	}

	public static IDGenerator getInstance() {
		if (instance == null) {
			instance = new IDGenerator();
		}
		return instance;
	}

	public Integer getNewUniqueID(final Table table) {
		Integer result = null;

		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION,
					DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final String query = this.generateSQLQuery(table);
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				result = rs.getInt("maxid");
			}

			conn.close();

			//Increment the result
			result++;

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String generateSQLQuery(final Table table) {
		String searchQuery = "";
		switch (table) {
		case PRODUCT:
			searchQuery = DatabaseConstants.GENERIC_MAX_ID_QUERY.replace("#primaryidcolumn",
					DatabaseConstants.PRODUCT_PRIMARY_ID);
			searchQuery = searchQuery.replace("#table", DatabaseConstants.PRODUCT_TABLE);
			break;
		case BRAND:
			searchQuery = DatabaseConstants.GENERIC_MAX_ID_QUERY.replace("#primaryidcolumn",
					DatabaseConstants.BRAND_PRIMARY_ID);
			searchQuery = searchQuery.replace("#table", DatabaseConstants.BRAND_TABLE);
			break;
		case KEYWORD:
			searchQuery = DatabaseConstants.GENERIC_MAX_ID_QUERY.replace("#primaryidcolumn",
					DatabaseConstants.KEYWORD_PRIMARY_ID);
			searchQuery = searchQuery.replace("#table", DatabaseConstants.KEYWORD_TABLE);
			break;
		case IMAGE:
			searchQuery = DatabaseConstants.GENERIC_MAX_ID_QUERY.replace("#primaryidcolumn",
					DatabaseConstants.IMAGES_PRIMARY_ID);
			searchQuery = searchQuery.replace("#table", DatabaseConstants.IMAGES_TABLE);
			break;
		default:
			System.out.println("Trying to generate sql query for unknown table");
			break;
		}

		return searchQuery;
	}

	public static void main(final String argv[]) {
		final IDGenerator generator = IDGenerator.getInstance();
		final Integer i = generator.getNewUniqueID(Table.PRODUCT);
		System.out.println(i);
	}
}

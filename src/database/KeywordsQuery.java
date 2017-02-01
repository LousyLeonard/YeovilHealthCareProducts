package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import core.Keyword;

/**
 * @author tommy.hamblin
 *
 */
public class KeywordsQuery {

	// Returns a unique ID for a keyword
	public static Integer getKeywordID(final String keywordText)
	{
		final String query = DatabaseConstants.SELECT_ALL_KEYWORDS + DatabaseConstants.APOSTROPHE + keywordText + DatabaseConstants.APOSTROPHE + DatabaseConstants.SEMI_COLON;

		// Checks to see if a keyword exists
		final ArrayList<Keyword> keywords = doQuery(query);
		if (keywords.isEmpty()) {
			return -1;
		}

		return keywords.get(0).getKeywordID();
	}

	private static ArrayList<Keyword> doQuery(final String query)
	{
		final ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		try
		{
			Class.forName(DatabaseConstants.JDBC_DRIVER);

			// Creates a database connection with the Yeovilhealthcare database
			// Username of "root" and password of "password"
			final Connection conn = DriverManager.getConnection(DatabaseConstants.DATABASE_CONNECTION, DatabaseConstants.DATABASE_USERNAME, DatabaseConstants.DATABASE_PASSWORD);
			final Statement stmt = conn.createStatement();

			// Executes the select query
			final ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				// Creates a new brand object with the result set output
				final Keyword keyword = new Keyword();
				keyword.setKeywordText(rs.getString(DatabaseConstants.KEYWORD_TEXT));

				// Adds the brand object to the brands arraylist
				keywords.add(keyword);
			}

			// Closes the database connection
			conn.close();
		}
		catch (final Exception e)
		{
			System.err.println(e);
		}

		return keywords;
	}

}

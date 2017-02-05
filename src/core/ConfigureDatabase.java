package core;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import database.DatabaseCreation;
import database.DatabaseRemoval;
/**
 * @author tommy.hamblin
 *
 */
public class ConfigureDatabase {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		try
		{
			// Removes all database tables
			DatabaseRemoval.dropDatabase();
		}
		catch (final MySQLSyntaxErrorException e)
		{
			e.printStackTrace();
		}

		try
		{
			// Creates new database tables
			DatabaseCreation.createDatabase();
		}
		catch  (final MySQLSyntaxErrorException e)
		{
			e.printStackTrace();
		}
	}
}

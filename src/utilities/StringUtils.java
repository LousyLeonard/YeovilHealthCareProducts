/**
 * 
 */
package utilities;

import java.util.ArrayList;

/**
 * @author Lawrence
 *
 */
public abstract class StringUtils {

	public static ArrayList<String> getWordsInField(String field) {
		ArrayList<String> results = new ArrayList<String>();
		
		String[] words = field.split(" ");
		for (int i = 0; i < words.length; ++i) {
			if (!words[i].isEmpty()) {
				results.add(words[i]);
			}
		}
		
		return results;
	}
}

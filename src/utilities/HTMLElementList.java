package utilities;

import java.util.ArrayList;

/**
 * Extented ArrayList class to override the default toString() operation
 * it returns the elements stringed to the end of each other as opposed 
 * to formatting with [], i.e. [ E , E , E]
 * 
 * @author Lawrence
 *
 * @param <E> - Type of the arraylist
 */
public class HTMLElementList<E> extends ArrayList<E> {

	/**
	 * Appease the gods of serialisation.
	 */
	private static final long serialVersionUID = 7999426330747860931L;

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (E element : this) {
			stringBuilder.append(element);
		}
		return stringBuilder.toString();
	}
	
}

package utilities;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Extented ArrayList class to override the default toString() operation
 * it returns the elements stringed to the end of each other as opposed 
 * to formatting with [], i.e. [ E , E , E]
 * 
 * @author Lawrence
 *
 * @param <E> - Type of the arraylist
 */
public class OuterBracketlessList<E> extends ArrayList<E> {

	/**
	 * Appease the gods of serialisation.
	 */
	private static final long serialVersionUID = 7999426330747860931L;
	
	public OuterBracketlessList() {
		super();
	}
	
	public OuterBracketlessList(Collection<E> col) {
		super();
		
		for (E element : col) {
			this.add(element);
		}
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (E element : this) {
			stringBuilder.append(element);
		}
		return stringBuilder.toString();
	}
	
}

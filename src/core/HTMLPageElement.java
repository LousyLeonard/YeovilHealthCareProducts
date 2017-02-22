/**
 * 
 */
package core;

/**
 * @author Lawrence
 *
 */
public class HTMLPageElement {
	private final static String PAGE_OPEN = "<ul class='pagination'><li><a onclick='pageNo--;getProducts();getPages();'>&laquo;</a></li>";
	private final static String PAGE_CLOSE = "<li><a onclick='pageNo++;getProducts();getPages();'>&raquo;</a></li></ul>";			
	private final static Integer MAX_NUMBER_OF_ELEMENTS = Integer.valueOf(8);

	private StringBuilder body;
	
	public HTMLPageElement(Integer offset, Integer totalPages) {
		body = new StringBuilder();
		
		body.append(PAGE_OPEN);
		
		// Do this as numbers calculate the lowest available and then count up like 9 stopping at max
		Integer lowestPage = offset;
		if (lowestPage - (MAX_NUMBER_OF_ELEMENTS / 2) <= 0) {
			lowestPage = 1;
		} else {
			lowestPage = offset - (MAX_NUMBER_OF_ELEMENTS / 2);
		}
				
		for(int i = 0; i < MAX_NUMBER_OF_ELEMENTS; ++i) {
			if (lowestPage + i <= totalPages) {
				body.append(getPageNumberElement(lowestPage + i));
			}
		}
		
		body.append(PAGE_CLOSE);

	}
	
	private String getPageNumberElement(Integer number) {
		return "<li><a onclick='pageNo=" + number + ";getProducts();getPages();'>" + number + "</a></li>";
	}
	
	public String toString() {
		return body.toString();
	}
}
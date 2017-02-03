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
		
		int upperOverflow = 0;
		int lowerOverflow = 0;
		for (int i = 0; i < 9; i++) {
			if (offset + i - 5 > 0 && offset + i - 5 < totalPages) {
				body.append(getPageNumberElement(offset + i - 5));
			} else if (offset + i - 5 <= 0) {
				upperOverflow++;
			} else if (offset + i - 5 >= totalPages) {
				lowerOverflow++;
			}
		}
		
		for (int i = 0; i < upperOverflow; i++) {
			if (offset + i + 4 < totalPages)
				body.append(getPageNumberElement(offset + i + 5));
		}
		
		for (int i = 0; i < lowerOverflow; i++) {
			if (offset - i - 4 > 0)
				body.append(getPageNumberElement(offset - i - 5));
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
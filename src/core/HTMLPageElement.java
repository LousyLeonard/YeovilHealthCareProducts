/**
 * 
 */
package core;

/**
 * @author Lawrence
 *
 */
public class HTMLPageElement {
	private final static String PAGE_OPEN = "<div align='center' id='pagination'><ul class='pagination'>";
	private final static String PAGE_FIRST = "<li><a onclick='pageNo=1;getProducts();getPages();'>&laquo;&laquo;</a></li>";
	private final static String PAGE_PREV = "<li><a onclick='pageNo--;getProducts();getPages();'>&laquo;</a></li>";
	private final static String PAGE_NEXT = "<li><a onclick='pageNo++;getProducts();getPages();'>&raquo;</a></li>";
	private final static String PAGE_LAST = "<li><a onclick='pageNo=#;getProducts();getPages();'>&raquo;&raquo;</a></li>";			
	private final static String PAGE_CLOSE = "</ul></div>";			

	private final static Integer MAX_NUMBER_OF_ELEMENTS = Integer.valueOf(8);

	private StringBuilder body;
	
	public HTMLPageElement(Integer offset, Integer totalPages) {
		body = new StringBuilder();
		
		String pageLast = PAGE_LAST.replace("#", Integer.toString(totalPages));
		
		body.append(PAGE_OPEN);
		body.append(PAGE_FIRST);
		body.append(PAGE_PREV);

		// Do this as numbers calculate the lowest available and then count up like 9 stopping at max
		Integer lowestPage = offset;
		if (lowestPage - (MAX_NUMBER_OF_ELEMENTS / 2) <= 0) {
			lowestPage = 1;
		} else {
			lowestPage = offset - (MAX_NUMBER_OF_ELEMENTS / 2);
		}
				
		for(int i = 0; i < MAX_NUMBER_OF_ELEMENTS; ++i) {
			if (lowestPage + i <= totalPages) {
				if (offset == lowestPage + i) {
					body.append(getPageNumberActiveElement(lowestPage + i));
				} else {
					body.append(getPageNumberElement(lowestPage + i));
				}
			}
		}
		
		body.append(PAGE_NEXT);
		body.append(pageLast);
		body.append(PAGE_CLOSE);

	}
	
	private String getPageNumberElement(Integer number) {
		return "<li><a onclick='pageNo=" + number + ";getProducts();getPages();'>" + number + "</a></li>";
	}
	
	private String getPageNumberActiveElement(Integer number) {
		return "<li><a onclick='pageNo=" + number + ";getProducts();getPages();' class='active'><u>" + number + "</u></a></li>";
	}
	
	public String toString() {
		return body.toString();
	}
}
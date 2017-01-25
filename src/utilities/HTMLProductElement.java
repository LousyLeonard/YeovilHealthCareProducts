package utilities;

import java.util.ArrayList;

public class HTMLProductElement {
	public enum Tags {
		IMAGE, HEADING, PARAGRAPH
	}
	
	private static final String CONTAINER_START = "<div class=\'col-sm-4\'><div class=\'product-image-wrapper\'><div class=\'single-products\'><div class=\'productinfo text-center\'>";		
	private static final String CONTAINER_END = "<a href=\'#\' class=\'btn btn-default add-to-cart\'><i class=\'fa fa-shopping-cart\'></i>Add to cart</a></div>";		
	private static final String OVERLAY_START = "<div class=\'product-overlay\'><div class=\'overlay-content\'>";
	private static final String OVERLAY_END = "<a href=\'#\' class=\'btn btn-default add-to-cart\'><i class=\'fa fa-shopping-cart\'></i>Add to cart</a></div></div></div></div></div>";
			
	private StringBuilder BODY;

	public HTMLProductElement(ArrayList<Pair<Tags, String>> container, ArrayList<Pair<Tags, String>> overlay) {		
		BODY = new StringBuilder();
		BODY.append(CONTAINER_START);
		
		for (Pair<Tags, String> element : container ) {
			BODY.append(getElementString(element));
		}
		
		BODY.append(CONTAINER_END);
		BODY.append(OVERLAY_START);
		
		for (Pair<Tags, String> element : overlay ) {
			BODY.append(getElementString(element));
		}
		
		BODY.append(OVERLAY_END);
	}
	
	private String getElementString(Pair<Tags, String> element) {
		
		switch(element.getFirst()) {
		case HEADING:
			return getHeadingElement(element.getSecond());
		case IMAGE:
			return getImageElement(element.getSecond());
		case PARAGRAPH:
			return getParagraphElement(element.getSecond());
		default:
			break;
		}
		return null;
	}

	private String getImageElement(String path) {
		return "<img src=\'" + path + "\' alt=\'\' />";
	}
	
	private String getHeadingElement(String content) {
		return "<h2>" + content + "</h2>";
	}

	private String getParagraphElement(String content) {
		return "<p>" + content + "<p>";
	}
	
	public String toString(){
		return BODY.toString();
	}
}

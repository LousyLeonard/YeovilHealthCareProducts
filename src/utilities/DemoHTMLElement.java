package utilities;

import java.util.ArrayList;

import utilities.HTMLProductElement.Tags;

public abstract class DemoHTMLElement {

	public static HTMLProductElement getDemoHTMLElement() {
		ArrayList<Pair<Tags, String>> container = new ArrayList<Pair<Tags, String>>();
		ArrayList<Pair<Tags, String>> overlay = new ArrayList<Pair<Tags, String>>();

		container.add(new Pair<Tags, String>(Tags.IMAGE, "images/home/product1.jpg"));
		container.add(new Pair<Tags, String>(Tags.HEADING, "&pound;10"));
		container.add(new Pair<Tags, String>(Tags.PARAGRAPH, "Super cool thing"));

		overlay.add(new Pair<Tags, String>(Tags.HEADING, "£10"));
		overlay.add(new Pair<Tags, String>(Tags.PARAGRAPH, "Super cool thing"));

		HTMLProductElement htmlElement = new HTMLProductElement(container, overlay);
		
		return htmlElement;
	}
}

package core;

import java.util.ArrayList;

import core.HTMLProductElement.Tags;
import utilities.Pair;

public abstract class HTMLProductFactory {
	
	public static HTMLProductElement getHTMLFromProduct(Product product) {
		ArrayList<Pair<Tags, String>> container = new ArrayList<Pair<Tags, String>>();
		ArrayList<Pair<Tags, String>> overlay = new ArrayList<Pair<Tags, String>>();

		for (String path : product.getImagePaths()) {
			container.add(new Pair<Tags, String>(Tags.IMAGE, path));
		}

		container.add(new Pair<Tags, String>(Tags.HEADING, "&pound;" + product.getProductPrice()));
		container.add(new Pair<Tags, String>(Tags.PARAGRAPH, product.getProductName()));

		overlay.add(new Pair<Tags, String>(Tags.HEADING, "&pound;" + product.getProductPrice()));
		overlay.add(new Pair<Tags, String>(Tags.PARAGRAPH, product.getProductName()));

		HTMLProductElement htmlElement = new HTMLProductElement(container, overlay);
		
		return htmlElement;
	}
}

package xml;

import java.util.EmptyStackException;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xml.generated.BRAND;
import xml.generated.BRANDS;
import xml.generated.IMAGES;
import xml.generated.ImageFilepath;
import xml.generated.KEYWORDS;
import xml.generated.KeywordText;
import xml.generated.ObjectFactory;
import xml.generated.PRODUCT;

public class BrandsHandler extends DefaultHandler {

	public static ObjectFactory objectFactory = new ObjectFactory();

	boolean Product_Name, Product_Price, Brand_Name, Keyword_Text, Image_Filepath;
	boolean invalid;

	BRANDS brands;

	Stack<Object> current;

	public BrandsHandler() {
		super();
		current = new Stack<Object>();
		brands = objectFactory.createBRANDS();

		Product_Name = false;
		Product_Price = false;
		Brand_Name = false;
		Keyword_Text = false;
		Image_Filepath = false;

		invalid = false;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (!invalid) {
			try {

				if (qName.equalsIgnoreCase("BRANDS")) {
					brands = objectFactory.createBRANDS();
					current.push(brands);
				} else if (qName.equalsIgnoreCase("BRAND")) {
					BRAND brand = objectFactory.createBRAND();
					brands.getBRAND().add(brand);
					current.push(brand);
				} else if (qName.equalsIgnoreCase("PRODUCT")) {
					PRODUCT product = objectFactory.createPRODUCT();
					((BRAND) current.peek()).getPRODUCT().add(product);
					current.push(product);
				} else if (qName.equalsIgnoreCase("IMAGES")) {
					IMAGES image = objectFactory.createIMAGES();
					((PRODUCT) current.peek()).setIMAGES(image);
					current.push(image);
				} else if (qName.equalsIgnoreCase("KEYWORDS")) {
					KEYWORDS image = objectFactory.createKEYWORDS();
					((PRODUCT) current.peek()).setKEYWORDS(image);
					current.push(image);
				} else if (qName.equalsIgnoreCase("Product_Name")) {
					Product_Name = true;
				} else if (qName.equalsIgnoreCase("Product_Price")) {
					Product_Price = true;
				} else if (qName.equalsIgnoreCase("Brand_Name")) {
					Brand_Name = true;
				} else if (qName.equalsIgnoreCase("Keyword_Text")) {
					Keyword_Text = true;
				} else if (qName.equalsIgnoreCase("Image_Filepath")) {
					Image_Filepath = true;
				} else {
					invalid = true;
				}
			} catch (EmptyStackException e) {
				invalid = true;
			}
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (!invalid) {
			try {
		if (qName.equalsIgnoreCase("BRAND")) {
			current.pop();
		} else if (qName.equalsIgnoreCase("PRODUCT")) {
			current.pop();
		} else if (qName.equalsIgnoreCase("IMAGES")) {
			current.pop();
		} else if (qName.equalsIgnoreCase("KEYWORDS")) {
			current.pop();
		}
			} catch (EmptyStackException e) {
				invalid = true;
			}
		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (!invalid) {
			try {
				if (Product_Name) {
					((PRODUCT) current.peek()).setProductName(new String(ch, start, length));
				} else if (Product_Price) {
					((PRODUCT) current.peek()).setProductPrice(new String(ch, start, length));
				} else if (Brand_Name) {
					((BRAND) current.peek()).setBrandName(new String(ch, start, length));
				} else if (Keyword_Text) {
					KeywordText keywordText = new KeywordText();
					keywordText.setvalue(new String(ch, start, length));
					((KEYWORDS) current.peek()).getKeywordText().add(keywordText);
				} else if (Image_Filepath) {
					ImageFilepath imageFilepath = new ImageFilepath();
					imageFilepath.setvalue(new String(ch, start, length));
					((IMAGES) current.peek()).getImageFilepath().add(imageFilepath);
				}

				clearBooleans();
			} catch (EmptyStackException e) {
				invalid = true;
			}
		}
	}

	private void clearBooleans() {
		Product_Name = false;
		Product_Price = false;
		Brand_Name = false;
		Keyword_Text = false;
		Image_Filepath = false;
	}

	public BRANDS getBrands() {
		if (!invalid) {
			return brands;
		}
		return null;
	}

}

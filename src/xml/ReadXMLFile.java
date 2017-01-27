package xml;

import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xml.generated.*;

//xjc -dtd -d "C:\Users\Lawrence\git\YeovilHealthCareProducts\src" -p xml.generated "C:\Users\Lawrence\git\YeovilHealthCareProducts\Database.dtd"
public class ReadXMLFile {

	public static ObjectFactory objectFactory = new ObjectFactory();
	
   public static void main(String argv[]) {

    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
	
	DefaultHandler handler = new DefaultHandler() {

	boolean Product_Name = false;
	boolean Product_Price = false;
	boolean Brand_Name = false;
	boolean Keyword_Text = false;
	boolean Image_Filepath = false;
	
	BRAND brand;
	
	Stack<Object> current = new Stack<Object>();
	
	public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
		
		if (qName.equalsIgnoreCase("BRAND")) {
			brand = objectFactory.createBRAND();
			current.push(brand);
		}
		
		if (qName.equalsIgnoreCase("PRODUCT")) {
			PRODUCT product = objectFactory.createPRODUCT();
			brand.getPRODUCT().add(product);
			current.push(product);
		}
		
		if (qName.equalsIgnoreCase("IMAGES")) {
			IMAGES image = objectFactory.createIMAGES();
			((PRODUCT) current.peek()).setIMAGES(image);
			current.push(image);
		}

		if (qName.equalsIgnoreCase("KEYWORDS")) {
			KEYWORDS image = objectFactory.createKEYWORDS();
			((PRODUCT) current.peek()).setKEYWORDS(image);
			current.push(image);		
		}

		if (qName.equalsIgnoreCase("Product_Name")) {
			Product_Name = true;
		}

		if (qName.equalsIgnoreCase("Product_Price")) {
			Product_Price = true;
		}

		
		if (qName.equalsIgnoreCase("Brand_Name")) {
			Brand_Name = true;
		}
		
		if (qName.equalsIgnoreCase("Keyword_Text")) {
			Keyword_Text = true;
		}
		
		if (qName.equalsIgnoreCase("Image_Filepath")) {
			Image_Filepath = true;
		}

	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		if (qName.equalsIgnoreCase("PRODUCT")) {
			current.pop();		
		}
		
		if (qName.equalsIgnoreCase("IMAGES")) {
			current.pop();		
		}

		if (qName.equalsIgnoreCase("KEYWORDS")) {
			current.pop();		
		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (Product_Name) {
			System.out.println("Product_Name : " + new String(ch, start, length));
			((PRODUCT) current.peek()).setProductName(new String(ch, start, length));
		}

		if (Product_Price) {
			System.out.println("Product_Price : " + new String(ch, start, length));
			((PRODUCT) current.peek()).setProductPrice(new String(ch, start, length));
		}
		
		if (Brand_Name) {
			System.out.println("Brand_Name : " + new String(ch, start, length));
			((BRAND) current.peek()).setBrandName(new String(ch, start, length));
		}
		
		if (Keyword_Text) {
			System.out.println("Keyword_Text : " + new String(ch, start, length));
			KeywordText keywordText = new KeywordText();
			keywordText.setvalue(new String(ch, start, length));
			((KEYWORDS) current.peek()).getKeywordText().add(keywordText);
		}
		
		if (Image_Filepath) {
			System.out.println("Image_Filepath : " + new String(ch, start, length));
			ImageFilepath imageFilepath = new ImageFilepath();
			imageFilepath.setvalue(new String(ch, start, length));
			((IMAGES) current.peek()).getImageFilepath().add(imageFilepath);
		}

		clearBooleans();
	}
	
	private void clearBooleans() {
		Product_Name = false;
		Product_Price = false;
		Brand_Name = false;
		Keyword_Text = false;
		Image_Filepath = false;
	}

     };

       saxParser.parse("C:\\Users\\Lawrence\\git\\YeovilHealthCareProducts\\Database.xml", handler);

     } catch (Exception e) {
       e.printStackTrace();
     }

   }

}
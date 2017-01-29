package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import core.Product;
import utilities.XMLFileFilter;
import xml.generated.*;

//xjc -dtd -d "C:\Users\Lawrence\git\YeovilHealthCareProducts\src" -p xml.generated "C:\Users\Lawrence\git\YeovilHealthCareProducts\Database.dtd"
public class ReadXMLFiles {

	public static ObjectFactory objectFactory = new ObjectFactory();

	public static void main(String argv[]) {

		try {
			String inPath = "C:\\Users\\Lawrence\\git\\YeovilHealthCareProducts\\XMLInputScripts\\";
			// create new file
            File f = new File(inPath);

            // array of files and directory
            String[] paths = f.list(new XMLFileFilter());

            // for each name in the path array
            for (String path : paths) {
                // prints filename and directory name
                System.out.println(inPath + path);
                System.out.println(getProductsFromXML(inPath + path));
            }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static List<Product> getProductsFromXML(String folderPath) {
		List<Product> products = new ArrayList<Product>();
		
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			BrandsHandler handler = new BrandsHandler();
			saxParser.parse(folderPath, handler);
		
			if (handler.getBrands() != null) {
				products = ProductConverter.getProducts(handler.getBrands());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

}
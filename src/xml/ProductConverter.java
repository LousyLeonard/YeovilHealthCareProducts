package xml;

import java.util.ArrayList;
import java.util.List;

import core.Product;
import xml.generated.BRAND;
import xml.generated.BRANDS;
import xml.generated.IMAGES;
import xml.generated.ImageFilepath;
import xml.generated.KEYWORDS;
import xml.generated.KeywordText;
import xml.generated.PRODUCT;

public abstract class ProductConverter {

	public static List<Product> getProducts(BRANDS xmlBrands) {
		List<Product> results = new ArrayList<Product>();
		
		for (BRAND xmlBrand : xmlBrands.getBRAND()) {
			String brandName = xmlBrand.getBrandName();
			
			for (PRODUCT xmlProduct : xmlBrand.getPRODUCT()) {
				Product product = new Product();
				
				product.setBrand(brandName);
				product.setProductName(xmlProduct.getProductName());
				product.setProductPrice(Double.parseDouble(xmlProduct.getProductPrice()));
				
				IMAGES xmlImages = xmlProduct.getIMAGES();
				for (ImageFilepath xmlImage : xmlImages.getImageFilepath()) {
					product.addImagePath(xmlImage.getvalue());
				}
				
				KEYWORDS xmlKeywords = xmlProduct.getKEYWORDS();
				for (KeywordText xmlKeyword : xmlKeywords.getKeywordText()) {
					product.addKeyword(xmlKeyword.getvalue());
				}
				
				results.add(product);
			}
		}
		
		return results;
	}
}

package core;

import java.util.ArrayList;

public class Product {

	String brand;
	String productName;
	String productDescription;
	Double productPrice;
	ArrayList<String> keywords;
	ArrayList<String> imagePaths;
	
	public Product(String brand, String productName, String productDescription, 
			Double productPrice, ArrayList<String> keywords, ArrayList<String> imagePaths){
		this.brand = brand;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.keywords = keywords;
		this.imagePaths = imagePaths;
	}
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void addKeyword(String keyword) {
		this.keywords.add(keyword);
	}

	public ArrayList<String> getImagePaths() {
		return imagePaths;
	}

	public void addImagePath(String imagePath) {
		this.imagePaths.add(imagePath);
	}
	
}

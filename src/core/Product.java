package core;

import java.util.ArrayList;

public class Product {

	private String brand;
	private String productName;
	private Double productPrice;
	private final ArrayList<String> keywords;
	private final ArrayList<String> imagePaths;

	public Product() {
		this.keywords = new ArrayList<String>();
		this.imagePaths = new ArrayList<String>();
	}

	public Product(final String brand, final String productName, final String productDescription,
			final Double productPrice, final ArrayList<String> keywords, final ArrayList<String> imagePaths){
		this.brand = brand;
		this.productName = productName;
		this.productPrice = productPrice;
		this.keywords = keywords;
		this.imagePaths = imagePaths;
	}


	public String getBrand() {
		return this.brand;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(final String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(final Double productPrice) {
		this.productPrice = productPrice;
	}

	public ArrayList<String> getKeywords() {
		return this.keywords;
	}

	public void addKeyword(final String keyword) {
		this.keywords.add(keyword);
	}

	public ArrayList<String> getImagePaths() {
		return this.imagePaths;
	}

	public void addImagePath(final String imagePath) {
		this.imagePaths.add(imagePath);
	}

}

package core;

public class Brand {

	private String brand;
	private Integer brandID;

	public Brand() {
		this.brand = "";
		this.setBrandID(-1);
	}

	public Brand(final String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	/**
	 * @return the brandID
	 */
	public int getBrandID() {
		return this.brandID;
	}

	/**
	 * @param brandID the brandID to set
	 */
	public void setBrandID(final Integer brandID) {
		this.brandID = brandID;
	}

}

package core;

public class Image {

	private Integer imageID;
	private String imageFilepath;

	public Image() {
		this.setImageFilepath("");
		this.setImageID(-1);
	}

	public Image(final String image) {
		this.setImageFilepath(image);
	}

	/**
	 * @return the imageID
	 */
	public Integer getImageID() {
		return this.imageID;
	}

	/**
	 * @param keywordID the imageID to set
	 */
	public void setImageID(final Integer imageID) {
		this.imageID = imageID;
	}

	/**
	 * @return the imageFilepath
	 */
	public String getImageFilepath() {
		return this.imageFilepath;
	}

	/**
	 * @param imageText the imageFilepath to set
	 */
	public void setImageFilepath(final String imageFilepath) {
		this.imageFilepath = imageFilepath;
	}
	
}

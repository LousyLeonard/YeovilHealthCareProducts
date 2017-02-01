package core;

public class Keyword {

	private Integer keywordID;
	private String keywordText;

	public Keyword() {
		this.setKeywordText("");
		this.setKeywordID(-1);
	}

	public Keyword(final String keyword) {
		this.setKeywordText(keyword);
	}

	/**
	 * @return the keywordID
	 */
	public Integer getKeywordID() {
		return this.keywordID;
	}

	/**
	 * @param keywordID the keywordID to set
	 */
	public void setKeywordID(final Integer keywordID) {
		this.keywordID = keywordID;
	}

	/**
	 * @return the keywordText
	 */
	public String getKeywordText() {
		return this.keywordText;
	}

	/**
	 * @param keywordText the keywordText to set
	 */
	public void setKeywordText(final String keywordText) {
		this.keywordText = keywordText;
	}


}

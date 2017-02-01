package core;

public class Keyword {

	private String keyword;
	private Integer keywordName;

	public Keyword() {
		this.keyword = "";
		this.setKeywordName(-1);
	}

	public Keyword(final String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(final String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the keywordName
	 */
	public int getKeywordName() {
		return this.keywordName;
	}

	/**
	 * @param brandID the keywordName to set
	 */
	public void setKeywordName(final Integer keywordName) {
		this.keywordName = keywordName;
	}
	
}

package com.off.day5;

public class Novel extends Book{
	private String genre;
	
	public Novel() {}
	public Novel(String isbn, String title, String author, String publisher, int price, String desc, String genre) {
		super(isbn, title, author, publisher, price, desc);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(genre + "\t| ");
		return builder.toString();
	}
	/*
	 * @Override public String toString() { return "Novel [genre=" + genre +
	 * ", getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle() + ", getAuthor()="
	 * + getAuthor() + ", getPublisher()=" + getPublisher() + ", getPrice()=" +
	 * getPrice() + ", getDesc()=" + getDesc() + "]"; }
	 */
	
	
	

}

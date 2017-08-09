package com.java1234.model;

public class Borrow {

	private String peopleId;
	private String bookId;
	
	public Borrow(String peopleId, String bookId) {
		super();
		this.peopleId = peopleId;
		this.bookId = bookId;
	}
	public String getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
}

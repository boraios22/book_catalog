package com.itstep.model;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private float price;
	
	
	
	public Book(String iSBN, String title, String author, String publisher, int year, float price) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	/*
	 
CREATE TABLE `book_catalog`.`tbl_books` (
  `ISBN` VARCHAR(50) NOT NULL,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `publisher` VARCHAR(45) NULL,
  `year` INT NULL,
  `price` DECIMAL(30) NULL,
  PRIMARY KEY (`ISBN`));
  
	 */
	
}

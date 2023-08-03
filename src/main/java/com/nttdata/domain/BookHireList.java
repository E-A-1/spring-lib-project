package com.nttdata.domain;

import java.util.Date;

public class BookHireList {
	
	private int hireid;
	private String bookname;
	private int isbn;
	private String author;
	private String publisher;
	private String edition;
	private int price;
	private int quantity;
	private String hireDate;
	private String returnDate;
	private int bookid;
	private int studentid;
	
	public BookHireList(int hireid, String bookname, int isbn, String author, String publisher, String edition, int price,
			int quantity, String hireDate, String returnDate, int bookid, int studentid) {
		super();
		this.hireid = hireid;
		this.bookname = bookname;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.price = price;
		this.quantity = quantity;
		this.hireDate = hireDate;
		this.returnDate = returnDate;
		this.bookid = bookid;
		this.studentid = studentid;
		
		
	}
	
	public BookHireList() {
		// TODO Auto-generated constructor stub
	}

	public int getHireid() {
		return hireid;
	}
	public void setHireid(int hireid) {
		this.hireid = hireid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String string) {
		this.hireDate = string;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String string) {
		this.returnDate = string;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	@Override
	public String toString() {
		return "BookHire [hireid=" + hireid + ", bookname=" + bookname + ", isbn=" + isbn + ", author=" + author
				+ ", publisher=" + publisher + ", edition=" + edition + ", price=" + price + ", quantity=" + quantity
				+ ", hireDate=" + hireDate + ", returnDate=" + returnDate + ", bookid=" + bookid + ", studentid="
				+ studentid + "]";
	}
	
	
	

}

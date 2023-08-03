package com.nttdata.domain;

public class BookReuestList {
	
	private int studnetid;
	private int isbn;
	private String hiredate;
	private String bookname;
	private int reqid;
	
	public BookReuestList( int reqid,int studnetid, int isbn, String hiredate, String bookname) {
		super();
		this.studnetid = studnetid;
		this.isbn = isbn;
		this.hiredate = hiredate;
		this.bookname = bookname;
		this.reqid=reqid;
		
	}

	public int getReqid() {
		return reqid;
	}

	public void setReqid(int reqid) {
		this.reqid = reqid;
	}

	public int getStudnetid() {
		return studnetid;
	}

	public void setStudnetid(int studnetid) {
		this.studnetid = studnetid;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Override
	public String toString() {
		return "BookReuestList [studnetid=" + studnetid + ", isbn=" + isbn + ", hiredate=" + hiredate + ", bookname="
				+ bookname + ", reqid=" + reqid + "]";
	}

	
	
	

}

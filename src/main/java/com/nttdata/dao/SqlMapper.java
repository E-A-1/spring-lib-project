package com.nttdata.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.nttdata.domain.BookHireList;
import com.nttdata.domain.BookReuestList;

import com.nttdata.dbfw.ResultMapper;
import com.nttdata.domain.Admin;
import com.nttdata.domain.BookDetails;

import com.nttdata.domain.Student;

public class SqlMapper {

	public static final String FETCH_ADMIN = "select adminid,password from admin_info1 where adminid=?";
	public static final String ADD_USER = "insert into admin_info1 values(?,?)";
    

	public static final String FETCH_STUDENT = "select studentno,name,password,email from student where studentid=?";
	
	public static final String FETCH_BOOK = "select bookname,author,publisher,edition,price,quantity from bookdetails where isbn=?";
	
	public static final String ADD_STUDENT = "insert into student values(?,?,?,?,?,?)";
	public static final String ADD_BOOK = "insert into bookdetails values(?,?,?,?,?,?,?)";
	
	public static final String DELETE_BOOK = "delete from bookdetails where isbn=?";
	
	public static final String DELETE_STUDENT = "delete from student where studentid=?";
	
	public static final String UPDATE_PRICE = "UPDATE bookdetails set price=? where isbn=?";
	
	public static final String UPDATE_QUANTITY = "UPDATE bookdetails set quantity=? where isbn=?";
	
	public static final String FetchReq="select * from bookrequest where reqid=? ";
	
	public static final String FETCHHIRE="select * from HIRE";
			
	public static final String FETCHHIREIDSTUID=
			"select * from HIRE where hireid=? and studentid=?" ;
	
	public static final String INSERTHIRE=
			"insert into HIRE (bookid,studentid,hireid,bookname,isbn,author,publisher,edition,price,quantity,hireDate,returnDate) values(?,?,?,?,?,?,?,?,?,?,?,?)";

	
	public static final ResultMapper MAP_USER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Admin admin = new Admin();
			admin.setPassword(rs.getString("password"));
			admin.setAId(rs.getInt("adminid"));
			return admin;
			
		}
	};
	
	public static final ResultMapper MAP_STUDENT = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Student student = new Student();
			student.setPassword(rs.getString("password"));
			student.setStudentid(rs.getInt("studentno"));
			return student;
			
		}
	};
	
	public static final ResultMapper MAP_BOOK = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			BookDetails book = new BookDetails();
			book.setBookname(rs.getString("bookname"));
			book.setIsbn(rs.getInt("isbn"));
			return book;
			
		}
	};
	
	public static final ResultMapper BOOKREQLISTMAPPER = new ResultMapper()
	{
		
		
		public Object mapRows(ResultSet rs) throws SQLException
        {
			int reqid= rs.getInt(1);
			int isbn=rs.getInt(2);
			String hiredate=rs.getString(3);
			int studentid=rs.getInt(4);
			String bookname=rs.getString(4);

		
		BookReuestList brl=new BookReuestList(isbn,reqid,studentid,hiredate,bookname); 
		
		
			return brl;
		}
		
		//mapRow
		
	};
	
	
	public static final ResultMapper MAP_HIRE=new ResultMapper()
		{
		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			BookHireList hire=new BookHireList();
			hire.setHireid(rs.getInt("bookname"));
			hire.setHireid(rs.getInt("studentid"));
			
				return hire;
			}
			
		};
}//Anonymous class


		
//int bookid=rs.getInt(1);




	
	

    

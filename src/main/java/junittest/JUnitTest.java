package junittest;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dao.BookRegisterDAO;

import junit.framework.AssertionFailedError;

public class JUnitTest {

	static java.sql.Connection con=null; 
	static String url="jdbc:mysql://localhost:3306/mydb";

	static BookRegisterDAO dao;

	//  Connection testing
	@Before
	public  void init() throws DBConnectionException 
	{ 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","Nttdata123");
			System.out.println(con);
		}
		catch (ClassNotFoundException e)
		{ 
			e.printStackTrace();
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		}
	}

	// Operations Testings
	@Disabled
	@Test
	public void testRegisterBook()
	{

		int no;
		try {
			String query = "insert into bookdetails values ('Ramayan',5,'valmiki','ramaa','7th',200,8)";
			no = con.createStatement().executeUpdate(query);
			assertEquals(no, 1);
			System.out.println("Book details inserted successfully");
			no = con.createStatement().executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AssertionFailedError error) {
			System.err.println(" FAILED TO Insert THE RECORD..." + error.toString());
		}

	}

 @After
	public void setUpAfterClass()
	{
		dao=null;
		System.out.println("After class");
	}
}


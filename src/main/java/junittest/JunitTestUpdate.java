package junittest;

import org.junit.Test;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.domain.BookDetails;
import com.nttdata.dao.BookRegisterDAO;

import junit.framework.AssertionFailedError;

public class JunitTestUpdate {

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
	public void testUpdateBook(BookDetails book )
	{

		int no;
		try {
			
				  String sql1="UPDATE bookdetails SET bookname = :IgnitedMinds WHERE isbn =:1";
				  MapSqlParameterSource namedParameters=new MapSqlParameterSource();
				  namedParameters.addValue("bookname", book.getBookname());
				  
				  
		
			no = con.createStatement().executeUpdate(sql1);
			
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


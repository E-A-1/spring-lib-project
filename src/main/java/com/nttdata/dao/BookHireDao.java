package com.nttdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.domain.BookHireList;


public class BookHireDao {

	public int hireBook(final BookHireList hb) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement preStmt) throws SQLException {
				
				preStmt.setInt(1, hb.getHireid());
				preStmt.setString(2, hb.getBookname());
			
				preStmt.setInt(3, hb.getIsbn());
				preStmt.setString(4, hb.getAuthor());
				preStmt.setString(5, hb.getPublisher());
				preStmt.setString(6, hb.getEdition());
				preStmt.setInt(7, hb.getPrice());
				preStmt.setInt(8, hb.getQuantity());
				preStmt.setString(9, hb.getHireDate());
				preStmt.setString(10, hb.getReturnDate());
				
				preStmt.setInt(11, hb.getBookid());
				preStmt.setInt(12, hb.getStudentid());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.INSERTHIRE, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}


    public boolean validateUser(final int hireid, int studentid) throws DAOAppException {
	ConnectionHolder ch = null;
	Connection con = null;
	List book = null;

	ParamMapper paramMapper = new ParamMapper() {

		@Override
		public void mapParams(PreparedStatement pStmt) throws SQLException {
			pStmt.setInt(1, hireid);
			pStmt.setInt(2, studentid);
			
		}
	};
	try {
		ch = ConnectionHolder.getInstance();
		con = ch.getConnection();
		book = DBHelper.executeSelect(con, SqlMapper.FETCHHIREIDSTUID,
				paramMapper, SqlMapper.MAP_HIRE);

	} catch (DBConnectionException e) {
		throw new DAOAppException(e);
	} catch (DBFWException e) {
		throw new DAOAppException(e);
	}

	return (book != null && book.size() > 0);

}
}

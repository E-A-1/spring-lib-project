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
import com.nttdata.domain.BookDetails;

public class BookRegisterDAO {

	public int registerBook(final BookDetails book) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, book.getBookname());
				pStmt.setInt(2, book.getIsbn());
				pStmt.setString(3, book.getAuthor());
				pStmt.setString(4, book.getPublisher());
				pStmt.setString(5, book.getEdition());
				pStmt.setInt(6, book.getPrice());
				pStmt.setInt(7, book.getQuantity());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_BOOK, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	public boolean validateUser(final int isbn) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List book = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, isbn);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			book = DBHelper.executeSelect(con, SqlMapper.FETCH_BOOK,
					paramMapper, SqlMapper.MAP_BOOK);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (book != null && book.size() > 0);

	}
}

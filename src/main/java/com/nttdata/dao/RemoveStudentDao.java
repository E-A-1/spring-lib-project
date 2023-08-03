package com.nttdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;

public class RemoveStudentDao {

	public static int  Deletestu(final int sid) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res=-1;
		
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt) throws SQLException {
					pStmt.setInt(1, sid);
				}
			};
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.DELETE_STUDENT,paramMapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}
}
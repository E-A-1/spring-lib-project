package com.nttdata.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nttdata.dao.DAOAppException;
import com.nttdata.dao.SqlMapper;
import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.domain.Student;

public class StudentRegisterDAO {
	public int registerStudent(final Student student) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, student.getStudentid());
				pStmt.setInt(2,student.getStudentNo());
				pStmt.setString(3, student.getName());
				pStmt.setString(4, student.getPassword());
				pStmt.setString(5, student.getEmail());
				pStmt.setDouble(6, student.getContact());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_STUDENT, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	public boolean validateStudent(final int StudentId) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List student = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, StudentId);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			student = DBHelper.executeSelect(con, SqlMapper.FETCH_STUDENT,
					paramMapper, SqlMapper.MAP_STUDENT);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (student != null && student.size() > 0);

	}

	
}
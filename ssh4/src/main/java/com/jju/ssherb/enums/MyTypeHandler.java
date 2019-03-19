package com.jju.ssherb.enums;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class MyTypeHandler implements TypeHandler<UserState>{
	
	@Override
	public void setParameter(PreparedStatement ps, int i, UserState parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(i, parameter.getCode());
	}

	@Override
	public UserState getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int code=rs.getInt(columnName);
		System.out.println("getResult"+code);
		return UserState.getUserStateByCode(code);
	}

	@Override
	public UserState getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code=rs.getInt(columnIndex);
		System.out.println("getResult"+code);
		return UserState.getUserStateByCode(code);
	}

	@Override
	public UserState getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code=cs.getInt(columnIndex);
		System.out.println("getResult"+code);
		return UserState.getUserStateByCode(code);
	}

}
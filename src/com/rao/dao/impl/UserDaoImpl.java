package com.rao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rao.dao.UserDao;
import com.rao.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareCall("insert into user (username,password,email) values (?,?,?)");
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		ps.setString(3, user.getEmail());
		ps.execute();
		System.out.println(user);
		

	}

	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "updagte user set username = ?,password = ?,email = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		ps.setString(3, user.getEmail());
		ps.setLong(4, id);
		ps.execute();

	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
		ps.setLong(1, user.getId());
		ps.execute();

	}

	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		return ps.executeQuery();
	}

}

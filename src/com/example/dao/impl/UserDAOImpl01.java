package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.util.DBHelper;

public class UserDAOImpl01 implements UserDAO {

	@Override
	public ArrayList<User> getUserList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select * from user";

		try {
			conn = DBHelper.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
	}

	@Override
	public User checkLogin(String name, String password) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "select * from user where name='" + name + "' and password='" + password + "'";
		System.out.println(sql);
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(stmt);
			if (rs != null && rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
		return user;
	}

	@Override
	public User getUserById(String id) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String sql = "select * from user where id=" + id;
		System.out.println(sql);
		ResultSet rs = null;
		User user = null;
		/*
		 * 由于JDBC提供的接口，这里不能使用Incorrect type handling注入
		 */
		conn = DBHelper.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs != null && rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
		}
		return user;
	}

	@Override
	public boolean register(String name, String password, int age) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into user(name,password,age) values(?,?,?)";
		conn = DBHelper.getConnection();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setInt(3, age);
			int count = stmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
	}

	@Override
	public boolean alterPW(String name, String password1, String password2) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "update user set password='" + password2 + "' where name='" + name + "' and password ='"
				+ password1 + "'";
		System.out.println(sql);
		conn = DBHelper.getConnection();

		try {
			// stmt=conn.prepareStatement(sql);
			// stmt.setString(1, password2);
			// stmt.setString(2, name);
			// stmt.setString(3, password1);
			stmt = conn.createStatement();
			// int count=stmt.executeUpdate();
			int count = stmt.executeUpdate(sql);
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
	}

	@Override
	public ArrayList<User> getUserByAge(String age) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select * from user where age=" + age;

		try {
			conn = DBHelper.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
	}

}

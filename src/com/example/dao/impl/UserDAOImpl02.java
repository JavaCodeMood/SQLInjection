package com.example.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.util.DBHelper;

public class UserDAOImpl02 implements UserDAO{

	@Override
	public ArrayList<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	//使用PreparedStatement实现登录功能
	@Override
	public User checkLogin(String name, String password) {
		Connection conn=null;
		PreparedStatement stmt=null;
		String sql="select id,name,age from user where name=? and password=?";
		ResultSet rs=null;
		User user=null;
		try {
			conn=DBHelper.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			System.out.println(stmt);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
			    user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs=null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt=null;
			}
		}
		return user;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(String name, String password, int age) {
		Connection conn=null;
		PreparedStatement stmt=null;
		String sql="insert into user(name,password,age) values(?,?,?)";
		conn=DBHelper.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setInt(3, age);
			int count=stmt.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}

	@Override
	public boolean alterPW(String name, String password1, String password2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> getUserByAge(String age) {
		// TODO Auto-generated method stub
		return null;
	}


}

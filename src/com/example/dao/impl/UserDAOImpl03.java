package com.example.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.util.DBHelper;

public class UserDAOImpl03 implements UserDAO {

	@Override
	public ArrayList<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	//使用存储过程实现用户登录
	@Override
	public User checkLogin(String name, String password) {
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		User user=null;
		try {
			conn=DBHelper.getConnection();
			cs=conn.prepareCall("{call check_login(?,?)}");
			cs.setString(1, name);
			cs.setString(2, password);
			System.out.println(cs);
			rs=cs.executeQuery();
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
			if(cs!=null){
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				cs=null;
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
		// TODO Auto-generated method stub
		return false;
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

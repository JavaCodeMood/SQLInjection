package com.example.dao.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.util.DBHelper;

public class UserDAOImpl04 implements UserDAO{


	@Override
	public ArrayList<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//使用mybatis框架实现验证登录功能
	@Override
	public User checkLogin(String name, String password) {
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		User resultUser = null;
		try {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			sqlSession = dbHelper.getSqlSession();
			resultUser = sqlSession.selectOne("User.check_login", user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return resultUser;
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

package com.example.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.entity.User;

public interface UserDAO {
	public ArrayList<User> getUserList();

	public User checkLogin(String name, String password);
	
	public User getUserById(String id) throws SQLException;
	
	public boolean register(String name,String password,int age);
	
	public boolean alterPW(String name,String password1,String password2);
	
	public ArrayList<User> getUserByAge(String age); 
}

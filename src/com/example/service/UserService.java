package com.example.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.UserDAO;
import com.example.dao.impl.UserDAOImpl01;
import com.example.dao.impl.UserDAOImpl02;
import com.example.dao.impl.UserDAOImpl03;
import com.example.dao.impl.UserDAOImpl04;
import com.example.entity.User;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService(){
		userDAO=new UserDAOImpl01();
	}
	
	//使用简单工厂方法生成useDAO
	public UserService(String param){
		if("PreparedStatement".equals(param)){
			userDAO=new UserDAOImpl02();
		}else if("StoredProcedure".equals(param)){
			userDAO=new UserDAOImpl03();
		}else if("mybatis".equals(param)){
			userDAO=new UserDAOImpl04();
		}else{
			userDAO=new UserDAOImpl01();
		}
	}
	public ArrayList<User> getUserList(){
		return userDAO.getUserList();
	}
	
	public User checkLogin(String name,String password){
		if(name==null || password==null){
			return null;
		}
		name=name.trim();
		password=password.trim();
		return userDAO.checkLogin(name,password);
	}
	
	public User getUserById(String id) throws SQLException{
		if(id==null || "".equals(id.trim())){
			return null;
		}
		User user=userDAO.getUserById(id);
		return user;
		
	}
	
	public boolean register(String name,String password,String age){
		if(name==null ||"".equals(name.trim())){
			return false;
		}
		if(password==null ||"".equals(password.trim())){
			return false;
		}
		if(age==null ||"".equals(age.trim())){
			return false;
		}
		return userDAO.register(name, password, Integer.parseInt(age));
	}
	
	public boolean alterPW(String name,String password1,String password2){
		if(name==null ||"".equals(name.trim())){
			return false;
		}
		if(password1==null ||"".equals(password1.trim())){
			return false;
		}
		if(password2==null ||"".equals(password2.trim())){
			return false;
		}
		return userDAO.alterPW(name, password1, password2);
	}
	
	public ArrayList<User> getUserByAge(String age){
		if(age==null || "".equals(age.trim())){
			return null;
		}
		return userDAO.getUserByAge(age);
	}
	
	public static void main(String[] args){
		ArrayList<User> list=new UserService().getUserList();
		for(User user:list){
			System.out.println(user.getName());
		}
	}
}

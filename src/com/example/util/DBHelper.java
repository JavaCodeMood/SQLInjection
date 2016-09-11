package com.example.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {
	//初始化参数
	private final static String DRIVER="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost:3306/test1?useUnicode=true"
			+ "&characterEncoding=utf-8&useSSL=true";
	private final static String USER="root";
	private final static String PASSWORD="123456";
	
	private static Connection conn=null;
	
	//使用静态代码块加载mysql驱动
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//使用单例模式获得数据库连接对象
	public static Connection getConnection(){
		if(conn==null){
			try {
				conn=DriverManager.getConnection(URL,USER,PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public SqlSession getSqlSession() throws IOException {
		Reader reader=Resources.getResourceAsReader("com/example/config/Configuration.xml");
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		return sqlSessionFactory.openSession();
	}
}

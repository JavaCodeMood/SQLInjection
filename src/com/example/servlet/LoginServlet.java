package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.User;
import com.example.service.UserService;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String way=req.getParameter("way");
		System.out.println(name+"  "+password);
		UserService userService=new UserService(way);
		User user=userService.checkLogin(name,password);
		if(user!=null){
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("success.jsp").forward(req, resp);;
		}else{
			req.getRequestDispatcher("failure.jsp").forward(req, resp);
		}
	}


}

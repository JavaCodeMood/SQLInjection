package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.UserService;

public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String age=req.getParameter("age");
		UserService userService=new UserService();
		if(userService.register(name, password, age)){
			req.getRequestDispatcher("/registerSuccess.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/registerFail.jsp").forward(req, resp);
		}
		
	}


}

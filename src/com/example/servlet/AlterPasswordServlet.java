package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.User;
import com.example.service.UserService;

public class AlterPasswordServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		String name=((User)req.getSession().getAttribute("user")).getName();
		UserService userService=new UserService();
		if(userService.alterPW(name, password1, password2)){
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/failure.jsp").forward(req, resp);
		}
	}


	
}

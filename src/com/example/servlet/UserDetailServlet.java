package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.User;
import com.example.service.UserService;

public class UserDetailServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		UserService userService=new UserService();
		User user;
		try {
			user = userService.getUserById(id);
			req.setAttribute("user",user);
			req.getRequestDispatcher("userDetail.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
}

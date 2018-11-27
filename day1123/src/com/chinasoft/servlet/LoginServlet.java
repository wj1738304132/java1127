package com.chinasoft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.dao.UserDao;
import com.chinasoft.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		String userpwd=req.getParameter("userpwd");
		
		UserDao userDao=new UserDao();
		User user=userDao.dologin(username, userpwd);
		
		if(user!=null){
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}else {
			req.setAttribute("tip", "请输入正确的用户名和密码");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}

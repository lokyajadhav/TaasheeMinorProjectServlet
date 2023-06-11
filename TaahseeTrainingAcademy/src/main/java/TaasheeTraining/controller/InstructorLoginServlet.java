package TaasheeTraining.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TaasheeTraining.model.*;
@WebServlet({"/instructorlogin","/instructorlogout"})
public class InstructorLoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/instructorlogin"))
		{
		resp.sendRedirect("InstructorLogin.jsp");
		}
		else
		{
			HttpSession session=req.getSession();
			session.invalidate();
			resp.sendRedirect("homePage.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		if(APIsDao.isInstructorAuthenticated(userName,password) )
		{
			HttpSession session	=req.getSession();
			session.setAttribute("loggenInUser", userName);
			resp.sendRedirect("getInstructorByUserName");
		}
		else
		{
			resp.sendRedirect("InstructorLogin.jsp");
		}
	}

}

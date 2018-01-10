package com.online.bank.application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/* To perform User Logout 	Operation*/
public class LogOutController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  RequestDispatcher rd=null;
		HttpSession  session=req.getSession(false);
		
		if(session!=null)
			
		{
			resp.setHeader("cache-control", "no-cache,no-store,must-revalidate");
			resp.setHeader("pragma", "no-cache");
			resp.setDateHeader("expires", 0);
			/* To destory session object */
			session.invalidate();
			session=null;
			rd=req.getRequestDispatcher("login.jsp");
		}else
		{
			rd=req.getRequestDispatcher("login.jsp");
			
		}
		rd.forward(req, resp);
		
		
		
	}
	

}

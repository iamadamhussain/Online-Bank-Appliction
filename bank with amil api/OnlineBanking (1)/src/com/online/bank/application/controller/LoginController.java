package com.online.bank.application.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.model.service.UserService;
/*  To perform UserLogin operation
 * 	This class fetch all the user details if the user name and password is valid
 *  If the user is valid then it sets the account number and the name into the session scope
 *  if the user is not valid it gives the control back to the login page and display an error message */
@SuppressWarnings("serial")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*Fetching UI data from login user*/
		String acnum = req.getParameter("acno");
		String pwd = req.getParameter("pw");
		UserService service = new UserService();
		try {
		RegistrationDTO dto=service.userLoginService(acnum, pwd);
			RequestDispatcher rd = null;
			HttpSession session = null;
			if (dto != null)
			{
				session = req.getSession(true);
			
				String username=dto.getFirstName()+"   "+dto.getLastName();
				String acno=dto.getAccno();
				session.setAttribute("un", username);
				
				session.setAttribute("ac", acno);
				rd = req.getRequestDispatcher("DisplayName.jsp");
			} else {
				req.setAttribute("msg", "invalid User");
				rd = req.getRequestDispatcher("login.jsp");
			} 
			rd.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package com.online.bank.application.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bank.application.model.service.UserService;

/* This controller perform the view the user balance */
public class ViewBalanceController extends HttpServlet {

	private static final long serialVersionUID = 5465898348406445742L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = null;
		RequestDispatcher rd = null;
		UserService service = new UserService();
		session = req.getSession(false);

		if (session != null) {

			/* Fetching Acno from session */
			String acno = (String) session.getAttribute("ac");
			try {
				/* calling viewbalanceservice method from UserService class */
				double balance = service.viewBalanceService(acno);
				req.setAttribute("balance", balance);
				rd = req.getRequestDispatcher("ViewBalance.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			req.setAttribute("msg", "INVALID USER");
			rd = req.getRequestDispatcher("login.jsp");

		}
		rd.forward(req, resp);

	}

}

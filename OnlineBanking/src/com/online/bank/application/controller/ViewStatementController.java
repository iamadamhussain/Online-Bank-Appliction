package com.online.bank.application.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.online.bank.application.dto.SenderDTO;
import com.online.bank.application.model.service.UserService;
/*To perform  user view Transaction History*/
public class ViewStatementController extends HttpServlet {

	private static final long serialVersionUID = 5875552868155737476L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		HttpSession session = null;
		String startdate = req.getParameter("std");
		String enddate = req.getParameter("end");
		session = req.getSession(false);
		if (session != null) {
			resp.setHeader("cache-control", "no-cache,no-store,must-revalidate");
			resp.setHeader("pragma", "no-cache");
			resp.setDateHeader("expires", 0);
			/*  Getting  the A/c no from session*/
			String AccountNo = (String) session.getAttribute("ac");
			UserService service = new UserService();
			ArrayList<SenderDTO> list = null;
			try {
				
				
				list = service.viewTransactionHistory(startdate, enddate,
						AccountNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("list ; " + list);
			req.setAttribute("startDate", startdate);
			req.setAttribute("endDate", enddate);
			System.out.println("end date : " + enddate);
			req.setAttribute("list", list);
			for (SenderDTO senderdto : list) {
				System.out.println(senderdto.getTid() + "/n amount:  "
						+ senderdto.getBalance());

				rd = req.getRequestDispatcher("Viewstatement.jsp");

			}

		}
		rd.forward(req, resp);

	}

}

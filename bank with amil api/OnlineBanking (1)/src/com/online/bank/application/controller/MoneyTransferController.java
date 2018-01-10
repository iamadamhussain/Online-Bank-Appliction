package com.online.bank.application.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online.bank.application.utility.CustomException;
import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.dto.TransactionDTO;
import com.online.bank.application.model.service.MoneyTransferService;
import com.online.bank.application.model.service.MoneyTransferService;
import com.online.bank.application.model.service.UserService;

;

@SuppressWarnings("unused")
/* This controller used to perform user Money transfer operation*/
public class MoneyTransferController extends HttpServlet {
	
	private static final long serialVersionUID = 7720458850284009746L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String Transactionid = null;
		HttpSession session = null;
		/*Fecth UI data from jsp  page  */
		String AccountNo = req.getParameter("ac");
		String Amount = req.getParameter("amt");
		double amount1 = Double.parseDouble(Amount);
		System.out.println("account number : "+AccountNo);
		System.out.println("amount "+amount1);
		String Description = req.getParameter("add");
		TransactionDTO senderdto = new TransactionDTO();
		TransactionDTO reciverdto = new TransactionDTO();
		session = req.getSession(false);
	
		UserService service = new UserService();
		if(session!=null){
			
		/*Fetching UI data and populating into the senderdto  */
			String ACCNO = (String) session.getAttribute("ac");
			senderdto.setAcNo(ACCNO);
			senderdto.setDescription(Description);
			reciverdto.setAcNo(AccountNo);
			reciverdto.setBalance(amount1);
			reciverdto.setDescription(Description);
			
			try { 
				/* calling moneytransferService  method form userservice class*/  
				Transactionid = service.moneyTransferService(
						senderdto, reciverdto, amount1);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (CustomException e) {
				req.setAttribute("msg", e.getMessage());
				rd=req.getRequestDispatcher("Transaction.jsp");
			}
			if (Transactionid!= null) {
				
				
					// setting key and value to the Transaction ID
					session.setAttribute("tid", Transactionid);
					rd = req.getRequestDispatcher("Tiddisplay.jsp");
			
			} else {
				rd = req.getRequestDispatcher("Transaction.jsp");
			}
		
		rd.forward(req, resp);
		}
	}
	
}

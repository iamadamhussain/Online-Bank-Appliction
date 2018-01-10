package com.online.bank.application.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.model.service.UserService;
/*  This controller  perform the user Registration operation*/
public class RegistrationController extends HttpServlet {
	
	
	private static final long serialVersionUID = -8568754763858267278L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd=null;
		//Fetching UI data And populate into DTO //
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String email=req.getParameter("em");
		String address = req.getParameter("add");
		String mobileno = req.getParameter("mn");
		
		String dob = req.getParameter("db");
		String gender = req.getParameter("m");
		String accounttype = req.getParameter("acctype");
		String amount=req.getParameter("en");
		Double Amount=Double.parseDouble(amount);
		String pass = req.getParameter("pwd");
		RegistrationDTO dto = new RegistrationDTO();
		dto.setFirstName(fn);
		dto.setLastName(ln);
		dto.setAddress(address);
		dto.setMobileNo(mobileno);
		dto.setDob(dob);
		dto.setGender(gender);
		dto.setTypeofAccount(accounttype);
		dto.setAmount(Amount);
		dto.setPassword(pass);
		dto.setEmail(email);
		
		//populating dto to user service//
		UserService service=new UserService();



		String accno = null;
		try {
			accno = service.userRegistration(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		if(accno!=null){
			req.setAttribute("acc", accno);
			rd=req.getRequestDispatcher("account.jsp");
		
			
		}else
		{
			req.setAttribute("msg", "invalid details");
			rd=req.getRequestDispatcher("Registration.jsp");
		}
		rd.forward(req, resp);
	}
	

}

package com.online.bank.application.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.dto.SenderDTO;
import com.online.bank.application.model.dao.UserDAO;
import com.online.bank.application.model.dao.TransactionDAO;

/*User service class*/
public class UserService {
	UserDAO dao = new UserDAO();
	/* populating the Registration user information into UserDAO */
	public String userRegistration(RegistrationDTO dto) throws SQLException {
		String accNum;
		
		Random random = new Random();
		int accno = random.nextInt() + 3;
		accNum = "SBI" + accno;
		dto.setAccno(accNum);
		System.out.println(accNum);
		
		accNum = dao.registrationDao(dto);
		return accNum;

	}
	/* populating the account no and password information into UserDAO */
	public RegistrationDTO userLoginService(String acnum, String pwd)
			throws SQLException {

		RegistrationDTO dto = dao.userDao(acnum, pwd);
		return dto;
	}
	/* populating  account no information into UserDAO */
	public double viewBalanceService(String accno) throws SQLException {
		double banlance = dao.viewBalanceDao(accno);
		return banlance;

	}
	/* populating start date and end date  user information into TransactionDAO */
	public ArrayList<SenderDTO> viewTransactionHistory(String startdate,
			String enddate, String accountNo) throws SQLException {

		TransactionDAO dao = new TransactionDAO();

		ArrayList<SenderDTO> list = dao.viewStatement(startdate, enddate,
				accountNo);

		System.out.println(list);
		return list;

	}

}

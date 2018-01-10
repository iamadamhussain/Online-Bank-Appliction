package com.online.bank.application.model.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.dto.TransactionDTO;
import com.online.bank.application.model.dao.Customer;
import com.online.bank.application.model.dao.DaoHelper;
import com.online.bank.application.model.dao.UserDAO;
import com.online.bank.application.utility.CustomException;

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

	/* populating account no information into UserDAO */
	public double viewBalanceService(String accno) throws SQLException {
		Customer cust = DaoHelper.getObject();
		double banlance = cust.viewBalanceDao(accno);
		return banlance;
	}

	public String moneyTransferService(TransactionDTO senderdto,
			TransactionDTO reciverdto, double amount1) throws SQLException,
			CustomException {

		Date d = new Date();
		SimpleDateFormat simpledate = new SimpleDateFormat("YYYY-MM-dd");
		@SuppressWarnings("unused")
		java.sql.Date sqlDate = new java.sql.Date(0);
		System.out.println("simple date " + simpledate.format(d));
		String date = simpledate.format(d);
		System.out.println(date);

		UserDAO dao = new UserDAO();
		/* Generating Transaction ID for both Senderdto and Reciverdto */
		Random random = new Random();

		int Tid = random.nextInt() * 3 + 10;

		String tid = null;
		System.out.println(tid);
		UserService service = new UserService();

		double balance = service.viewBalanceService(senderdto.getAcNo());
		double finalbalance = balance - amount1;
		if (finalbalance >= 1000) {
			/* Setting data to sender DTO */
			senderdto.setDate(date);
			// double finalbalance = balance - amount1;
			System.out.println(finalbalance);
			senderdto.setBalance(finalbalance);
			senderdto.setTid("TID" + Tid);
			/* Setting data to ReciverDTO */
			reciverdto.setDate(date);
			double balance1 = service.viewBalanceService(reciverdto.getAcNo());
			double fbalance = balance1 + amount1;
			reciverdto.setBalance(fbalance);

			reciverdto.setTid("TID" + (Tid * 2));
			tid = dao.moneyTransactionDao(senderdto, reciverdto);

		} else {
			throw new CustomException(
					"Money Transfer failed ,Transaction cancelled");
		}
		return tid;
	}

}

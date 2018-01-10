package com.online.bank.application.model.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.online.bank.application.controller.utility.CustomException;
import com.online.bank.application.dto.ReciverDTO;
import com.online.bank.application.dto.SenderDTO;
import com.online.bank.application.model.dao.UserDAO;

public class MoneyTransferService {

	public String moneyTransferService(SenderDTO senderdto,
			ReciverDTO reciverdto, double amount1) throws SQLException, CustomException { 
		
		
		Date d = new Date();
		SimpleDateFormat simpledate= new SimpleDateFormat("YYYY-MM-dd");
		java.sql.Date sqlDate=new java.sql.Date(0);
		System.out.println("simple date "+simpledate.format(d));
		String date=simpledate.format(d);
		System.out.println(date);

		UserDAO dao = new UserDAO();
/*  Generating Transaction ID  for both Senderdto and Reciverdto*/
		Random random = new Random();

		int Tid = random.nextInt() * 3 + 10;
		
		String tid=null;
		System.out.println(tid);
		UserService service = new UserService();

		double balance = service.viewBalanceService(senderdto.getAcNo());
		if (balance >= 1000) {
			/*Setting data to sender DTO*/
			senderdto.setDate(date);
			double finalbalance = balance - amount1;
			System.out.println(finalbalance);
			senderdto.setBalance(finalbalance);
			senderdto.setTid("TID"+Tid);
			/* Setting data to ReciverDTO*/
			reciverdto.setDate(date);
	       double balance1 = service.viewBalanceService(reciverdto.getAcNo());
			double fbalance = balance1 + amount1;
			reciverdto.setBalance(fbalance);

			reciverdto.setTid("TID"+(Tid*2));
			tid=dao.moneyTransactionDao(senderdto, reciverdto);

		}
		return tid;
	}
}

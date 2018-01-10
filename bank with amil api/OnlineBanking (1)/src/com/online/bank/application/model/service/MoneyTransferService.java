package com.online.bank.application.model.service;
import java.sql.SQLException;
import java.util.ArrayList;
import com.online.bank.application.dto.TransactionDTO;
import com.online.bank.application.model.dao.TransactionDAO;

public class MoneyTransferService {

	/* populating start date and end date user information into TransactionDAO */
	public ArrayList<TransactionDTO> viewTransactionHistory(String startdate,
			String enddate, String accountNo) throws SQLException {

		TransactionDAO dao = new TransactionDAO();

		ArrayList<TransactionDTO> list = dao.viewStatement(startdate, enddate,
				accountNo);

		System.out.println(list);
		return list;

	}
}

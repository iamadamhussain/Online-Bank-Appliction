package com.online.bank.application.model.dao;

import java.sql.SQLException;


import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.dto.TransactionDTO;
import com.online.bank.application.utility.CustomException;

public interface Customer
{
	public String registrationDao(RegistrationDTO dto) throws SQLException;
	public RegistrationDTO userDao(String acnum, String pwd) throws SQLException;
	public double viewBalanceDao(String accno) throws SQLException;
	public String moneyTransactionDao(TransactionDTO senderdto, TransactionDTO  reciverdto)
			throws CustomException;

}

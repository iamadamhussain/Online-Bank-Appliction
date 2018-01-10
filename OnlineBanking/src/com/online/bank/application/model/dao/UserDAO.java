package com.online.bank.application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.bank.application.controller.utility.CustomException;
import com.online.bank.application.dto.RegistrationDTO;
import com.online.bank.application.dto.ReciverDTO;
import com.online.bank.application.dto.SenderDTO;

public class UserDAO {
/* Persistance logic for UserRegistration */
	public String registrationDao(RegistrationDTO dto) throws SQLException {
		String sql = "insert into jjs6.bank values(?,?,?,?,?,?,?,?,?,?)";
		SingleTon singleTon = SingleTon.getSingleTon();
		Connection con = singleTon.getconnection();
		System.out.println(con);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getAccno());
		pstmt.setString(2, dto.getFirstName());
		pstmt.setString(3, dto.getLastName());
		pstmt.setString(4, dto.getMobileNo());
		pstmt.setString(5, dto.getAddress());
		pstmt.setString(6, dto.getDob());
		pstmt.setString(7, dto.getGender());
		pstmt.setString(8, dto.getTypeofAccount());
		pstmt.setString(9, dto.getPassword());
		pstmt.setDouble(10, dto.getAmount());
		String accountNumber;

		int num = pstmt.executeUpdate();
		if (num == 0) {
			accountNumber = null;
		} else {
			
			accountNumber = dto.getAccno();
		}
		return accountNumber;
	}

	String Firstname = null;
	String lastname = null;
	String AccountNo = null;
/*Persistance Logic for UserLogin validation*/
	public RegistrationDTO userDao(String acnum, String pwd) throws SQLException {

		RegistrationDTO dto = null;

		String query = "select * from jjs6.bank where accno=? and password=?";
		SingleTon singleTon = SingleTon.getSingleTon();
		Connection con = singleTon.getconnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, acnum);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())

		{

			dto = new RegistrationDTO();
			Firstname = rs.getString("firstname");
			lastname = rs.getString("lastname");
			AccountNo = rs.getString("accno");
			System.out.println(Firstname);
			dto.setFirstName(Firstname);
			dto.setLastName(lastname);
			dto.setAccno(AccountNo);
		} else {

		}
		return dto;

	}
/*Persistance Logic for view User Account Balance*/
	public double viewBalanceDao(String accno) throws SQLException {
		double Balance = 000.000;
		String query = "select Balance from jjs6.bank where accno=? ";
		SingleTon singleTon = SingleTon.getSingleTon();
		Connection con = singleTon.getconnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, accno);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			//Fetching balance from DB//
			Balance = rs.getDouble("Balance");

		}
		return Balance;

	}
/*Persistance Logic for User money transfer operation*/
	public String moneyTransactionDao(SenderDTO senderdto, ReciverDTO reciverdto)
			throws CustomException {
		String query = "Update  jjs6.bank set balance=?  where accno=?";
		
		String tid = null;
		SingleTon singleTon = SingleTon.getSingleTon();
		Connection con = singleTon.getconnection();
		System.out.println(con);
		PreparedStatement pstmt = null;
		try {

			con.setAutoCommit(false);
			/* setting data to sender account*/
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, senderdto.getBalance());

			pstmt.setString(2, senderdto.getAcNo());
			pstmt.addBatch();
			
			/* setting data to Receiver account*/
	
			pstmt.setDouble(1, reciverdto.getBalance());
			pstmt.setString(2, reciverdto.getAcNo());
			pstmt.addBatch();
			pstmt.executeBatch();
			
			
			TransactionDAO dao = new TransactionDAO();
			tid = dao.insertTransaction(senderdto, reciverdto, con);
			
		con.commit();

		} catch (SQLException e1) {
			System.out.println("SQL EXCEPTION:" + e1.getMessage());

			try {
				con.rollback();
			} catch (SQLException e) {
				System.out.println("SQLEXCEPTION:" + e.getMessage());
			}
			throw new CustomException(
					"Money Transfer failed ,Transaction cancelled");
		}

		return tid;

	}

}

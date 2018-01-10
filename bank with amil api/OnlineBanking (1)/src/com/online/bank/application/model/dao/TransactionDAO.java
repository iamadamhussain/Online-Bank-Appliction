package com.online.bank.application.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.online.bank.application.dto.TransactionDTO;
/* TransactionDAO class for persistance logic*/
public class TransactionDAO {
	/*Persistance Logic for User money transfer operation*/
	public String insertTransaction(TransactionDTO senderdto,TransactionDTO reciverdto,
			Connection con) throws SQLException {

		String query = "insert into  jjs6.transaction values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		// setting values to place holder for ReciverDTO//
		pstmt.setString(1, reciverdto.getTid());
		pstmt.setString(2, reciverdto.getAcNo());
		pstmt.setString(3, reciverdto.getDescription());
		pstmt.setDouble(4, reciverdto.getBalance());
		pstmt.setString(5, reciverdto.getDate());
		pstmt.addBatch();
		// setting values to place holder for SenderDTO//
		pstmt.setString(1, senderdto.getTid());
		pstmt.setString(2, senderdto.getAcNo());
		pstmt.setString(3, senderdto.getDescription());
		pstmt.setDouble(4, senderdto.getBalance());
		pstmt.setString(5, senderdto.getDate());
		pstmt.addBatch();
		int[] num = pstmt.executeBatch();
		String tid = null;
		if (num[1] != 0) {
			tid = senderdto.getTid();
			System.out.println(tid);
		}

		return tid;

	}
	/*Persistance Logic for  view transaction history of User */
	@SuppressWarnings("unused")
	public ArrayList<TransactionDTO> viewStatement(String startdate, String enddate,
			String AccountNo) throws SQLException {

		String query = "select * from jjs6.transaction where Accno=? and Date Between ? and ?";

		Date d = new Date(0000 - 00 - 00);
		TransactionDTO senderdto = null;
		java.util.ArrayList<TransactionDTO> list = new java.util.ArrayList<TransactionDTO>();
		SingleTon singleTon = SingleTon.getSingleTon();
		Connection con = singleTon.getconnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, AccountNo);
		pstmt.setString(2, startdate);
		pstmt.setString(3, enddate);

	/*	senderdto = new TransactionDTO();
		senderdto.setBalance(5000.00);

		senderdto.setDescription("Hi Hello");
		senderdto.setDate("2014-08-14");
		senderdto.setTid("TID15689789");
		list.add(senderdto);
*/
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			senderdto = new TransactionDTO();
			senderdto.setTid(rs.getString(1));
			senderdto.setDescription(rs.getString(3));
			senderdto.setBalance(rs.getDouble(4));
			senderdto.setDate(rs.getString(5));

			list.add(senderdto);
		}

		return list;
	}

}

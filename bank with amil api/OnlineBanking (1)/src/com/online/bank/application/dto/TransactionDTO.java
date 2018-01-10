package com.online.bank.application.dto;
/* */
public class TransactionDTO {
	
	private String Tid;
	private String AcNo;
	private String Description;
	private double balance;
	private String Date;
	private String StartDate;
	private String EndDate;
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
	public String getAcNo() {
		return AcNo;
	}
	public void setAcNo(String acNo) {
		AcNo = acNo;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}

}

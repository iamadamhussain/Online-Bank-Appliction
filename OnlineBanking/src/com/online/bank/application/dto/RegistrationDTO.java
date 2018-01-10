package com.online.bank.application.dto;

public class RegistrationDTO {

	private String firstName;
	private String lastName;
	private String mobileNo;
	private String dob;
	private String gender;
	private String typeofAccount;
	private String password;
	private String accno;
	private String address;
	private double Amount;

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTypeofAccount() {
		return typeofAccount;
	}

	public void setTypeofAccount(String typeofAccount) {
		this.typeofAccount = typeofAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accNum) {
		this.accno = accNum;
	}

}

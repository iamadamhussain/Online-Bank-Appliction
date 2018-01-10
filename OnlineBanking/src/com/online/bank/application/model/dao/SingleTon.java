package com.online.bank.application.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;


/* To create single Connection object for DB Connection*/
public class SingleTon {
	private static final SingleTon ONLY_ONE=new SingleTon();


	
	private Connection con=null;

	private SingleTon()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static SingleTon   getSingleTon()
	{
		return ONLY_ONE;			
	}
	public Connection getconnection()
	{
		return con;
	}
	@Override
	protected void finalize() throws Throwable 
	{
		if(con!=null)
		{
			con.close();
		}
	}

}

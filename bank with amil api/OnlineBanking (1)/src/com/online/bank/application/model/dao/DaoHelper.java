package com.online.bank.application.model.dao;

public class DaoHelper 
{
	public static UserDAO getObject() 
	{
		return new UserDAO();
		
	}
	public static UserDAO getHibernateObject() 
	{
		return new UserDAO();
		
	}

}

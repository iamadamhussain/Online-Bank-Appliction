package com.online.bank.application.model.dao;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil 
{
	public static boolean sendGmail(String toAddress,String message)
	{
		 final String fromEmail ="aseema.info@gmail.com";//create gmail id and use here   and dont use this 
	     final String password = "aseema123#"; // put your password//
	     Properties props = new Properties();
	     props.put("mail.smtp.host","smtp.gmail.com"); //SMTP Host
	     props.put("mail.smtp.port","587"); //TLS Port
	     props.put("mail.smtp.auth", "true"); //enable authentication 
	     props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
	                //create Authenticator object to pass in Session.getInstance argument 
	     
	     //below 5 lines are for gmail only
	     
	        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
	        props.put("mail.smtp.socketFactory.class",
	              "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
	        props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
	        props.put("mail.smtp.ssl.enable", "true");   
	        

	        Authenticator auth = new Authenticator() 
	        {
	            //override the getPasswordAuthentication method
	            protected PasswordAuthentication getPasswordAuthentication() 
	            {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };
	       
	        Session session = Session.getInstance(props, auth);
	        try
	        {
	          MimeMessage msg = new MimeMessage(session);
	          msg.setFrom(new InternetAddress(fromEmail));
	          msg.setSubject("OnlineBanking Registration Info", "UTF-8");
	          msg.setText(message);
	          msg.setSentDate(new Date());  
	          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
	          Transport.send(msg);  
	          System.out.println("EMail Sent Successfully!!");
	          return true;
	        }
	        catch (AddressException e) 
	        {
				e.printStackTrace();
				return false;
			}
		    catch (MessagingException e) 
		    {
				e.printStackTrace();
				return false;
			}
	        catch (Exception e) 
	        {
	          e.printStackTrace();
	          return false;
	        }
	}
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body background="login.jpg">
	<p align="right">
		<a href="log">LogOut</a>
	</p>
	<center>
	<%
		String ref1 = (String) request.getAttribute("acc");
	%>

	<h1><font color="Red"><marquee>WELCOME TO STATE BANK OF INDIA</marquee></font></h1>
	
	
		<font color="Green" size="5"> Your Registration is completed successfully And Your A/C NO  : <%=ref1%></font>
	
	&nbsp;&nbsp;&nbsp;&nbsp;
	<font color="Red">
<br>
<br>
	<br>	<form action="login.jsp">
			<input type="submit" value="Login"></input>
		</form>
	</font>
	</center>
</body>
</html>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="login.jpg">

	<p align="right">
		<a href="log">LogOut</a>
	</p>
	<%
		String ref = (String) session.getAttribute("un");
	%>

<center><font color="#FF3333" size="5">UserName:    &nbsp;<font size="4"><%=ref%></font></font></center>
	
	<form method="post" action="view.do">
		<font color="Red"> <INPUT TYPE="submit" value="ViewBalance">
			
			</font>
	</form>
	<br>
	<br>
	<form method="post" action="Transaction.jsp">
		<INPUT TYPE="submit" value="MoneyTransfer">
	</form>
	<br>
	<br>
	<form method="post" action="Transhistory.jsp">
		<INPUT TYPE="submit" value="ViewStatements">
	</form>
</body>
</html>

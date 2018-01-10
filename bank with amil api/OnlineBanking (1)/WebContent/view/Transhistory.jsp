<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<BODY  background="login.jpg"  >
<% String name=(String)session.getAttribute("un"); %>
<p align="right"><%=name%>
<p align="right"><a href="log">LogOut</a></p>
<form action="DisplayName.jsp">
<p align="left"><input type="submit" value="Home">

</form>

<form method="post" action="viewst.do">
<center>
<h1><FONT SIZE="5" COLOR="#FF0000"><U>VIEW TRANSACTION HISTORY</U></FONT></h1><br><br>
<TABLE>
<TR>
	<TD>StartDate(YYYY-MM-DD):</TD>
	<TD> <INPUT TYPE="text" NAME="std"></TD>
</TR>
<TR>
	<TD>EndDate(YYYY-MM-DD):</TD>
	<TD> <INPUT TYPE="text" NAME="end"></TD>
</TR>
<TR>
	<TD></TD>
	<TD><INPUT TYPE="submit" value="Submit"></TD>
</TR>
</TABLE>
</center>
</form>
</BODY>
</HTML>



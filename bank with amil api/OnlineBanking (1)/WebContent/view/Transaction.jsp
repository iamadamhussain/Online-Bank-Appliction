<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<BODY background="login.jpg">
<% String name=(String)session.getAttribute("un"); %>
<p align="right"><%=name%>

<p align="right"><a href="log">LogOut</a></p>
<form action="DisplayName.jsp">
<p align="left"><input type="submit" value="Home">

</form>
<center>
<font color="red" size="6">${msg}</font>
<FORM METHOD="POST" ACTION="money.do">
<TABLE>
<TR>
	<TD>TOAccountNO:</TD>
	<TD><INPUT TYPE="text" NAME="ac"></TD>
</TR>
<TR>
	<TD>Amount:</TD>
	<TD><INPUT TYPE="text" NAME="amt"></TD>
</TR>
<TR>
	<TD>Description:</TD>
	<TD><TEXTAREA NAME="add" ROWS="" COLS=""></TEXTAREA></TD>
</TR>
<TR>
	<TD></TD>
	<TD><INPUT TYPE="submit" value="Transfer"></TD>
</TR>
</TABLE>


</FORM>
</center>

</BODY>
</html>
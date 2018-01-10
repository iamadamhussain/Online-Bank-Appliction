<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Welcome To Login</title>
<script type="text/javascript">
function myvalidate(){
	var accountno=document.myform.acno.value;
	var password=document.myform.pw.value;
	if(accountno=="" || password==""){
		alert("AccountNo  and password are should not be empty");
		return false;
	}
	return true;
}
</script>
</head>
<body background="login.jpg">
<center>
<FORM  name="myform" method="POST" ACTION="login.do">
<center><h1><marquee>WELCOME TO SBI</marquee></h1></center>
<TABLE>
<TR>
	<TD>AccountNo:</TD>
	<TD><INPUT TYPE="text" NAME="acno"></TD>
</TR>
<TR>
	<TD>Password:</TD>
	<TD><INPUT TYPE="password"  name="pw"></TD>
</TR>
<TR>
	<TD></TD>
	<TD><INPUT TYPE="submit" name="submit"value="Login" onclick="return myvalidate()">&nbsp;&nbsp;<br><br><a href="Registration.jsp">Not yet registered Register Here</a></TD>
	
</TR>

</TABLE>
</FORM>
<h1><font color="Blue" size="10"> </font></h1>&nbsp;&nbsp;&nbsp;&nbsp;
<font color="Red">
<% String ref= (String)request.getAttribute("msg");%>
<% if(ref!=null){
%>
<%=ref %>
<%} %>

</font>
</center>
</BODY>
</HTML>
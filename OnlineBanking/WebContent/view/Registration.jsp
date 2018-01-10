<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import=" java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Registration</title>
<script type="text/javascript">
	function myvalid() {
		var fname = document.reg.fn.value;
		var lname = document.reg.ln.value;
		var phoneno = document.reg.mn.value;
		var add = document.reg.add.value;
		var dob = document.reg.db.value;
		var pass1 = document.reg.pwd.value;
		var pass2 = document.reg.pwd1.value;
		var amt = document.reg.en.value;
		if (fname == "") {
			alert("first name should not be empty");
			return false;
		} else if (lname == "") {
			alert("last name should not be empty");
			return false;
		} else if (phoneno == "") {
			alert("phone number should not be empty");
			return false;

		} else if (add == "") {
			alert("Address should not be empty");
			return false;
		} else if (dob == "") {
			alert("Date of Birth should not be empty");
			return false;
		} else if (pass1 == "") {
			alert("password should not be empty");
			return false;
		} else if (pass2 == "") {
			alert("retype password should not be empty");
			return false;
		} else if (pass1 != pass2) {
			alert("retype password should be matched with password");
			return false;
		} else
			return true;
	}
</script>
</head>


<body background="login.jpg">
	<center>
		<h1>
			<marquee>WELCOME TO ONLINE REGISTRATION OF SBI</marquee>
		</h1>
		<br> <br>

		<FORM name="reg" METHOD="POST" ACTION="reg.do">
			<TABLE>
				<TR>
					<TD>FirstName:</TD>
					<TD><INPUT TYPE="text" NAME="fn"></TD>
				</TR>
				<TR>
					<TD>LastName:</TD>
					<TD><INPUT TYPE="text" NAME="ln"></TD>
				</TR>

				<TR>
					<TD>MobileNo:</TD>
					<TD><INPUT TYPE="text" NAME="mn"></TD>
				</TR>
				<TR>
					<TD>Address:</TD>
					<TD><TEXTAREA NAME="add" ROWS="" COLS=""></TEXTAREA></TD>
				</TR>
				<TR>
					<TD>DOB:</TD>
					<TD><INPUT TYPE="Date" NAME="db"></TD>
				</TR>
				<TR>
					<TD>Gender:</TD>
					<TD><INPUT TYPE="radio" NAME="m" value="male">Male<INPUT
						TYPE="radio" NAME="m" value="female">Female</TD>
				</TR>
				<TR>
					<TD>Type of Account:</TD>
					<TD><INPUT TYPE="radio" NAME="acctype" value="sb">SB<INPUT
						TYPE="radio" NAME="acctype" value="fd">FD<BR> <INPUT
						TYPE="radio" NAME="acctype" value="ca">CA<INPUT
						TYPE="radio" NAME="acctype" value="rd">RD<BR></TD>
				</TR>

				<tr>
					<td>Enter the Amount (minimum 1000 Rs)</td>
					<td><input type="text" name="en"></td>
				</tr>
				<TR>
					<TD>PASSWORD:</TD>
					<TD><INPUT TYPE="password" name="pwd"></TD>

				</TR>
				<TR>
					<TD>RE-TYPE PASSWORD:</TD>
					<TD><INPUT TYPE="password" name="pwd1"></TD>

				</TR>
				<tr>
					<td></td>
					<td><input type="submit" name="submit" value="Register"
						onclick="return myvalid()"> &nbsp;&nbsp;&nbsp;<input
						type="reset" value="RESET"><br>
					<br>
					<a href="login.jsp">Already Registered Login</a></td>
				</tr>

			</TABLE>


		</FORM>
		<%
			String errormsg = (String) request.getAttribute("msg");
			if (errormsg != null) {
		%>
		<font><%=errormsg%> </font>

		<%
			}
		%>
	</center>


</BODY>
</html>
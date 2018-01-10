<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FF33FF">
<% String name=(String)session.getAttribute("un"); %>
<p align="right"><%=name%>
<p align="right"><a href="log">LogOut</a></p>
<form action="DisplayName.jsp">
<p align="left"><input type="submit" value="Home">

</form>
<% String ref= (String)session.getAttribute("tid");%>

<font color="Blue" size="5"> Money Transfer is Successful and Transaction ID IS: &nbsp;</font><font size="6"><%=ref %></font>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="view.jpg"  >
<% String name=(String)session.getAttribute("un"); %>
<p align="right"><%=name%>
<p align="right"><a href="log">LogOut</a></p>
<form action="DisplayName.jsp">
<p align="left">
<input type="submit" value="Home" ></p>

<h1><font color="Blue" size="8">YourBalance Rs: </font></h1>&nbsp;&nbsp;&nbsp;&nbsp;
<font color="Red">
<%= request.getAttribute("balance")%>

</font>
</form>
</body>
</html>
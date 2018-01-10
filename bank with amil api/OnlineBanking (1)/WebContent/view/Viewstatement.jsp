<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.online.bank.application.dto.TransactionDTO"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="login.jpg">

<font color="#000000" size="5">Your Transaction Between<%=request.getAttribute("startDate")%> And <%=request.getAttribute("endDate")%>
</font>
<%
	String name=(String)session.getAttribute("un");
%>
<p align="right"><%=name%>
<p align="right"><a href="log">LogOut</a></p>
<form action="DisplayName.jsp">
<p align="left"><input type="submit" value="Home">

</form>
 <%
 	ArrayList<TransactionDTO> list=(ArrayList<TransactionDTO>)request.getAttribute("list");
 %>
 <table border="2" bordercolor="#ffffff">
		<tr>
			<th>Transaction ID</th>
			<th>Description</th>
			<th>Balance</th>
			<th>Date</th>
		</tr><%
			if(list!=null){ 
			for (TransactionDTO senderdto : list) {
		%>	<tr>
		<td><%=senderdto.getTid()%></td>
			<td><%=senderdto.getDescription()%></td>
			<td><%=senderdto.getBalance()%></td>
			<td><%=senderdto.getDate()%></td>
		</tr>
		<%
			}
		}
		%>
		</table>	
</body>
</html>
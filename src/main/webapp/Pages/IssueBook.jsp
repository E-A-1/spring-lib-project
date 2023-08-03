<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>

<link rel="stylesheet" href="extStylehome.css">

</head>
<body bgcolor="8BE4F0">
<div id=form>

<a href="..\Pages\index.jsp" style="color:#1b2770" >Home </a>
<a href="..\Pages\StudentLogin.jsp"  style="float:right ">Log Out</a>


<center>
<h1 style="color:#762727" > <strong><i> Book hire portal </i></strong> </h1><hr color=#7d7a88>
<form action="BookConfirm.jsp">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td style="color:#000000" >Enter Book Name :</td>
		<td><input type="text" name="bookname" required="required"></td>
	</tr>
	<tr>
		<td style="color:#000000">Book Hire Date :</td>
		<td><input type="text" name="hireduration" required="required"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Book Hire" ></td>
	</tr>
</table>
</form>
</center>
</div>

</body>

</html>
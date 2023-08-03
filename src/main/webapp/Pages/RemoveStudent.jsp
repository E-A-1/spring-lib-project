<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="extStylehome.css">

</head>
<body>
<div id=form>

<a href="..\Pages\index.jsp" style="color:#000099" >Home </a>
<a href="..\Pages\AdminLogin.jsp"  style="float:right ">Log Out</a>
<center>
<h1 style="color:#2f1a91"> <strong><i> Remove Student </strong></i></h1>
<hr color=#7d7a88>
	<form action="RemoveStudent.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
    </tr>
    <tr>
		<td style="color:#000000">Enter Student ID :</td>
		<td><input type="text" name="studentid" required="required"></td>
	</tr>

		<td colspan="2" align="center"><input type="submit" value="Remove"></td>
	
	</tr>
</table>
</form>
</center>
</div>
</body>
</html>
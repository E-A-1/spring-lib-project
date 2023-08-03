<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Students</title>
<link rel="stylesheet" href="extStylehome.css">

</head>
<body>
<div id=form>

<a href="..\Pages\index.jsp" style="color:#000099" >Home </a>
<a href="..\Pages\AdminLogin.jsp"  style="float:right ">Log Out</a><br>
<center>
<h1 style="color:#2f1a91"> <strong><i> All Registered Students </strong></i></h1>
</center>
<hr color=#7d7a88><center>
<%

Class.forName("com.mysql.cj.jdbc.Driver");//driver name	
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB","root","Nttdata123");

PreparedStatement stm = con.prepareStatement("select studentid,studentno,name,email,contact from student");

ResultSet rs=stm. executeQuery();
%>

<TABLE BORDER="1">
      <TR>
      <TH style="color:#000000">Student ID</TH>
      <TH style="color:#000000">Student no</TH>
      <TH style="color:#000000">Name</TH>
      <TH style="color:#000000">E-Mail</TH>
      <TH style="color:#000000">Contact</TH>

      </TR>
      <% while(rs.next()){ %>
      <TR>
       <TD style="color:#000099"> <%= rs.getInt(1) %></TD>
       <TD style="color:#000099"> <%= rs.getInt(2) %></TD>
       <TD style="color:#000099"> <%= rs.getString(3) %></TD>
       <TD style="color:#000099"> <%= rs.getString(4) %></TD>
       <TD style="color:#000099"> <%= rs.getInt(5) %></TD>
      </TR>
      <% } %>
     </TABLE>
</center>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Books</title>
<link rel="stylesheet" href="extStylehome.css">

</head>


<body>
<div id=form>

<a href="..\Pages\index.jsp" style="color:#131e57" >Home </a>
<a href="..\Pages\StudentLogin.jsp"  style="float:right ">Log Out</a>
<center>
<h1 style="color:#762727"> <strong><i> All Books </strong></i></h1>
</center>
<hr color="red">
<center>
<%

Class.forName("com.mysql.cj.jdbc.Driver");//driver name	
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB","root","Nttdata123");

PreparedStatement stm = con.prepareStatement("select * from bookdetails");

ResultSet rs=stm. executeQuery();
%>

<TABLE BORDER="1">
      <TR>
      <TH style="color:#f0fa23">Book Name</TH>
      <TH style="color:#f0fa23">Isbn</TH>
      <TH style="color:#f0fa23">Author</TH>
      <TH style="color:#f0fa23">Publisher</TH>
      <TH style="color:#f0fa23">Edition</TH>
      <TH style="color:#f0fa23">Price</TH>
      <TH style="color:#f0fa23">Quantity</TH>

      </TR>
      <% while(rs.next()){ %>
      <TR>
       <TD style="color:#060c2e"> <%= rs.getString(1) %></TD>
       <TD style="color:#060c2e"> <%= rs.getInt(2) %></TD>
       <TD style="color:#060c2e"> <%= rs.getString(3) %></TD>
       <TD style="color:#060c2e"> <%= rs.getString(4) %></TD>
       <TD style="color:#060c2e"> <%= rs.getString(5) %></TD>
       <TD style="color:#060c2e"> <%= rs.getInt(6) %></TD>
       <TD style="color:#060c2e"> <%= rs.getInt(7) %></TD>
      </TR>
      <% } %>
     </TABLE>
</center>
</div>
</body>
</html>
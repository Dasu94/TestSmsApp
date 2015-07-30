<%--
  Created by IntelliJ IDEA.
  User: dasuni
  Date: 7/30/15
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="hms.smsApp.repository.BookRepositoryMysqlDBlmpl"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>

<h2 align="center"><strong>ABCD Library</strong></h2>
<table align="center" cellpadding="5" cellspacing="5" border="0.5">
  <tr>

  </tr>
  <tr bgcolor="#3399FF">
    <td><b>id</b></td>
    <td><b>Book name</b></td>
    <td><b>Author</b></td>
    <td><b>ISBN Number</b></td>
    <td><b>Availability</b></td>
  </tr>
  <%
    try{

      BookRepositoryMysqlDBlmpl bookRepositoryMysqlDBlmpl = new BookRepositoryMysqlDBlmpl();
      ResultSet resultSet = bookRepositoryMysqlDBlmpl.viewAll();

      while(resultSet.next()){
  %>
  <tr bgcolor="#33CCFF">

    <td><%=resultSet.getString("id") %></td>
    <td><%=resultSet.getString("name") %></td>
    <td><%=resultSet.getString("author") %></td>
    <td><%=resultSet.getString("isbn") %></td>
    <td><%=resultSet.getString("isAvailable") %></td>

  </tr>

  <%
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  %>
</table>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dasuni
  Date: 7/30/15
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="hms.smsApp.domain.Book" %>
<%@page import="hms.smsApp.repository.BookRepositoryMysqlDBlmpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

<%


    if (request.getParameter("id") != "" && request.getParameter("bookName") != "" && request.getParameter("author")
            != "" && request.getParameter("isbn") != "") {


        int id = Integer.parseInt(request.getParameter("id"));
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        Book book1 = new Book(id, bookName, author, isbn, true);

        BookRepositoryMysqlDBlmpl bookRepositoryMysqlDBlmpl = new BookRepositoryMysqlDBlmpl();
        bookRepositoryMysqlDBlmpl.createBook(book1);
        response.sendRedirect("Home.jsp");
    } else {
        request.setAttribute("errorMessage", "Please enter correct data");
        response.sendRedirect("index.jsp");
    }


%>

</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1 align="center">Add book</h1>

<table align="center">

    <form action="AddBook.jsp" method="post">
        <tr>
            <td>

                ID:<br>
                <input type="text" name="id">
                <br>

                Book name:<br>
                <input type="text" name="bookName">
                <br>

                Author:<br>
                <input type="text" name="author">
                <br>

                ISBN number:<br>
                <input type="text" name="isbn">
                <br>

                <br>
                <input type="submit" value="Submit" align="center">

            </td>
        </tr>
    </form>


</table>

</body>
</html>



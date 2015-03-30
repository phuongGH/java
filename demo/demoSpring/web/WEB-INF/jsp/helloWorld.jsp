<%-- 
    Document   : helloWord
    Created on : Jul 5, 2014, 1:59:06 PM
    Author     : AA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br/>
        a value: ${a}
        <br/>
            Product information:<br/>
            product ID: ${aa.IDProduct}<br/>
        
        <br>
        List product: <br>
    <c:forEach var="p" itemps="${lp}">
        Product ID: ${p.IDProduct}<br/>
    </c:forEach>
</html>

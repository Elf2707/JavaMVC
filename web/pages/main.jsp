<%-- 
    Document   : main
    Created on : Mar 7, 2015, 7:03:06 PM
    Author     : Elf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyLibrary</title>
        <link rel='stylesheet' href='styles_main.css' type='txt/css'/>
    </head>
    <body>
        <h1><%= request.getParameter("userName") %></h1>
        <c:out value="${userPassword}"/>
    </body>
</html>

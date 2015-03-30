<%-- 
    Document   : index
    Created on : Mar 7, 2015, 7:00:29 PM
    Author     : Elf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добро пожаловать</title>
        <link rel='stylesheet' href='styles_index.css' type='txt/css'/>
    </head>
    <body>
        <div name="Greating">
            <h1>Приветствую Вас в онлайн библиотеке</h1>
            <h1>зарегистрируйтесь пожалуйста</h1>
        </div>
        <div class="registration">
            <form name="registration_form" action="main.jsp" method="POST">
                <input type="text" name="userName" value="Имя пользователя" size="20" />
                <input type="password" name="userPassword" value="qqqqqqqq" size="20" />
                <input type="submit" value="login" name="Вход" />
            </form>
        </div>
    </body>
</html>

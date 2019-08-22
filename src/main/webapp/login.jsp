<%--
  Created by IntelliJ IDEA.
  User: Smilez
  Date: 2019-08-21
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Screen</title>
</head>
<body>
<h3>Enter login information</h3>
<form action="./login.jsp" method="post">
    <label for="userId">Username: </label>
    <input id="userId" type="text" name="username" placeholder="enter username"/>
    <br>
    <label for="userPass">Password:</label>
    <input id="userPass" type="password" name="userpass" placeholder="enter password"/>
    <br>
    <input type="submit" value="submit">
</form>

<c:if test="${param.username == 'admin' && param.userpass == 'password'}">
    <%response.sendRedirect("/profile.jsp");%>
        </c:if>
</body>
</html>

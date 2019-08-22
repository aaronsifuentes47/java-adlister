<%--
  Created by IntelliJ IDEA.
  User: Smilez
  Date: 2019-08-22
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create an Ad: </h2>
<form action="${pageContext.request.contextPath}/ads/index.jsp" method="post">
    <label for="adNum">ad ID: </label>
    <input id="adNum" type="number" name="adId">
    <label for="userId">user ID: </label>
    <input id="userId" type="number" name="userId">
    <label for="title">Ad Title: </label>
    <input id="title" type="text" name="title">
    <label for="desc"></label>
    <input id="desc" type="text" name="description">
    <button type="submit">submit</button>
</form>

</body>
</html>
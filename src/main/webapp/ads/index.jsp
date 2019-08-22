<%--
  Created by IntelliJ IDEA.
  User: Smilez
  Date: 2019-08-22
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>
<h1>Here are all the products:</h1>

<c:forEach var="ad" items="${ads}">
    <div class="product">
        <h1>${ad.title}</h1>
        <p>Description: ${ad.description}</p>
    </div>
</c:forEach>

</body>
</html>
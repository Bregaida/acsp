<%--
  Created by IntelliJ IDEA.
  Date: 8/9/13
  Time: 10:23 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h3>Message : ${message}</h3>
<h3>Username : ${username}</h3>

<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>

</body>
</html>
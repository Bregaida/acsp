<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp"/>

<div class="jumbotron">
    <c:url value="/resources/img/logoACSP.png" var="logo" />
    <img src="${logo}" class="img-responsive" alt="Responsive image">
    <h1>Aeroclube de São Paulo</h1>
    <p>Olá <c:out value="${pageContext.request.remoteUser}"/>!</p>
    <p><a href="https://github.com/Bregaida/acsp" class="btn btn-primary btn-lg">Projeto</a></p>
</div>

<jsp:include page="../includes/footer.jsp"/>
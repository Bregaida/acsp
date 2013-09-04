<%@ page isErrorPage = "true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../includes/header.jsp"/>

<div class="row">
    <div class="col-lg-8">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <div class="panel-title">Houve um problema.</div>
            </div>
            <div class="panel-body">
                <c:out value="${status}"></c:out><br/>
                <c:out value="${reason}"></c:out><br/>
                <c:out value="${name}"></c:out><br/>
                <c:out value="${exception}"></c:out><br/>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../includes/footer.jsp"/>
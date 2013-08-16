<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Novo Sócio</title>
</head>
<body>
    <form:form id="socio" method="POST" commandName="socio" >
		<c:forEach var="error" items="${errors}">
    		${error.category} - ${error.message}<br />
		</c:forEach>
		<table>
			<tr>
				<td>Nome</td>
				<td><form:input path="nome" /> </td>
			</tr>
			<tr>
				<td>RG</td>
				<td><form:input path="rg" /> </td>
			</tr>
			<tr>
				<td>CPF</td>
				<td><form:input path="cpf" /> </td>
			</tr>
			<tr>
				<td>Nome da Pista</td>
				<td><form:input path="nomePista" /> </td>
			</tr>
			<tr>
				<td>CMA</td>
				<td><form:input path="cma" /> </td>
			</tr>
			<tr>
				<td>CHT</td>
				<td><form:input path="cht" /> </td>
			</tr>
			<tr>
				<td>Codigo ANAC</td>
				<td><form:input path="codigoANAC" /> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar" /> </td>
			</tr>		
		</table>
	</form:form>
</body>
</html>
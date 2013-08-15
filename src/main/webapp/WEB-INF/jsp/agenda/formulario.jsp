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
<title>Agenda</title>
</head>
<body>
    <form:form action="agendar" id="agenda" method="POST" commandName="agenda" >
		<c:forEach var="error" items="${errors}">
    		${error.category} - ${error.message}<br />
		</c:forEach>
		
		
		<table>
			<tr>
				<td>Data DD/MM</td>
				<td><form:input path="dataReserva" /> </td>
			</tr>
			<tr>
				<td>Aeronaves</td>
				<td>
					<%-- <form:select path="aeronave" id="aeronave" items="${vars.aeronaves}" itemValue="id" itemLabel="modelo" /> --%>
				</td>
			</tr>
			<tr>
				<td>Horas Disponíveis</td>
				<td>
				<%--<form:select path="aeronave" id="aeronave" items="${vars.aeronaves}" itemValue="id" itemLabel="modelo" /> --%>	
			 </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Agendar" /> </td>
			</tr>		
		</table>
	</form:form>
</body>
</html>
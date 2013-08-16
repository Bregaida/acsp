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
<title>Aeronave</title>
</head>
<body>
    <form:form id="aeronave" method="POST" commandName="aeronave" >
		<c:forEach var="error" items="${errors}">
    		${error.category} - ${error.message}<br />
		</c:forEach>
		<table>
			<tr>
				<td>Certificado de Matrícula</td>
				<td><form:input path="certificadoMatricula" /> </td>
			</tr>
			<tr>
				<td>Marca</td>
				<td><form:input path="marca" /> </td>
			</tr>
			<tr>
				<td>Modelo</td>
				<td><form:input path="modelo" /> </td>
			</tr>
			<tr>
				<td>DENTEL</td>
				<td><form:input path="dentel" /> </td>
			</tr>
			<tr>
				<td>FIAM</td>
				<td><form:input path="fiam" /> </td>
			</tr>
			<tr>
				<td>Apólice de Seguro</td>
				<td><form:input path="apoliceSeguro" /> </td>
			</tr>
			<tr>
				<td>Possui Ficha de Balanceamento?</td>
				<td><form:checkbox path="fichaPesoBalanceamento" /> </td>
			</tr>
			<tr>
				<td>Possui Manual de Vôo?</td>
				<td><form:checkbox path="manualVoo" /> </td>
			</tr>
			<tr>
				<td>Possui Check List?</td>
				<td><form:checkbox path="checkList" /> </td>
			</tr>
			<tr>
				<td>Possui NSCA 3-5?</td>
				<td><form:checkbox path="nsca3_5" /> </td>
			</tr>
			<tr>
				<td>Possui NSCA 3-7?</td>
				<td><form:checkbox path="nsca3_7" /> </td>
			</tr>
			<tr>
				<td>Possui Diário de Bordo?</td>
				<td><form:checkbox path="diarioBordo" /> </td>
			</tr>
			<tr>
				<td>Aeronave Ativa?</td>
				<td><form:checkbox path="ativo" /> </td>
			</tr>
			<tr>
				<td>Motivo da inatividade</td>
				<td><form:checkbox path="motivoInatividade" /> </td>
			</tr>
			<!-- tr>
				<td>Aulas Homologadas</td>
				<td><form:select items="aulas" /> </td>
			</tr -->
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar" /> </td>
			</tr>		
		</table>
	</form:form>
</body>
</html>
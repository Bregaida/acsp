<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Lista de Sócios</title>
</head>
<body>
	<table>
		<c:forEach var="instrutor" items="${listaDeInstrutores}">
			<tr>
                <td>ID do Instrutor:</td> <td>${instrutor.id}</td>
				<td>Nome do Instrutor:</td> <td>${instrutor.nome }</td>
				<td>${instrutor.cma }</td>
				<td>${instrutor.cht }</td>
				<td>${instrutor.codigoANAC }</td>
			    <td><a href="http://localhost:8080/acsp/instrutor/${instrutor.id}">EDITAR</a>  ||  </td>
                <td><a href="http://localhost:8080/acsp/instrutor/${instrutor.id}/apaga">APAGA</a></td>
			</tr>
		</c:forEach>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/instrutor">Adicionar</a>
</body>

</html>
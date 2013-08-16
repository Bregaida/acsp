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
		<c:forEach var="socio" items="${listaDeSocios}">
			<tr>
                <td>ID do Socio:</td> <td>${socio.id}</td>
				<td>Nome do Sócio:</td> <td>${socio.nome }</td>
				<td>${socio.codigoANAC }</td>
				<td>${socio.rg }</td>
				<td>${socio.cpf }</td>
                <td><a href="http://localhost:8080/acsp/socio/${socio.id}">EDITAR</a>  ||  </td>
                <td><a href="http://localhost:8080/acsp/socio/${socio.id}/apaga">APAGA</a></td>
			</tr>
		</c:forEach>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/socio">Adicionar</a>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Lista de Aulas</title>
</head>
<body>
	<table>
		<c:forEach var="aula" items="${listaDeAulas}">
			<tr>
                <td>ID da Aula:</td> <td>${aula.id}</td>
				<td>Materia:</td> <td>${aula.materia }</td>
				<td>${aula.quantidadeHorasNecessarias }</td>
				<td>${aula.aeronave.modelo }</td>
                <td><a href="http://localhost:8080/acsp/aula/${aula.id}">EDITAR</a>  ||  </td>
                <td><a href="http://localhost:8080/acsp/aula/${aula.id}/apaga">APAGA</a></td>
			</tr>
		</c:forEach>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/aula">Adicionar</a>
</body>

</html>
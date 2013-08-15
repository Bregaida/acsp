<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Lista de Alunos</title>
</head>
<body>
	<table>
		<c:forEach var="aluno" items="${listaDeAlunos}">
			<tr>
                <td>ID do Aluno:</td> <td>${aluno.id}</td>
				<td>Nome do Aluno:</td> <td>${aluno.nome }</td>
				<td>${aluno.codigoANAC }</td>
				<td>${aluno.rg }</td>
				<td>${aluno.cpf }</td>
                <td><a href="http://localhost:8080/acsp/aluno/${aluno.id}">EDITAR</a>  ||  </td>
                <td><a href="http://localhost:8080/acsp/aluno/${aluno.id}/apaga">APAGA</a></td>
			</tr>
		</c:forEach>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/aluno">Adicionar</a>
</body>

</html>
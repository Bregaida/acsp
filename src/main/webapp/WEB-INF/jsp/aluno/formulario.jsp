<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Novo Aluno</title>
</head>
<body>
	<c:url var="salvar" value="/aluno/salvar" />
	<form action="${salvar }" method="post">
		<c:forEach var="error" items="${errors}">
    		${error.category} - ${error.message}<br />
		</c:forEach>
		<table>
			<tr>
				<td>Nome</td>
				<td><input name="alunoForm.aluno.nome" /> </td>
			</tr>
			<tr>
				<td>RG</td>
				<td><input name="alunoForm.aluno.rg" /> </td>
			</tr>
			<tr>
				<td>CPF</td>
				<td><input name="alunoForm.aluno.cpf" /> </td>
			</tr>
			<tr>
				<td>Codigo ANAC</td>
				<td><input name="alunoForm.aluno.codigoANAC" /> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar" /> </td>
			</tr>		
		</table>
	</form>
</body>
</html>
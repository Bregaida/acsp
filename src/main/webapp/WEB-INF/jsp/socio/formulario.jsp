<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="../../includes/header.jsp"/>
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
<c:import url="../../includes/footer.jsp"/>
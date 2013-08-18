<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>
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
<c:import url="../../includes/footer.jsp"/>
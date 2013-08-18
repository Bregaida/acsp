<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="aeronave" method="POST" commandName="aeronave" >
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
            <td><form:checkbox path="fichaPesoBalanceamento" value="true"/> </td>
        </tr>
        <tr>
            <td>Possui Manual de Vôo?</td>
            <td><form:checkbox path="manualVoo" value="true"/> </td>
        </tr>
        <tr>
            <td>Possui Check List?</td>
            <td><form:checkbox path="checkList"value="true" /> </td>
        </tr>
        <tr>
            <td>Possui NSCA 3-5?</td>
            <td><form:checkbox path="nsca3_5" value="true"/> </td>
        </tr>
        <tr>
            <td>Possui NSCA 3-7?</td>
            <td><form:checkbox path="nsca3_7" value="true"/> </td>
        </tr>
        <tr>
            <td>Possui Diário de Bordo?</td>
            <td><form:checkbox path="diarioBordo" value="true"/> </td>
        </tr>
        <tr>
            <td>Aeronave Ativa?</td>
            <td><form:checkbox path="ativo" value="true" /> </td>
        </tr>
        <tr>
            <td>Motivo da inatividade</td>
            <td><form:input path="motivoInatividade" /> </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <div class="btn-group">
                    <button type="button" class="btn btn-default">Limpar</button>
                    <button type="submit" class="btn btn-default">Enviar</button>
                </div>
            </td>
        </tr>
    </table>
</form:form>
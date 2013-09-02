<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="Sucesso" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header alert alert-success">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Sucesso</h4>
            </div>
                <div class="modal-body">
                    <c:out value="${msgSucesso}" />
                </div>
                <div class="modal-footer">
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-success" id="btnSuccess" data-dismiss="modal">Ok</button>
                    </div>
                </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

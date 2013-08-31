function aplicarObjetoNoFormulario(obj, formId){
    var properties = [];
    for(var key in obj) {
        if(obj.hasOwnProperty(key) && typeof obj[key] !== 'function') {
            properties.push(key);
        }
    }
    var selector = "form" + formId + " :input";
    $(selector).each(function(){
        var input = $(this);// This is the jquery object of the input
        var attrName = input.attr('name');
        var attrType = input.attr('type');
        var isObject = false;
        if (attrName != undefined && attrName.indexOf('.') !== -1) {
            isObject = true;
            attrName = attrName.split('.')[0];
        }
        if(obj[attrName] != undefined && obj[attrName] != null){
            if (attrType === 'checkbox') { //TODO - implementar casos de radio button!
                input.prop('checked', obj[attrName]);
            } else {
                if (isObject) {
                    input.val(obj[attrName].id);
                } else {
                    input.val(obj[attrName]);
                }
            }
        }
    });
}

function getSingular(valor){
    //TODO: Fazer ficar mais bonito... assim ta bom por enquanto
    var irregulares = new Array();
    irregulares['/acsp/aeronaves'] = "/acsp/aeronave";
    irregulares['/acsp/atendentes'] = "/acsp/atendente";

    var singular;
    if(irregulares.hasOwnProperty(valor)){
        singular = irregulares[valor];
    }
    else if (valor.substr(-2) === 'es') {
        singular = valor.slice(0, -2);
    } else if (valor.substr(-1) === 's') {
        singular = valor.slice(0, -1);
    }
    return singular;
}

$('#myModal').on('hidden.bs.modal', function () {
    $(this).find('#nome').removeAttr('disabled');
    $(this).find('form')[0].reset();
});

$('.editaAction').click(function(e) {
    var id = $(this).closest('tr').attr('id');
    var $form = $('#myModal form');
    $form[0].reset();
    var action = getSingular($form.attr('action'));
    $.ajax({
        url: action + '/' + id
    }).done(function(returnObject) {
        aplicarObjetoNoFormulario(returnObject, "#" + $form.attr('id'));
        $('#myModal').modal('show');
    });
});

$('.apagaAction').click(function(e) {
    var $tr = $(this).closest('tr');
    var action = $('#myModal form').attr('action');
    bootbox.confirm('Confirma remoção?', function (result) {
        if (result) {
            var id = $tr.attr('id');
            action = getSingular(action);
            $.ajax({
                url: action + '/' + id + "/apaga"
            }).done(function() {
                $tr.remove();
            });
        }
    });
});

$('.insereAction').click(function(e) {
    var formRef = $('#myModal form');
    var actionVal = getSingular(formRef.attr('action'));
    formRef.attr('action', actionVal);
    formRef.submit();
});

$('.cpf').focusout(function() {
    var cpf = $(this).val();
    var qtd = cpf.length;
    var formId = $(this).closest('form').attr('id');
    if(qtd == 14){
        $.ajax({
            url: '/acsp/pessoa/' + cpf.replace(/\./g,'').replace(/-/g,'')
        }).done(function(returnObject) {
            aplicarObjetoNoFormulario(returnObject, "#" + formId);
        });
    }
});

/**
 * Inicialização do DataTables
 */
$('.table').dataTable();

/**
 * Máscaras
 */
$(document).ready(function(){
    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.date').mask('11/11/1111');
    $('.time').mask('00:00:00');
    $('.date_time').mask('00/00/0000 00:00:00');
    $('.cep').mask('00000-000');
    $('.phone').mask('0000-0000');
    $('.phone_with_ddd').mask('(00) 0000-0000');
    $('.phone_us').mask('(000) 000-0000');
    $('.mixed').mask('AAA 000-S0S');
    $('.money').mask('000.000.000.000.000,00', {reverse: true});
});

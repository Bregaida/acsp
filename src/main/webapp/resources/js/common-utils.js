function aplicarObjetoNoFormulario(obj, formId){
    var properties = [];
    for(var key in obj) {
        if(obj.hasOwnProperty(key) && typeof obj[key] !== 'function') {
            properties.push(key);
        }
    }
    var selector = "form" + formId + " :input";
    $(selector).each(function() {
        var input = $(this);// This is the jquery object of the input
        var attrName = input.attr('name');
        var attrType = input.attr('type');
        if (input.is('select')) {
            attrName = attrName.split('.')[0];
            var valueSelected = (obj[attrName] instanceof Object)?obj[attrName].id : obj[attrName];
            var selector = '#' + attrName;
            $(selector).val(valueSelected);
        } else if (obj[attrName] != undefined && obj[attrName] != null) {
            if (attrType === 'checkbox') { //TODO - implementar casos de radio button!
                if (obj[attrName] instanceof Array) {
                    $.each(obj[attrName], function(key, value) {
                        if (input.val() == value.id) {
                            input.prop('checked', true);
                        }
                    });
                } else {
                    input.prop('checked', obj[attrName]);
                }
            } else {
                input.val(obj[attrName]);
            }
        }
    });
}

$('body').on('hidden.bs.modal', '.modal', function () {
    if ($(this).find('#btnSuccess').length !== 0) {
        window.location.reload();
    }
    $(this)
        .find('[id*=".errors"]').remove().end()
        .find('form')[0].reset();
});

$('.modal').on('click', 'button[type="reset"]', function (e) {
    $(this).parents('.modal').find('[id*=".errors"]').remove();
});

$('.modal').on('click', '.insereAction', function(e) {
    var formRef = $(this).closest('form');
    var actionVal = formRef.attr('action');

    $.post(actionVal, formRef.serialize(), function(result) {
        $('.modal:visible').html($(result).filter('.modal').html());
    });
});

$('.editaAction').click(function(e) {
    var id = $(this).closest('tr').attr('id');
    var $form = $('#myModal form');
    editAction(id, $form);
});

$('.aeronaveAction').click(function(e) {
    var id = $(this).closest('tr').attr('id');
    var $form = $('#aeronaveModal form');
    var urlAction = $form.attr('action');
    editAction(id, $form, urlAction.substring(0, urlAction.lastIndexOf('/')) + '/' + id);
});

function editAction(id, form, urlAction) {
    form[0].reset();
    var action = urlAction || form.attr('action') + '/' + id;
    $.ajax({
        url: action
    }).done(function(returnObject) {
            aplicarObjetoNoFormulario(returnObject, "#" + form.attr('id'));
            form.closest('.modal').modal('show');
        });
};

$('.apagaAction').click(function(e) {
    var $tr = $(this).closest('tr');
    var action = $('#myModal form').attr('action');
    bootbox.confirm('Confirma remoção?', function (result) {
        if (result) {
            var id = $tr.attr('id');
            $.ajax({
                url: action + '/' + id + "/apaga"
            }).done(function(result) {
                    if (result === 'SUCCESS') {
                        //Se em algum momento existir mais de uma tabela dataTable este metodo deve ser retestado!
                        var table = $.fn.dataTable.fnTables(true);
                        if ( table.length > 0 ) {
                            $(table).dataTable().fnDeleteRow( $tr[0] );
                        }
                    } else {
                        //TODO - melhorar layout das msg de erro
                        bootbox.alert(result);
                    }
                });
        }
    });
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

$( ".datepicker-input" ).datepicker({
    format: "dd/mm/yyyy",
    todayBtn: "linked",
    language: "pt-BR",
    todayHighlight: true,
    autoclose: true
});

/**
 * Inicialização do DataTables
 */
$('.datatabled').dataTable();

$(document).ready(function(){

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

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

    //http://arshaw.com/fullcalendar/
    $('#calendar').fullCalendar({
        defaultView: 'agendaDay',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        allDaySlot :false,
        allDayText: 'dia-todo',
        buttonText: {
            prev:     '&lsaquo;', // <
            next:     '&rsaquo;', // >
            prevYear: '&laquo;',  // <<
            nextYear: '&raquo;',  // >>
            today:    'hoje',
            month:    'mês',
            week:     'semana',
            day:      'dia'
        },
        editable: false,
        columnFormat:{
            month: 'ddd',    // Mon
            week: 'ddd d/M', // Mon 9/7
            day: 'dddd d/M'  // Monday 9/7
        },

        agenda: 'HH:mm{ - HH:mm}',
        timeFormat: 'HH:mm',
        axisFormat : 'HH:mm',

        height: 450,
        minTime: 7,
        maxTime: 22,

        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
            'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
        monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],

        dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta','Quinta', 'Sexta', 'Sábado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],

        dayClick: function(date) {
            $('#agendaModalBtn').click();
            $('#dataReservaId').val(date.toLocaleDateString());
            var timeString = date.toLocaleTimeString().split(':')[0];
            $('#horario option').filter(function() {
                return ($(this).text().indexOf(timeString)!=-1);
            }).prop('selected', true);
        },

        events: '/acsp/agenda/ajax',

        eventClick: function(calEvent, jsEvent, view) {
            editAction(calEvent.id, $('#agenda'));
        },
        eventMouseover: function(calEvent, jsEvent, view) {
            //console.log("-> " + calEvent.id);
        },
        eventMouseout: function(calEvent, jsEvent, view) {
            //console.log("<- " + calEvent.id);
        }
    })
});

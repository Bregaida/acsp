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
            var values = [],
                objects = [].concat(obj[attrName]);
            $.each(objects, function(key, value) {
                values.push(value.id);
            });
            input.val(values);

        } else if (obj[attrName] != undefined && obj[attrName] != null) {
            if (attrType === 'checkbox') { //TODO - implementar casos de radio button!
                input.prop('checked', obj[attrName]);
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
    var formRef = $('#myModal form');
    var actionVal = formRef.attr('action');

    $.post(actionVal, formRef.serialize(), function(result) {
        $('.modal').html($(result).filter('.modal').html());
    });
});

$('.editaAction').click(function(e) {
    var id = $(this).closest('tr').attr('id');
    var $form = $('#myModal form');
    $form[0].reset();
    var action = $form.attr('action');
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

$('#actionAgendar').click(function(){
    bootbox.alert('Abre tela de agendamento');
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
        defaultView: 'agendaWeek',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
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
        editable: true,
        columnFormat:{
            month: 'ddd',    // Mon
            week: 'ddd d/M', // Mon 9/7
            day: 'dddd d/M'  // Monday 9/7
        },

        agenda: 'h:mm{ - h:mm}',

        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
            'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],

        timeFormat: 'H(:mm)',

        dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta','Quinta', 'Sexta', 'Sábado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],

        // put your options and callbacks here
        //dayClick: function() {
          //  alert('a day has been clicked!');
        //},
        events: [
            {
                title  : 'Thomáz Turbando',
                start  : '2013-08-31 09:00:00',
                end  : '2013-08-31 10:00:00',
                allDay : false
            },
            {
                title  : 'Timelo Rego',
                start  : '2013-08-29 09:00:00',
                end    : '2013-08-29 11:00:00',
                allDay : false
            },
            {
                title  : 'Vinci Comer',
                start  : '2013-08-31 14:00:00',
                end    : '2013-08-31 15:00:00',
                allDay : false // will make the time show
            },
            {
                title  : 'Santos Bregaida',
                start  : '2013-09-01 14:00:00',
                end    : '2013-09-01 15:00:00',
                allDay : false // will make the time show
            },
            {
                title  : 'Lord Vader    ',
                start  : '2013-09-01 15:00:00',
                end    : '2013-09-01 16:00:00',
                allDay : false // will make the time show
            }
        ],

        eventClick: function(calEvent, jsEvent, view) {

            alert('Event: ' + calEvent.title);
            alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
            alert('View: ' + view.name);

            // change the border color just for fun
            $(this).css('border-color', 'red');
        }
    })
});

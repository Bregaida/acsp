$(document).ready(function(){

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    /*
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
    */

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

        },

        events: '/acsp/agenda',

        eventClick: function(calEvent, jsEvent, view) {
            alert("Event: " + calEvent.id);
        },
        eventMouseover: function(calEvent, jsEvent, view) {
            //console.log("-> " + calEvent.id);
        },
        eventMouseout: function(calEvent, jsEvent, view) {
            //console.log("<- " + calEvent.id);
        }
    })
});
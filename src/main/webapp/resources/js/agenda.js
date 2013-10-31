
appContextRoot = "/" + location.pathname.split("/")[1];

$(document).ready(function() {

    $('#aluno').change(function() {
        var options = $('#aeronave').filter(':visible')
            .prop("disabled", false)
            .empty()
            .prop('options');

        $.getJSON(appContextRoot + "/aeronave/disponiveis/" + $(this).val(), {dataReserva : $('#dataReservaId').val()},
            function(data) {
                options[options.length] = new Option('--- Selecione ---', '');
                if (data.length === 0) {
                    bootbox.alert('Nenhuma aeronave cadastrada para este aluno.');
                } else {
                    $.each(data, function(val, text) {
                        //noinspection JSUnresolvedVariable
                        options[options.length] = new Option($.trim(text.certificadoMatricula + ' ' + text.modelo), text.id);
                    });
                }
            });
    });

	$("#aeronave").change(function() {
    	var options = $('#horario').filter(':visible')
		.prop("disabled", false)
		.empty()
		.prop('options');

		$.getJSON(appContextRoot + "/horario/disponiveis/" + $(this).val(), {dataReserva : $('#dataReservaId').val()},
            function(data) {
                options[options.length] = new Option('--- Selecione ---', '');
                if (data.length === 0) {
                    bootbox.alert('Nenhuma horario disponivel para esta aeronave.');
                } else {
                    $.each(data, function(val, text) {
                        //noinspection JSUnresolvedVariable
                        options[options.length] = new Option($.trim(text.horarioAgenda), text.id);
                    });
                }
		});

        //TODO - filtrar aulas que esta aeronave pode fazer
    });
	
	$("#aula").change(function() {
    	var options = $('#instrutor').filter(':visible')
		.prop("disabled", false)
		.empty()
		.prop('options');

		$.getJSON(appContextRoot + "/instrutor/disponiveis/" + $('#horario').val() + "/" + $('#aeronave').val() + "/" + $(this).val(), {dataReserva : $('#dataReservaId').val()},
            function(data) {
                $.each(data, function(val, text) {
                    //noinspection JSUnresolvedVariable
                    options[options.length] = new Option($.trim(text.nome), text.id);
                });
		});
    });

	
	

});
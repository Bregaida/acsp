
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
        var idAeronave = $(this).val();

        $.getJSON(appContextRoot + "/horario/disponiveis/" + idAeronave, {dataReserva : $('#dataReservaId').val()},
            function(data) {
                options[options.length] = new Option('--- Selecione ---', '');
                if (data.length === 0) {
                    bootbox.alert('Nenhuma horario disponivel para esta aeronave.');
                } else {
                    $.each(data, function(val, text) {
                        //noinspection JSUnresolvedVariable
                        options[options.length] = new Option($.trim(text.horarioAgenda), text.id);
                    });

                    //Se existe horario, busca Aulas
                    options = $('#aula').filter(':visible')
                        .prop("disabled", false)
                        .empty()
                        .prop('options');

                    $.getJSON(appContextRoot + "/aula/disponiveis/" + idAeronave,
                        function(data) {
                            options[options.length] = new Option('--- Selecione ---', '');
                            if (data.length === 0) {
                                bootbox.alert('Nenhuma aula cadastrada para esta aeronave.');
                            } else {
                                $.each(data, function(val, text) {
                                    //noinspection JSUnresolvedVariable
                                    options[options.length] = new Option($.trim(text.materia), text.id);
                                });
                            }
                        });
                }
		});
    });
	
	$("#aula").change(function() {
    	var options = $('#instrutor').filter(':visible')
		.prop("disabled", false)
		.empty()
		.prop('options');

		$.getJSON(appContextRoot + "/instrutor/disponiveis/" + $('#horario').val() + "/" + $('#aeronave').val(), {dataReserva : $('#dataReservaId').val()},
            function(data) {
                options[options.length] = new Option('--- Selecione ---', '');
                if (data.length === 0) {
                    bootbox.alert('Nenhum instrutor disponivel para este horario e/ou aula.');
                } else {
                    $.each(data, function(val, text) {
                        //noinspection JSUnresolvedVariable
                        options[options.length] = new Option($.trim(text.nome), text.id);
                    });
                }

		});
    });
});
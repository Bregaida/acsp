
appContextRoot = "/" + location.pathname.split("/")[1];

$(document).ready(function() {
	
	$("#aeronave").change(function() {
    	var options = $('#horario').filter(':visible')
		.prop("disabled", false)
		.empty()
		.prop('options');

		$.getJSON(appContextRoot + "/horario/disponiveis/" + $(this).val(),	{dataReserva : $('#dataReservaId').val()},
				function(data) {
					$.each(data, function(val, text) {
						//noinspection JSUnresolvedVariable
	                    options[options.length] = new Option($.trim(text.horarioAgenda), text.id);
					});
		});
    });
	
	$("#aula").change(function() {
    	var options = $('#instrutor').filter(':visible')
		.prop("disabled", false)
		.empty()
		.prop('options');

		$.getJSON(appContextRoot + "/instrutor/disponiveis/" + $('#horario').val() + "/" + $('#aeronave').val() + "/" + $(this).val(),	null,
				function(data) {
					$.each(data, function(val, text) {
						//noinspection JSUnresolvedVariable
	                    options[options.length] = new Option($.trim(text.nome), text.id);
					});
		});
    });

	
	

});
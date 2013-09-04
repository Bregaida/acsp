
appContextRoot = "/" + location.pathname.split("/")[1];

$(document).ready(function() {
	$("#aeronave").change(function() {
    	var options = $('#horario').filter(':visible')
		.prop("disabled", false)
		.empty()
		.prop('options');

		$.getJSON(appContextRoot + "/horario/disponiveis/" + $(this).val(),	null,
				function(data) {
					$.each(data, function(val, text) {
						//noinspection JSUnresolvedVariable
	                    options[options.length] = new Option($.trim(text.horarioAgenda), text.id);
					});
		});
    });

});
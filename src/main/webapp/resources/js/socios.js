function apagaSocio(id){
    $.ajax({
        url: "/acsp/socio/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemSocio(id){
    $.ajax({
        url: "/acsp/socio/" + id
    }).done(function(socio) {
        aplicarObjetoNoFormulario(socio, "#socioForm");
    });
}

// Gambeta
$('#socioModalBtn').click(function(){
    $('#socioForm')[0].reset();
    $('#socioForm').attr('action', '/acsp/socio');
});

$('.editaSocioAction').click(function(event){
    var socioId = $(this).attr('socioId');
    $('#socioModalBtn').trigger('click');
    obtemSocio(socioId);
    $('#socioForm').attr('action', '/acsp/socio/' + socioId);
});

$('.apagaSocioAction').click(function(event){
    var socioId = $(this).attr('socioId');
    var nome = $("#socioNome" + socioId).text();
    var confirmed = window.confirm("Confirma remocao do socio " + nome);
    if(confirmed){
        apagaSocio(socioId);
    }
    else{
        event.preventDefault();
    }
});



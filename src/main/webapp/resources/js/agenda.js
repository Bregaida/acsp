function apagaAgenda(id){
    $.ajax({
        url: "/acsp/agenda/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemAgenda(id){
    $.ajax({
        url: "/acsp/agenda/" + id
    }).done(function(atendente) {
        aplicarObjetoNoFormulario(aluno, "#agendaForm");
    });
}

// Gambeta
$('#agendaModalBtn').click(function(){
    $('#agendaForm')[0].reset();
    $('#agendaForm').attr('action', '/acsp/agenda');
});

$('.editaAgendaAction').click(function(event){
    var agendaId = $(this).attr('agendaId');
    $('#agendaModalBtn').trigger('click');
    obtemAtendente(atendenteId);
    $('#agendaForm').attr('action', '/acsp/agenda/' + atendenteId);
});

$('.apagaAtendenteAction').click(function(event){
    var agendaId = $(this).attr('agendaId');
    //var nome = $("#atendenteNome" + atendenteId).text();
    var confirmed = window.confirm("Confirma remocao do atendente ");
    if(confirmed){
        apagaAgenda(agendaId);
    }
    else{
        event.preventDefault();
    }
});



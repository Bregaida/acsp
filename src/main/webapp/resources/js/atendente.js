function apagaAtendente(id){
    $.ajax({
        url: "/acsp/atendente/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemAtendente(id){
    $.ajax({
        url: "/acsp/atendente/" + id
    }).done(function(atendente) {
        aplicarObjetoNoFormulario(aluno, "#atendenteForm");
    });
}

// Gambeta
$('#atendenteModalBtn').click(function(){
    $('#atendenteForm')[0].reset();
    $('#atendenteForm').attr('action', '/acsp/atendente');
});

$('.editaAtendenteAction').click(function(event){
    var atendenteId = $(this).attr('atendenteId');
    $('#atendenteModalBtn').trigger('click');
    obtemAtendente(atendenteId);
    $('#atendenteForm').attr('action', '/acsp/atendente/' + atendenteId);
});

$('.apagaAtendenteAction').click(function(event){
    var atendenteId = $(this).attr('atendenteId');
    var nome = $("#atendenteNome" + atendenteId).text();
    var confirmed = window.confirm("Confirma remocao do atendente " + nome);
    if(confirmed){
        apagaAtendente(atendenteId);
    }
    else{
        event.preventDefault();
    }
});



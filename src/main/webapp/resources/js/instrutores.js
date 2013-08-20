function apagaInstrutor(id){
    $.ajax({
        url: "/acsp/instrutor/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemInstrutor(id){
    $.ajax({
        url: "/acsp/instrutor/" + id
    }).done(function(instrutor) {
        aplicarObjetoNoFormulario(instrutor, "#instrutorForm");
    });
}

// Gambeta
$('#instrutorModalBtn').click(function(){
    $('#instrutorForm')[0].reset();
    $('#instrutorForm').attr('action', '/acsp/instrutor');
});

$('.editaInstrutorAction').click(function(event){
    var instrutorId = $(this).attr('instrutorId');
    $('#instrutorModalBtn').trigger('click');
    obtemInstrutor(instrutorId);
    $('#instrutorForm').attr('action', '/acsp/instrutor/' + instrutorId);
});

$('.apagaInstrutorAction').click(function(event){
    var instrutorId = $(this).attr('instrutorId');
    var nome = $("#instrutorNome" + instrutorId).text();
    var confirmed = window.confirm("Confirma remocao do instrutor " + nome);
    if(confirmed){
        apagaInstrutor(instrutorId);
    }
    else{
        event.preventDefault();
    }
});



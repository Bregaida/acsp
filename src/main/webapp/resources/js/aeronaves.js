function apagaAeronave(id){
    $.ajax({
        url: "/acsp/aeronave/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemAeronave(id){
    $.ajax({
        url: "/acsp/aeronave/" + id
    }).done(function(aeronave) {
        aplicarObjetoNoFormulario(aeronave, "#aeronaveForm");
    });
}

// Gambeta
$('#aeronaveModalBtn').click(function(){
    $('#aeronaveForm')[0].reset();
    $('#aeronaveForm').attr('action', '/acsp/aeronave');
});

$('.editaAeronaveAction').click(function(event){
    var aeronaveId = $(this).attr('aeronaveId');
    $('#aeronaveModalBtn').trigger('click');
    obtemAeronave(aeronaveId);
    $('#aeronaveForm').attr('action', '/acsp/aeronave/' + aeronaveId);
});

$('.apagaAeronaveAction').click(function(event){
    var aeronaveId = $(this).attr('aeronaveId');
    var modelo = $("#aeronaveModelo" + aeronaveId).text();
    var confirmed = window.confirm("Confirma remocao do aeronave " + modelo);
    if(confirmed){
        apagaAeronave(aeronaveId);
    }
    else{
        event.preventDefault();
    }
});



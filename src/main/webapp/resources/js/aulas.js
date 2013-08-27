function apagaAula(id){
    $.ajax({
        url: "/acsp/aula/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemAula(id){
    $.ajax({
        url: "/acsp/aula/" + id
    }).done(function(aula) {
        aplicarObjetoNoFormulario(aula, "#aulaForm");
    });
}

// Gambeta
$('#aulaModalBtn').click(function(){
    $('#aulaForm')[0].reset();
    $('#aulaForm').attr('action', '/acsp/aula');
});

$('.editaAulaAction').click(function(event){
    var aulaId = $(this).attr('aulaId');
    $('#aulaModalBtn').trigger('click'); //hehehe
    obtemAula(aulaId);
    $('#aulaForm').attr('action', '/acsp/aula/' + aulaId);
});

$('.apagaAulaAction').click(function(event){
    var aulaId = $(this).attr('aulaId');
    var nome = $("#aulaNome" + aulaId).text();
    var confirmed = window.confirm("Confirma remocao do aula " + nome);
    if(confirmed){
        apagaAula(aulaId);
    }
    else{
        event.preventDefault();
    }
});



function apagaAluno(id){
    $.ajax({
        url: "/acsp/aluno/" + id + "/apaga"
    }).done(function() {
            window.location.reload();
    });
}

function obtemAluno(id){
    $.ajax({
        url: "/acsp/aluno/" + id
    }).done(function(aluno) {
        aplicarObjetoNoFormulario(aluno, "#alunoForm");
    });
}

// Gambeta
$('#alunoModalBtn').click(function(){
    $('#alunoForm')[0].reset();
    $('#alunoForm').attr('action', '/acsp/aluno');
});

$('.editaAlunoAction').click(function(event){
    var alunoId = $(this).attr('alunoId');
    $('#alunoModalBtn').trigger('click'); //hehehe
    obtemAluno(alunoId);
    $('#alunoForm').attr('action', '/acsp/aluno/' + alunoId);
});

$('.apagaAlunoAction').click(function(event){
    var alunoId = $(this).attr('alunoId');
    var nome = $("#alunoNome" + alunoId).text();
    var confirmed = window.confirm("Confirma remocao do aluno " + nome);
    if(confirmed){
        apagaAluno(alunoId);
    }
    else{
        event.preventDefault();
    }
});



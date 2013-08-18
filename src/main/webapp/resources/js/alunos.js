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
        console.log(aluno);
        aplicarObjetoNoFormulario(aluno, "#alunoForm");
        console.log("---");
    });
}
function aplicarObjetoNoFormulario(obj, formId){
    console.log("???");
    var properties = [];
    for(var key in obj) {
        if(obj.hasOwnProperty(key) && typeof obj[key] !== 'function') {
            properties.push(key);
        }
    }
    console.log("xxx no formId" + formId);
    $("form#" + formId + " :input").each(function(){
        var input = $(this);// This is the jquery object of the input
        console.log("------> " + input.attr('name'));
        var attrName = input.attr('name');
        console.log("No form: " + attrName);
        console.log("No obj: " + properties[attrName]);
        input.attr(attrName, properties[attrName]);
    });
    console.log("yyyy");
}

// Gambeta
$('#alunoModalBtn').click(function(){
    $('#alunoForm').attr('action', '/acsp/aluno');
});

$('.editaAlunoAction').click(function(event){
    var alunoId = $(this).attr('alunoId');
    obtemAluno(alunoId);
    alert("Editar " + alunoId);
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



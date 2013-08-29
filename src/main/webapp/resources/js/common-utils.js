function aplicarObjetoNoFormulario(obj, formId){
    var properties = [];
    for(var key in obj) {
        if(obj.hasOwnProperty(key) && typeof obj[key] !== 'function') {
            properties.push(key);
        }
    }
    var selector = "form" + formId + " :input";
    $(selector).each(function(){
        var input = $(this);// This is the jquery object of the input
        var attrName = input.attr('name');
        var attrType = input.attr('type');
        var isObject = false;
        if (attrName != undefined && attrName.indexOf('.') !== -1) {
            isObject = true;
            attrName = attrName.split('.')[0];
        }
        if(obj[attrName] != undefined && obj[attrName] != null){
            if (attrType === 'checkbox') { //TODO - implementar casos de radio button!
                input.prop('checked', obj[attrName]);
            } else {
                if (isObject) {
                    input.val(obj[attrName].id);
                } else {
                    input.val(obj[attrName]);
                }
            }
        }
    });
}

$('#myModal').on('hidden.bs.modal', function () {
    $(this).find('form')[0].reset();
});

$('.editaAction').click(function(e) {
    var id = $(this).closest('tr').attr('id');
    var $form = $('#myModal form');
    $form[0].reset();
    var action = $form.attr('action');
    if (action.substr(-1) === 's') {
        action = action.slice(0, -1);
    }
    $.ajax({
        url: action + '/' + id
    }).done(function(returnObject) {
        aplicarObjetoNoFormulario(returnObject, "#" + $form.attr('id'));
        $('#myModal').modal('show');
    });
});

$('.apagaAction').click(function(e) {
    var $tr = $(this).closest('tr');
    var action = $('#myModal form').attr('action');
    bootbox.confirm('Confirma remoção?', function (result) {
        if (result) {
            var id = $tr.attr('id');
            if (action.substr(-1) === 's') {
                action = action.slice(0, -1);
            }
            $.ajax({
                url: action + '/' + id + "/apaga"
            }).done(function() {
                    $tr.remove();
//            window.location.reload();
            });
        }
    });
});

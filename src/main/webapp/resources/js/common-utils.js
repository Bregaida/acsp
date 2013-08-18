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
        if(obj[attrName] != undefined && obj[attrName] != null){
            input.val(obj[attrName]);
        }
    });
}
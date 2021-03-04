angular.module("listaTelefonica").filter("shorter",function (){
    return function (input, size){
        if(!input) return " ";
        var output = input.substring(0, (size || 3));
        return output;
    }
})
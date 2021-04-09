angular.module("listaTelefonica").controller("novoContatoCtrl", function($scope, contatosAPI, serialGenerator){
    $scope.adicionarContato = function (contato){
        contato.serial = serialGenerator.generate();
        contatosAPI.saveContato(contato).then(function(){
            delete $scope.contato; //deleta os dados que estão no campo do escopo
            $scope.contatoForm.$setPristine();
        });
    };
});
angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, contatos, serialGenerator){
    $scope.app = "Lista Telefônica do teteu ";
    $scope.contatos = contatos.data;
    $scope.adicionarContato = function (contato){
        contato.serial = serialGenerator.generate();
        contatosAPI.saveContato(contato).then(function(response){
            delete $scope.contato; //deleta os dados que estão no campo do escopo
            $scope.contatoForm.$setPristine();
            carregarContatos();
        });
    };
      $scope.deletarContato = function(contato){
          $scope.contato = contato.selecionado;
          console.log(contato);
        };
      $scope.isContatoSelecionado = function(contatos){
            return contatos.some(function (contato){
                console.log(contato.selecionado);
                return contato.selecionado;
            });
          };
      $scope.ordenarPor = function(campo){
              $scope.criterioDeOrdenacao = campo;
              $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
          };
      var generateSerial = function(contatos){
          contatos.forEach(function (item){
              item.serial = serialGenerator.generate();
          });
          };
      generateSerial($scope.contatos);
});
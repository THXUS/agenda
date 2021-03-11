angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, $route, $filter, contatosAPI, contatos, serialGenerator){
    $scope.app = "Lista Telefônica do teteu ";
    $scope.contatos = contatos.data;
    $filter('shorter')(contatos.data.serial);
    $scope.adicionarContato = function (contato){
        contato.serial = serialGenerator.generate();
        contatosAPI.saveContato(contato).then(function(response){
            delete $scope.contato; //deleta os dados que estão no campo do escopo
            $scope.contatoForm.$setPristine();
            carregarContatos();
        });
    };
      $scope.deletarContato = function(contatos){
          contatos.filter(function (contato){
              if(contato.selecionado){
                  console.log(contato);
                  contatosAPI.deleteContato(contato).then(function(response){
                      delete $scope.contato;
                      $route.reload();
                  })
              }
          });
          $scope.verificarContatoSelecionado($scope.contatos);
        };
      $scope.verificarContatoSelecionado = function(contatos){
            $scope.hasContatoSelecionado = contatos.some(function (contato){
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
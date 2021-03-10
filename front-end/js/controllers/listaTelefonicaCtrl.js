angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, contatosAPI, serialGenerator){
    $scope.app = "Lista Telefônica do teteu ";
    $scope.contatos = [];
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
      var carregarContatos = function(){
          contatosAPI.getContatos().then(function(response){
              $scope.contatos = response.data;
          }).catch(function (){
              $scope.error = "Não foi possível carregar os dados!";
          })
      };
      carregarContatos();
});
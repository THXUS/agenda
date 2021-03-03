angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope,$http){
    $scope.app = "Lista Telefônica do teteu ";
    $scope.contatos = [];
    $scope.adicionarContato = function (contato){
        $http.post("http://localhost:3333/pessoa",contato).then(function(response){
            delete $scope.contato; //deleta os dados que estão no campo do escopo
            $scope.contatoForm.$setPristine();
            carregarContatos();
        });
    };
      $scope.deletarContatos = function(contatos){
            $scope.contatos = contatos.filter(function (contato){
                if(!contato.selecionado) return contato;
            })
            console.log(contatos);
        };
      $scope.isContatoSelecionado = function(contatos){
            return contatos.some(function (contato){
                return contato.selecionado;
            });
          };
      $scope.ordenarPor = function(campo){
              $scope.criterioDeOrdenacao = campo;
              $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
          };
      var carregarContatos = function(){
          $http.get("http://localhost:3333/pessoa/todas").then(function(response){
              $scope.contatos = response.data;
          })
      };
      carregarContatos();
});
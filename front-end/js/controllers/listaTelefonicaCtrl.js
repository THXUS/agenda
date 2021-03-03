angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope,$http, contatosAPI){
    $scope.app = "Lista Telefônica do teteu ";
    $scope.contatos = [];
    $scope.adicionarContato = function (contato){
      contatosAPI.saveContato(contato).then(function(response){
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
          contatosAPI.getContatos().then(function(response){
              $scope.contatos = response.data;
          })
      };
      carregarContatos();
});
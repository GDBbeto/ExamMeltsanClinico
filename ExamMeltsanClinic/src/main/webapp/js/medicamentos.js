angular.module('webappApp')
.controller ('medicamentosCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
   
	console.log("welcome a la pagina de medicamentos");
	
	$scope.medicamentoModal= function(){
		console.log("Mostrar la ventana de agregar un medico .");
		$scope.mensajeTitulo="Nuevo usuario";
		$scope.boton="Guardar";
		$("#myModal").modal("show");
	}

}]);
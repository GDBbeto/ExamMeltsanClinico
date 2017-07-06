angular.module('webappApp')
.controller ('consultasCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
   
	console.log("welcome a la pagina de consultas");


	$scope.agregarPaciente = function(){
		console.log("Mostrar ventana de agregar un paciente.");
		$scope.mensajeTitulo="Nuevo usuario";
		$scope.boton="Guardar";
		$("#myModal").modal("show");
	}
	$scope.agregarDoc = function(){
		console.log("Mostrar ventana de agregar un paciente.");
		$scope.mensajeTitulo="Nuevo usuario";
		$scope.boton="Guardar";
		$("#myModalDoc").modal("show");
	}
}]);
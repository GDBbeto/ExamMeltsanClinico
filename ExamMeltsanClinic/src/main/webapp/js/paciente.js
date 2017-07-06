angular.module('webappApp')
.controller ('pacienteCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
   
	console.log("welcome a la pagina de pacientes");
	$scope.agregarPaciente = function(){
		console.log("Mostrar ventana de agregar un paciente.");
		$scope.mensajeTitulo="Nuevo usuario";
		$scope.boton="Guardar";
		$("#myModal").modal("show");
	}

}]);
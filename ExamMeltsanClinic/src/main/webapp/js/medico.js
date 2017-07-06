angular.module('webappApp')
.controller ('medicoCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
   
	console.log("welcome a la pagina de medicos");
	
	$scope.agregarMedico = function(){
		console.log("Mostrar la ventana de agregar un medico .");
		$scope.mensajeTitulo="Nuevo medico";
		$scope.boton="Guardar";
		$("#myModal").modal("show");
	}

}]);
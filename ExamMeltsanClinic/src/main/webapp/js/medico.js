angular.module('webappApp')
.controller ('medicoCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
   
	console.log("welcome a la pagina de medicosss");
	
	$scope.tablas ={};
	$scope.tablas.pacientes = [];
	$scope.agregarMedico = function(){
		console.log("Mostrar la ventana de agregar un medico .");
		$scope.mensajeTitulo="Nuevo medico";
		$scope.boton="Guardar";
		$("#myModal").modal("show");
	}

	$scope.table={};
	$scope.mostrarTable= function(){
		console.log("Mostrar tabla.....Pasiente")
		$http({
			method: "POST",
			url:"http://localhost:8080/ExamMeltsanClinic/services/client/doctor"
		}).success(function(data){
			console.log("pacientes");	
			console.log(data);	
			$scope.tablas.pacientes = data;
			$scope.table.Info=data;
		   });

	}
	
	$scope.mostrarTable();
	$scope.filters = {myfilter: ''};
	  
	  
	$scope.tableParams = new ngTableParams({
		        page: 1,            // show first page
		        count: 10,
		        filter: $scope.filters ,
		        sorting: {	
		        	     // initial sorting

		        }
		    }, {
		     count:[], //here put empty counts
	         total: $scope.tablas.pacientes.length, // length of data
		      getData: function($defer, params) {
		         
		           var filteredData = params.filter() ? $filter('filter')($scope.tablas.pacientes, params.filter().myfilter) : data;
	               var orderedData = params.sorting() ?  $filter('orderBy')(filteredData, params.orderBy()) :
	                       data;
	                    params.total(orderedData.length); // set total for recalc pagination
		          $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
		        },
	       $scope: { $data: {} }
		   
		    });

	
	$scope.$watch("tablas.pacientes", function(){
	      $scope.tableParams.reload(); 
	      
	  })


	
}]);
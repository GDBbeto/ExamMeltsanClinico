angular.module('webappApp')
.controller ('pacienteCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
   
	$scope.tablas ={};
	$scope.tablas.pacientes = [];
	$scope.listas = {};
	$scope.paciente={};
	$scope.pacientes={};
	$scope.paciente1={
	   id_paciente:'',
	   nombre:'',
	   telefono:'',
	   activo:'S',
	   id_celula_identificacion:'',
	   id_direccion:''
	};
	$scope.celula={
			idCelula:'',
			nombre:'',
			apellidoPaterno:'',
			apellidoMaterno:'',
			curp:'',
			fechaN:''
	};
	$scope.direcion={
			id_direcion:'',
			calle:'',
			colonia:'',
			id_ciudad:''
	};
	
	
	
	
	$scope.listas.selectRolesValueCM={};
	$scope.listas={};
	$http({
		method: "POST",
		url:"http://localhost:8080/ExamMeltsanClinic/services/client/ciudad"
	}).success(function(data){
		console.log("Ciudad o municipio");	
		console.log(data);	
		$scope.listas.ciudadMunicipio = data;	
	   });
	
	$scope.table={};
	$scope.mostrarTable= function(){
		console.log("Mostrar tabla.....Pasiente")
		$http({
			method: "POST",
			url:"http://localhost:8080/ExamMeltsanClinic/services/client/pacientes"
		}).success(function(data){
			console.log("pacientes");	
			console.log(data);	
			$scope.tablas.pacientes = data;
			$scope.table.Info=data;
		   });

	}
	
	$scope.mostrarTable();
	
	
	
	console.log("welcome a la pagina de pacientes");
	
	$scope.agregarPaciente = function(){
		console.log("Mostrar ventana de agregar un paciente.");
		$scope.mensajeTitulo="Nuevo Paciente";
		$scope.boton="Guardar";
		$("#myModal").modal("show");
	}
	
	
	
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
	
		  
		  $scope.guardarDatos= function(){
			console.log("Guardar datos");
			console.log($scope.pacientes);
	
			$scope.paciente1.nombre=$scope.pacientes.nombre;
			$scope.paciente1.telefono=$scope.pacientes.telefono;
			$scope.paciente1.id_celula_identificacion=parseInt($scope.table.Info[$scope.table.Info.length-1].idCelula)+1;
			$scope.paciente1.nombre=$scope.pacientes.nombre;
			$scope.paciente1.id_direccion=parseInt($scope.table.Info[$scope.table.Info.length-1].idDirecion)+1;
			console.log($scope.paciente1);
			
			$scope.celula.nombre=$scope.pacientes.nombre;
			$scope.celula.apellidoPaterno=$scope.pacientes.apPaternoUsuario;
			$scope.celula.apellidoMaterno=$scope.pacientes.apMaternoUsuario;
			$scope.celula.curp=$scope.pacientes.curp;
			console.log($scope.celula);
			
			$scope.direcion.calle=$scope.pacientes.calle;
			$scope.direcion.colonia=$scope.pacientes.colonia;
			$scope.direcion.id_ciudad=$scope.listas.selectRolesValueCM.idCiudadMun;
			console.log($scope.direcion);
			
			  $http({
					method: "POST",
					data: $scope.direcion,
					url:"http://localhost:8080/ExamMeltsanClinic/services/client/insertDomicilio"
				}).success(function(data){
					console.log(data);
					if (data.success){
								$http({
									method: "POST",
									data: $scope.celula,
									url:"http://localhost:8080/ExamMeltsanClinic/services/client/insertCelula"
								}).success(function(data){
									
									if (data.success){
											$http({
												method: "POST",
												data: $scope.paciente1,
												url:"http://localhost:8080/ExamMeltsanClinic/services/client/insertPaciente"
											}).success(function(data){
												console.log(data);
												if (data.success){
													$scope.tableParams.reload();
												}else{
													alert(data.errorMensaje);
													console.log(data.errorMensaje);
													
												}
												   
											   });
											$scope.mostrarTable();
											$scope.tableParams.reload();
									}else{
										alert(data.errorMensaje);
										console.log(data.errorMensaje);
										
									}
									   
								   });
					}else{
						alert(data.errorMensaje);
						console.log(data.errorMensaje);
						
					}
					   
				   });
			  
			  $("#myModal").modal("hide");
		   }
		   
		 
			   

}]);
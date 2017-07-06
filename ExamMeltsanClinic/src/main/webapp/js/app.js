'use strict';

var app = angular
  .module('webappApp', [
    'ngRoute',
    'ngTable',
    'ngResource',
    'ngRoute',
    'ngSanitize'
    
  ]).config(function ($routeProvider) {
	    $routeProvider
	      .when('/', {
	        templateUrl: 'principal.html',
	        controller: 'PrincipalCtrl'
	      })
	      .when('/paciente', {
	        templateUrl: 'paginas/pacienteClinic.html',
	        controller: 'pacienteCtrl'
	      })

	      .when('/medicos', {
	        templateUrl: 'paginas/medicoClinic.html',
	        controller: 'medicoCtrl'
	      })
	      .when('/consultas', {
	        templateUrl: 'paginas/consultaClinic.html',
	        controller: 'consultasCtrl'
	      })
	       .when('/medicamentos', {
	        templateUrl: 'paginas/medicamentosClinic.html',
	        controller: 'medicamentosCtrl'

	      })
	      .when('/medNocivo', {
		        templateUrl: 'paginas/MedicamentosNocivasClinic.html',
		        controller: 'medNocivoCtrl'
	      })
	      .otherwise({
	        redirectTo: '/'
	      });
  		}

  );




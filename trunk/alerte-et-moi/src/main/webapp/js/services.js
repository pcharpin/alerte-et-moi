var services = angular.module('calendarServices', ['ngResource']);

services.factory('evenements', function($resource){
	return $resource('rest/evenement/getall', {}, {
		findAll: {method:'GET', isArray:true}
	});
	});

services.factory('evenement', function($resource){
	return $resource('rest/evenement/send', {}, {
		create: {method: 'POST'},
	});
	});

services.factory('dossiers', function($resource){
	return $resource('rest/dossier/getFolders', {}, {
	findAll: {method:'GET', isArray:true}
	});
	});

services.factory('responsables', function($resource){
	return $resource('rest/responsable/getallResponsable', {}, {
		findAll: {method: 'GET', isArray:true}
	});
	});

services.factory('evenement', function($resource){
	return $resource('rest/evenement/:evtId', {}, {
		get: {method: 'GET',params: { evtId: '@evtId' }, 
			isArray: false}
	});
	});
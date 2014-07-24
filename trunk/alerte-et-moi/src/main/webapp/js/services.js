var services = angular.module('calendarServices', ['ngResource']);

services.factory('evenements', function($resource){
	return $resource('rest/evenement/getall', {}, {
		findAll: {method:'GET', isArray:true}
	});
	});
/*
services.factory('evenement', function($resource){
	return $resource('rest/evenement/send', {}, {
	});
	});*/

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
	return $resource('rest/evenement/:arg1', {}, {
		get: {method: 'GET',params: { arg1: '@evtId' }, isArray: false},
		create: {method: 'POST', params: { arg1: 'send' }},
		deleteEvent: {method: 'DELETE', params: { arg1: 'deleteEvent' }}
	});
	});

services.factory('dossier', function($resource){
	return $resource('rest/dossier/:arg1', {}, {
		get: {method: 'GET',params: { arg1: '@evtId' }, isArray: false},
		create: {method: 'POST', params: { arg1: 'sendFolder' }},
		deleteFolder: {method: 'DELETE', params: { arg1: '@idFolder' }},
		update: {method: 'PUT', params: { arg1: '/update/@idFolder}' }}
	});
	});
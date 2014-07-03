var services = angular.module('calendarServices', ['ngResource']);
services.factory('evenements', function($resource){
	return $resource('rest/evenement/getall', {}, {
	findAll: {method:'GET', isArray:true}
	});
	});

services.factory('evenement', function($resource){
	return $resource('rest/evenement/send', {}, {
		create: {method: 'POST'}
	});
	});
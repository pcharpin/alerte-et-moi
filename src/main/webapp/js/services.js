angular.module('calendarServices', ['ngResource'])
.factory('evenement', function($resource){
	return $resource('rest/evenement/getall', {}, {
	findAll: {method:'GET', isArray:true}
	});
	});

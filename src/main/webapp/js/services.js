angular.module('calendarServices', ['ngResource'])
//.factory('Evenement', ['$resource',function($resource){return $resource('rest/evenement/:evtId', {evtId:'@id'});}]);
.factory('Evenement', function($resource){
	return $resource('rest/getall', {}, {
	findAll: {method:'GET', isArray:true}
	});
	});

//.factory('Evenement', function($resource){
//return $resource('rest/evenement/1', {}, {
//findOne: {method:'GET', isArray:false}
//});
//});


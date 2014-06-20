angular.module('calendarServices', ['ngResource'])
.factory('Evenement', function($resource){
return $resource('rest/alerte/evenement/get', {}, {
findOne: {method:'GET', isArray:false}
});
});
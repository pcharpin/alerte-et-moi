angular.module('calendarServices', ['ngResource'])
.factory('Evenement', function($resource){
return $resource('rest/evenement/1', {}, {
findOne: {method:'GET', isArray:false}
});
});
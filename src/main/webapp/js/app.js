/**
 * calendarApp - 0.1.3 
 */
angular.module('calendarApp', ['ui.calendar', 'ngRoute', 'ui.bootstrap','ngDialog','calendarServices','filters'])
.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/evenements', {
        templateUrl: 'views/events.html',
        controller: 'CalendarCtrl'
      }).
      when('/dossiers', {
        templateUrl: 'views/folders.html',
        controller: 'FolderCtrl'
      }).
      otherwise({
        redirectTo: '/evenements'
      });
  }]);



/* EOF */
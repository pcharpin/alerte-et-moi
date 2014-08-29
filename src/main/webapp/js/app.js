/**
 * calendarApp - 0.1.3 
 */
angular.module('calendarApp', ['ui.calendar', 'ngRoute', 'ui.bootstrap','ngDialog','calendarServices','filters'])
//.config(['$routeProvider',
//  function($routeProvider) {
//    $routeProvider.
//      when('/evenements', {
//        templateUrl: 'views/events.html',
//        controller: 'CalendarCtrl'
//      }).
//      when('/dossiers', {
//        templateUrl: 'views/folders.html',
//        controller: 'FolderCtrl'
//      }).
//      otherwise({
//        redirectTo: '/evenements'
//      });
//  }]).directive('fileUpload', function ($parse) {
//	  return {
//	      restrict: 'A',
//	      scope: false,
//	      link: function(scope, element, attrs) {
//	         var fn = $parse(attrs.onReadFile);
//
//	         element.on('change', function(onChangeEvent) {
//	            var reader = new FileReader();
//
//	            reader.onload = function(onLoadEvent) {
//	               scope.$apply(function() {
//	                  fn(scope, {$fileContent:onLoadEvent.target.result});
//	               });
//	            };
//
//	            reader.readAsText((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
//	         });
//	      }
//	   };
//    
//});

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
  }]).directive('fileUpload', function () {
    return {
        scope: true,        //create a new scope
        link: function (scope, el, attrs) {
            el.bind('change', function (event) {
                var files = event.target.files;
                //iterate files since 'multiple' may be specified on the element
                for (var i = 0;i<files.length;i++) {
                    //emit event upward
                	console.log(files[i]);
                    scope.$emit("fileSelected", { file: files[i] });
                }                                       
            });
        }
    };
});


/* EOF */
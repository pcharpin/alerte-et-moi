/**
 * calendarDemoApp - 0.1.3
 */
angular.module('calendarDemoApp', ['ui.calendar', 'ui.bootstrap','ngDialog','calendarServices']);

function CalendarCtrl($scope,ngDialog,Evenement) {

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    
    /* event source that pulls from google.com */
    $scope.eventSource = {
            /* url: "http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic", */
            url: "http://www.google.com/calendar/feeds/fr.french%23holiday%40group.v.calendar.google.com/public/basic",
            className: 'gcal-event',           // an option!
            currentTimezone: 'UTC/GMT' // an option!
    };
    /* event source that contains custom events on the scope */
    $scope.events = [
      {title: 'All Day Event',start: new Date(y, m, 1)},
      {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
      {id: 999,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false},
      {id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false},
      {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
      {title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'},
      {title: 'toto a la fin?',start: new Date(y, m-1, 20)}
    ];
    /* event source that calls a function on every view switch */
    $scope.eventsF = function (start, end, callback) {
      var s = new Date(start).getTime() / 1000;
      var e = new Date(end).getTime() / 1000;
      var m = new Date(start).getMonth();
      var events = [{title: 'Feed Me ' + m,start: s + (50000),end: s + (100000),allDay: false, className: ['customFeed']}];
      callback(events);
    };

    $scope.calEventsExt = {
       color: '#f00',
       textColor: 'yellow',
       events: [ 
          {type:'party',title: 'Lunch',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
          {type:'party',title: 'Lunch 2',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
          {type:'party',title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}
        ]
    };
    /* alert on eventClick */
    $scope.alertOnEventClick = function( event, allDay, jsEvent, view ){
        $scope.alertMessage = (event.title + ' was clicked ' + date);
        $scope.event = event;
    	ngDialog.open({
    		template: '<div class="ngdialog-message"><h3>{{event.title}}</h3>'+
    		'<p>date de début: <code>{{event.start | date:"dd/MM/yyyy"}}</code></p><br><p>date de fin : <code> {{event.end}} </code> </p>'+
    			'<p>url : {{event.url}}</p></div>'+
    			'<div class="ngdialog-buttons"><button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="openSecond()">Open next</button></div>',
    		plain: true,
    		closeByEscape: true,
    		scope: $scope,
    		controller: 'InsideCtrl'
    		/*controller: 'SecondModalCtrl'*/
    	});
    	

    };
    /* alert on Drop */
     $scope.alertOnDrop = function(event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view){
       $scope.alertMessage = ('Event Droped to make dayDelta ' + dayDelta);
    };
    /* alert on Resize */
    $scope.alertOnResize = function(event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view ){
       $scope.alertMessage = ('Event Resized to make dayDelta ' + minuteDelta);
    };
    /* add and removes an event source of choice */
    $scope.addRemoveEventSource = function(sources,source) {
      var canAdd = 0;
      angular.forEach(sources,function(value, key){
        if(sources[key] === source){
          sources.splice(key,1);
          canAdd = 1;
        }
      });
      if(canAdd === 0){
        sources.push(source);
      }
    };
    /* add custom event*/
    $scope.addEvent = function() {
      $scope.events.push({
        title: 'Open Sesame',
        start: new Date(y, m, 28),
        end: new Date(y, m, 29),
        className: ['openSesame']
      });
    };
    /* remove event */
    $scope.remove = function(index) {
      $scope.events.splice(index,1);
    };
    /* Change View */
    $scope.changeView = function(view,calendar) {
      calendar.fullCalendar('changeView',view);
    };
    /* Change View */
    $scope.renderCalender = function(calendar) {
      if(calendar){
        calendar.fullCalendar('render');
      }
    };
    /* config object */	
    $scope.uiConfig = {
      calendar:{
        height: 450,
        editable: true,
        selectable: true,
		select: function(start, end) {
			var title = prompt('Event Title:');
			if (title) {
				$scope.events.push({title: title,start: start,end: end});
				/*event = {
					title: title,
					start: start,
					end: end
				};
				$('#calendar').fullCalendar('renderEvent', event, true); // stick? = true*/
			    
			}
			$('#calendar').fullCalendar('unselect');
		},
        header:{
          left: 'title',
          center: '',
          right: 'today prev,next'
        },
        eventClick: $scope.alertOnEventClick,
        eventDrop: $scope.alertOnDrop,
        eventResize: $scope.alertOnResize
      }
    };
    $scope.showMyCalendar = function(){
    	$scope.showCal=!$scope.showCal;
    	if($scope.showCal){
    	    //$scope.events = [];
    		console.log("tototototototot");
    	    Evenement.get().$promise.then(function(result){
    	    	console.log("resultat du REST ##### : ",result);
    	    	$scope.listeEvt = result;
    	    	});
    	    /*[
             {title: 'All Day Event',start: new Date(y, m, 1)},
             {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
             {id: 998,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false},
             {id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false},
             {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
             {title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'},
             {title: 'toto a la fin?',start: new Date(y, m-1, 20)}
           ];*/
    	    		
    	}else{
    		 $scope.listeEvt = [];
    	}
    	
    };
    function PhoneListCtrl($scope, Evenement) {
    	$scope.evenements = Evenement.query();
    	$scope.select = function(evenement) {
    	$scope.editedPhone = evenement;
    	};
    	}
    
    /* event sources array*/
    $scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];
    $scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];
    $scope.users = [
                    {name: 'toto',age:'0'},
                    {name: 'arzgfds',age:'0'},
                    {name: 'qsfsqdfg',age:'0'},
                    {name: 'hgjgkl',age:'0'},
                    {name: 'tata',age:'0'}
                   ];
    $scope.order = 'date';
    $scope.showCal=true;


}

/* EOF */
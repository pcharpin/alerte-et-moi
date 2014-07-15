/**
 * calendarDemoApp - 0.1.3 
 */
angular.module('calendarDemoApp', ['ui.calendar', 'ui.bootstrap','ngDialog','calendarServices']);

function CalendarCtrl($scope,ngDialog,evenements,evenement,evtToCal,dossiers,responsables) {
	
    var date = new Date();
    var d = date.getDate(); 
    var m = date.getMonth();
    var y = date.getFullYear();
    $scope.order = 'dateEchEvt';
    $scope.months = [{nom:'Janvier',num:1},{nom:'Fevrier',num:2},{nom:'Mars',num:3},{nom:'Avril',num:4},{nom:'Mai',num:5},{nom:'Juin',num:6},{nom:'Juillet',num:7},{nom:'Aout',num:8},{nom:'Septembre',num:9},{nom:'Octobre',num:10},{nom:'Novembre',num:11},{nom:'Decembre',num:12}];
    $scope.showCal=true;
	    
    $scope.formEvt={};
    $scope.listDossiers=[];
    $scope.listResponsables=[];
    $scope.events=[];
    $scope.listeEvt=[];
    

		/* event source that pulls from google.com */
	    $scope.eventSource = {
	            /* url: "http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic", */
	            url: "http://www.google.com/calendar/feeds/fr.french%23holiday%40group.v.calendar.google.com/public/basic",
	            className: 'gcal-event',           // an option!
	            currentTimezone: 'UTC/GMT' // an option!
	    };
	    /* event source that calls a function on every view switch */
	    $scope.eventsF = function (start, end, callback) {
	      var s = new Date(start).getTime() / 1000;
	      var e = new Date(end).getTime() / 1000;
	      var m = new Date(start).getMonth();
	      var events = [];
	      callback(events);
	    };	    

	    /* config object */	
	    $scope.uiConfig = {
	      calendar:{
	        height: 450,
	        editable: true,
	        selectable: true,
	        // to create evt
			select: function(start, end) {
				var title = prompt('Event Title:');
				if (title) {
					$scope.events.push({title: title,start: start,end: end});
					evenement.create({nomEvt: title,dateEchEvt: start});
					$('#calendar').fullCalendar('renderEvent', event, true); // stick? = true
				    
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
  
// FIN DU INIT

    /* event source that contains custom events on the scope */
    /*$scope.events = [
      {title: 'All Day Event',start: new Date(y, m, 1)},
      {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
      {id: 999,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false},
      {id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false},
      {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
      {title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'},
      {title: 'toto a la fin?',start: new Date(y, m, d)}
    ];*/


   /* $scope.calEventsExt = {
       color: '#f00',
       textColor: 'yellow',
       events: [ 
          {type:'party',title: 'Lunch',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
          {type:'party',title: 'Lunch 2',start: new Date(y, m, d, 12, 0),end: new Date(y, m, d, 14, 0),allDay: false},
          {type:'party',title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}
        ]
    };*/
	    
    /* alert on eventClick */
    $scope.alertOnEventClick = function( event, allDay, jsEvent, view ){
    	console.log("eventclick ##### : ");
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
    	if($scope.events.length==0){
    		evenements.findAll().$promise.then(function(result){
    	    	var list = evtToCal.convert(result);
    	    	for(var j=0;j<list.length;j++){
    	    		$scope.events.push(list[j]);
    	    	}
    	    	});
    	}

    };
  /* recupère les dossiers */
	    $scope.initCreer = function() {
	    	if($scope.listDossiers.length==0){
				dossiers.findAll().$promise.then(function(result){
			    	for(var j=0;j<result.length;j++){
			    		$scope.listDossiers.push(result[j]);
			    	}
			    });
			}
	    	/* recuperation des responsables */
	    	if($scope.listResponsables.length==0){
	    		responsables.findAll().$promise.then(function(result){
			    	for(var j=0;j<result.length;j++){
			    		$scope.listResponsables.push(result[j]);
			    	}
			    });
			}	    	
	    };	
	    
	    /* Ajouter un evenement en base */

	    $scope.submitEvt = function() {
	    	console.log("formEvt = "+ $scope.formEvt);
    		evenement.create($scope.formEvt).$promise.then(function(result){
    	    	console.log("resultat du create"+ result);
    	    	});

    };	    
	    

      /*$scope.events.push({
        title: 'Open Sesame',
        start: new Date(y, m, 28),
        end: new Date(y, m, 29),
        className: ['openSesame']
      });*/
    
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
    /* bouton ON/OFF  premiere vue de la liste d'evenements, remplit la liste des evenement ci-dessous
    $scope.showRest = function(calendar){
    	$scope.showCal=!$scope.showCal;
    	if($scope.showCal){
    		
    		//calendar.fullCalendar( 'removeEvents');
    		evenements.findAll().$promise.then(function(result){
    	    	console.log("resultat du REST ##### : ",result);
   	    	 $scope.events.push(evtToCal.convert(result));
   	    	 
    	    	});
    	}else{
 	    	console.log("Nothing");

    	}
    	
    };*/
    
    /* bouton ON/OFF de la liste d'evenements, remplit la liste des evenement ci-dessous*/
    $scope.showListEvts = function(){
		evenements.findAll().$promise.then(function(result){
			console.log("resultat du REST ##### : ",result);
			$scope.listeEvt = result;
    	});    	    		
    };
    
    /* fenetre d'edition d'un evenement */
    $scope.detailEvt = function(event){
    	$scope.event = event;
    	ngDialog.open({
    		 template: 'editEvt.html'
    	});
    }
    /* fenetre d'edition d'un evenement */
    $scope.deleteEvt = function(event){
    	$scope.event = event;
    	ngDialog.open({
    		 template: 'editEvt.html'
    	});
    }    
    /* event sources array*/
    //$scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];
	 // liste des evenements pour le calendrier, normalement doit disparaitre
    $scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];



}

/* EOF */
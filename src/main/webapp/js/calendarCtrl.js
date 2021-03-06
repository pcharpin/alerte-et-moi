﻿function CalendarCtrl($rootScope,$scope,ngDialog,evenements,evenement,evtToCal,responsables,dossiers,filterFilter) {
    var date = new Date();
    var d = date.getDate(); 
    var m = date.getMonth();
    var y = date.getFullYear();
    $scope.order = 'dateEchEvt';
    $scope.months = [{nom:'Janvier',num:1},{nom:'Fevrier',num:2},{nom:'Mars',num:3},{nom:'Avril',num:4},{nom:'Mai',num:5},{nom:'Juin',num:6},{nom:'Juillet',num:7},{nom:'Aout',num:8},{nom:'Septembre',num:9},{nom:'Octobre',num:10},{nom:'Novembre',num:11},{nom:'Decembre',num:12}];
    $scope.showCal=true;
    
    $scope.resetForm = function(){
    	$scope.formEvt = null;
    	$scope.formEvt = {
        		"dossier": {
    		        "idDos": null,
    		    },
    		    "nomEvt": "",
    		    "descEvt": "",
    		    "dateEchEvt": null,
    		    "exeEvt": null,
    		    "mntEvt": 0,
    		    "modeGestionEvt": [],
    		    "lienGestEvt": null,
    		    "trtEvt": 0,
    		    "dateTrtEvt": null,
    		    "enumPeriodeEvet": [],
    		    "actifEvt": 1,
    		    "recopAutoEvt": 0,
    		    "recurtEvt": 1,
    		    "libreEvt": null,
    		    "responsable": {
    		        "idResp": null,
    		        "alertes": []
    		    },
    		    "documents": [],
    		    "documentNames":[],
    		    "documentContents":[]
        };
    };
    
    $scope.listResponsables=[];
    $scope.events=[];
    $scope.listeEvt=[];
    $scope.eventClicked={};
    $scope.listDossiers=[];
    $scope.json={}; //here
    $scope.documents=[];
    $scope.documentNames=[];
    $scope.documentContents=[];
    $scope.achEvents =[];
    $scope.unAchEvents =[];
    $scope.prevAchEvents = [];
    $scope.prevUnAchEvents = [];

		/* event source that pulls from google.com */
	    $scope.eventSource = {
	            //url: "http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic",
	            url: "http://www.google.com/calendar/feeds/fr.french%23holiday%40group.v.calendar.google.com/public/basic",
	            className: 'gcal-event',           // an option!
	            currentTimezone: 'UTC/GMT' // an option!
	    };
	    
	    $scope.init = function() {
    		$scope.addEvent();
    		if($scope.listDossiers.length==0){
    			dossiers.findAll().$promise.then(function(result){
    		    	for(var j=0;j<result.length;j++){
    		    		$scope.listDossiers.push(result[j]);
    		    	}
    		    });
    		}	    	
    		
    		if($scope.listResponsables.length==0){ 		
	    		responsables.findAll().$promise.then(function(result){
			    	for(var j=0;j<result.length;j++){
			    		$scope.listResponsables.push(result[j]);
			    	}
			    });
			}	
    	};
	    
	    /* event source that calls a function on every view switch */
	    $scope.eventsF = function (start, end, callback) {
	      var s = new Date(start).getTime() / 1000;
	      var e = new Date(end).getTime() / 1000;
	      var m = new Date(start).getMonth();
	      var events = [];
	      callback(events);
	    };	    
	    /* alert on eventClick */
	    $scope.alertOnEventClick = function( event, allDay, jsEvent, view ){
	        $scope.alertMessage = (event.title + ' was clicked ' + date);
	        $scope.event = event;
    		evenement.get({}, {evtId: $scope.event.id}).$promise.then(function(result){
    			$scope.eventClicked = result;// la variable eventClicked est associé au resultat du get(id)
    	    	});
	    	ngDialog.open({
	    		template: '<div class="ngdialog-message"><h3>{{eventClicked.nomEvt}}</h3>'+
	    		'<p>date de début: <code>{{eventClicked.dateEchEvt | date:"dd/MM/yyyy"}}</code></p>'+
    			'<p>dossier : {{eventClicked.dossier.nomDos}}</p>'+
    			'<p>description : {{eventClicked.descEvt}}</p>'+
    			'<p>montant : {{eventClicked.mntEvt}}€</p>'+
    			'<p>periodicité : {{eventClicked.enumPeriodeEvet}}</p>'+
    			'<p>mode de gestion : {{eventClicked.modeGestionEvt}}</p>'+
    			'<p>traité : {{eventClicked.trtEvt | booleanTooString}}</p>'+
    			'<p>responsable : {{eventClicked.responsable.prenResp}} {{eventClicked.responsable.nomResp}}</p></div>',
	    			//+'<div class="ngdialog-buttons"><button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="openSecond()">Open next</button></div>',
	    		plain: true,
	    		closeByEscape: true,
	    		scope: $scope,
	    		controller: 'InsideCtrl'
	    		//controller: 'SecondModalCtrl'
	    	});
	    };
	    console.log("init");
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
    		evenements.all.findAll().$promise.then(function(result){
    	    	var list = evtToCal.convert(result);
    	    	for(var j=0;j<list.length;j++){
    	    		$scope.events.push(list[j]);
    	    	}
    	    	$scope.filterEvents(0);
    	    	$scope.filterEvents(1);
    	    	$scope.checkTrt = true;
    	    	$scope.checkNonTrt = true;
    		});
    	}
    };
    
    $scope.refreshCal = function(){
    	//TODO actualiser le calendrier, ne fonctionne pas si l'on crée un évènement et que l'on ne rafraichis pas la page, on ne le voit pas sur le calendrier.
    };
	    $scope.initCreer = function() {
	    	/* reset formulaire et affichage status formulaire*/
	    	$scope.formStatus = null;
	    	newEventForm = null;
	    	//scope.formEvtStatus=null;
	    	$scope.resetForm();
	    	
	    	/* recuperation des responsables */
	    	if($scope.listResponsables.length==0){ 		
	    		responsables.findAll().$promise.then(function(result){
			    	for(var j=0;j<result.length;j++){
			    		$scope.listResponsables.push(result[j]);
			    	}
			    });
			}	
	    };	
	    
	    //***************Ajouter un evenement en base**********************/
	    $scope.submitEvt = function() {
	    	console.log($scope.documents);
	    	$scope.formEvt.documents = $scope.documents;
	    	$scope.formEvt.documentNames = $scope.documentNames;
	    	$scope.formEvt.documentContents = $scope.documentContents;

	    //******************Création d'un évènement************************************
	    	evenement.create($scope.formEvt).$promise.then(function(result){
	    		
	    //***************ajout de l'évènement à ceux en cours */
	    		evenements.all.findAll().$promise.then(function(serverEvents){
	    			var list = evtToCal.convert(serverEvents);
	    	    	$scope.events.push(list[list.length-1]);
	    		});
	    		
	    		$scope.resetForm();
//	    		$scope.formStatus = {
//	    				status: 'success',
//	    				message: 'L\'évènement a été créé avec succès.'
//	    		};
	    	}
	    	//	    	, function(err){
//	    		$scope.formStatus = {
//	    				status: 'error',
//	    				message: 'L\'évènement n\'a pu être créé. Veuillez re-essayer.'
//	    		};
//	    	}
	    	);
	    };
	    
	    /*Mise à jour événemenet en base*/
	    
	    $scope.updateEvt = function(evtId) {
	    	evenement.update({}, {evtId : evtId}).$promise.then(function(result){
	    		
	    	});
	    };
	        
    	//*********************************suppression*******************************/
    	 $scope.deleteEvent = function(evtId) {
    		 //alert(evtId);
    		 evenement.deleteEvent({}, {evtId : evtId}).$promise.then(function(result){});  
    		 ngDialog.closeAll(); 
    	    };
    
    	  //************************Ouvrir la popup de confirmation*************************
    		 $scope.openEvent = function(evtId) {
    			 $scope.evtId =evtId;
    			 ngDialog.open({
    					template: 'views/confirmEvt.html',
    					scope: $scope
    				}); 
    		 };
    	//******************Retour à la liste des dossier*****************
   		  $scope.cancel = function() {
   			  ngDialog.closeAll(); 
   			};	
   			
   		//***Liste des fichiers associés à un évènement***************************
   		  $scope.listOfFiles = function(evtId) { 		
   			 console.log(evtId);
   			 ngDialog.open({
					template: 'views/listOfFiles.html',
					scope: $scope
				})
   			};	
   			
    /* remove event */
    $scope.remove = function(index) {
      $scope.events.splice(index,1);
    };
    /* Change View */
    $scope.changeView = function(view,calendar) {
    	console.log("changeView")
      calendar.fullCalendar('changeView',view);
    };
    /* Change View */
    $scope.renderCalender = function(calendar) {
      if(calendar){
        calendar.fullCalendar('render');
      }
    };

    
    /* bouton ON/OFF de la liste d'evenements, remplit la liste des evenement ci-dessous*/
    $scope.showListEvts = function(){
		evenements.all.findAll().$promise.then(function(result){
			//console.log("resultat du REST ##### : ",result);
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
    
    /*Po-up modification*/
 $scope.editEvent = function( event ){ 	
        $scope.formEvt = event;
		
    	ngDialog.open({
    		template: 'views/updateEvent.html?v=9',
    		scope: $scope
    	});
        
    };    
    
    $rootScope.$on('ngDialog.closed', function (e, $dialog) {
    	//on vide le formulaire de cr�ation
    	$scope.formEvt = {};
    });
    
    /* event sources array*/
    //$scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];
	 // liste des evenements pour le calendrier, normalement doit disparaitre
    $scope.eventSources = [$scope.achEvents, $scope.unAchEvents, $scope.eventSource, $scope.eventsF];
    
    $scope.filterAchEvts = function() {
    	
    	if ( $('#achEvts').is(':checked') ) {
    		
    		$('#calendar').fullCalendar('addEventSource', $scope.prevAchEvents);
    		$('#calendar').fullCalendar('refetchEvents');
    	}
    	else{
    		
    		$('#calendar').fullCalendar('removeEventSource', $scope.achEvents);
    		$('#calendar').fullCalendar('refetchEvents');
    	}
    	
    	$scope.prevAchEvents = $scope.achEvents;
    	
    };
    
    $scope.filterUnAchEvts = function() {
    	
    	if ( $('#unAchEvts').is(':checked') ) {
    		
    		$('#calendar').fullCalendar('addEventSource', $scope.prevUnAchEvents);
    		$('#calendar').fullCalendar('refetchEvents');
    	}
    	else{
    		$('#calendar').fullCalendar('removeEventSource', $scope.unAchEvents);
    		$('#calendar').fullCalendar('refetchEvents');
    	}
    	
    	$scope.prevUnAchEvents = $scope.unAchEvents;
    };   
    
    

  //*********************************filtre événements*******************************/
    $scope.filterEvents = function(status) {
    	
    	var _filteredEvents = filterFilter($scope.events, {status:status});
	    	if (status === 1) {
	    		for (var i=0; i<_filteredEvents.length; i++)
	    			$scope.achEvents.push(_filteredEvents[i]);
	    	}
		    else if (status === 0){
		    	for ( var i=0; i<_filteredEvents.length; i++)
	    			$scope.unAchEvents.push(_filteredEvents[i]);
		    }
    };
    
    
    
  //*********************************suppression*******************************/
	 $scope.filterEvtsStatus = function(status) {
		 if($scope.events.length==0){
			 var evtsByfilter = [];
			 evenements.eventStatus.findByStatus({}, {status : status}).$promise.then(function(result){
				 var list = evtToCal.convert(result);
		 	    	for(var j=0;j<list.length;j++){
		 	    		evtsByfilter.push(list[j]);
		 	    	}
		 	    if (status == 1)
		 	       $scope.achEvents =  evtsByfilter;
		 	    else if (status == 0)
		 	    	$scope.unAchEvents = evtsByfilter;
			 });
		 }
	    };
	    
	  
    
  //load the file
    $scope.showContent = function($fileContent){    
        var obj = {name:args.file.name}
    	$scope.documents.push(obj);
    };
    $scope.$on("fileSelected", function (event, args) {
        $scope.$apply(function () {            
            //Read content file
        	var reader = new FileReader();
        	reader.readAsBinaryString(args.file);
        	
        	//end of reading and loading
        	reader.onloadend = function(e){
        		var result = e.target.result;
        		//var obj = {name:args.file.name,fileContent:result} ;   
        		//name -> content
            	$scope.documentNames.push(args.file.name);
            	$scope.documentContents.push(result);
        	}        	
        });
    });    
};
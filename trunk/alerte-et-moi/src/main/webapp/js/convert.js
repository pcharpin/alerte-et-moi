angular.module('calendarDemoApp')
//transforme la liste d'evenements pour les intégrer dans le calendrier
.service('evtToCal',[ function(){
	
		
	this.convert = function(events){
		var result=[];
		var d = new Date();
		for (var i = 0; i < events.length; i++) {
			  d = new Date(events[i].dateEchEvt)
			  result.push({id: events[i].idEvt,title: events[i].nomEvt,start: d ,allDay: false,url:''});
			  }
		//var result= [ {id: 2,title: 'TEST REST Event',start: '2014-06-30',allDay: false}, {id: 2,title: 'TEST REST Event',start: '2014-06-30',allDay: false}];
		            
		console.log("resultat du convert ##### : ",result);
	       return result;
	}
	
}]);
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
	       return result;
	}
	
}]);
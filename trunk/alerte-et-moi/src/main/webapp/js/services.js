var services = angular.module('calendarServices', ['ngResource']);

services.factory('evenements', function($resource){
	return {
			all: $resource('rest/evenement/getall',{},{
				findAll: {method:'GET', isArray:true}
			}),
			severalMonths: $resource('rest/evenement/date/:day-:month-:year',{},{
				findByDate: {method: 'GET', isArray:true, params:{day: '@day', month: '@month', year:'@year'}}
			}),
			eventStatus: $resource('rest/evenement/status/:status',{},{
				findByStatus: {method: 'GET', isArray:true, params:{status: '@status'}}
			})
	};
	});


services.factory('dossiers', function($resource){
	return $resource('rest/dossier/getFolders', {}, {
	findAll: {method:'GET', isArray:true}
	});
	});

services.factory('enumPeriod', function($resource){
	return $resource('rest/evenement/period', {}, {
	findAllPeriod: {method:'GET', isArray:true}
	});
	});

services.factory('responsables', function($resource){
	return $resource('rest/responsable/getallResponsable', {}, {
		findAll: {method: 'GET', isArray:true}
	});
	});

services.factory('evenement', function($resource){
	return $resource('rest/evenement/:arg1', {}, {
		get: {method: 'GET',params: { arg1: '@evtId' }, isArray: false},
		create: {method: 'POST', params: { arg1: 'send'}},
		deleteEvent: {method: 'DELETE', params: { arg1: '@evtId'}},
		update: {method: 'PUT', params: { arg1: '@evtId}'}}
	});
	});



services.factory('dossier', function($resource){
	return $resource('rest/dossier/:arg1', {}, {
		get: {method: 'GET',params: { arg1: '@idFolder' },isArray: false},
		create: {method: 'POST', params: { arg1: 'sendFolder' }},
		deleteFolder: {method: 'DELETE', params: { arg1: '@idFolder' }},
		updateFolder: {method: 'PUT', params: { arg1: '@idFolder'}}
	});
	});
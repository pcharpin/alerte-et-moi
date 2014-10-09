angular.module('filters', []).filter('booleanTooString', function() {
  return function(input) {
    return input == 0 ? 'non' : 'oui';
  };
})
.filter('folderFilter', function() {
  return function(list, selected) {
	  return _.filter(list, function(item){
		  alert(item);
		  if(selected && JSON.parse(selected).idDos) {
			  return item.dossier.idDos == JSON.parse(selected).idDos;
		  } else {
			  return list;
		  }
      });
  }
}).filter('responsableFilder', function() {
	  return function(list, selected) {
		  return _.filter(list, function(item){
			  if(selected && JSON.parse(selected).idResp) {
				  return item.responsable.idResp == JSON.parse(selected).idResp;
			  } else {
				  return list;
			  }
	      });
	  }
}).filter('calendarFilter', function() {
	  return function(list, selected) {
		  return _.filter(list, function(item){
			  console.log(item,selected);
			  return list;
			  /*
			  if(selected && JSON.parse(selected).idResp) {
				  return item.responsable.idResp == JSON.parse(selected).idResp;
			  } else {
				  return list;
			  }
			  */
	      });
	  }
});


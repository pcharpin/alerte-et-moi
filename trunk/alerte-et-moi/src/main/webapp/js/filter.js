angular.module('filters', []).filter('booleanTooString', function() {
  return function(input) {
    return input == 0 ? 'non' : 'oui';
  };
})
.filter('folderFilter', function() {
  return function(list, selected) {
	  return _.filter(list, function(item){
		  if(selected && JSON.parse(selected).idDos) {
			  return item.dossier.idDos == JSON.parse(selected).idDos;
		  } else {
			  return list;
		  }
      });
  }
});
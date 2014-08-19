function FolderCtrl($rootScope, $scope, dossiers, dossier, ngDialog) {
    $scope.formDos={};
    $scope.listDossiers=[];
	/*Ajouter un dossier*/    
    $scope.submitDos = function() {
    	console.log("formDos = ", $scope.formDos);
		dossier.create($scope.formDos).$promise.then(function(result){
	    	//console.log("resultat du create"+ result);
    	});
	};	 
	
	$scope.initCreer = function() {
    	if($scope.listDossiers.length==0){
			dossiers.findAll().$promise.then(function(result){
		    	for(var j=0;j<result.length;j++){
		    		$scope.listDossiers.push(result[j]);
		    	}
		    });
		}    	
    };	
	
	$scope.init = function() {
		$scope.initCreer();
	};
    
    $scope.deleteFolder = function(idFolder) {
		dossier.deleteFolder({}, {idFolder : idFolder}).$promise.then(function(result){
			console.log("suppression ok"+ result);
		});
    };	
    
    $scope.editFolder = function( folder ){
    	
        $scope.formDos = folder;
		
    	ngDialog.open({
    		template: 'views/folderUpdate.html?v=9',
    		scope: $scope
    	});
        
    };    
    
    $rootScope.$on('ngDialog.closed', function (e, $dialog) {
    	//on vide le formulaire de création
    	$scope.formDos = {};
    });
    
};
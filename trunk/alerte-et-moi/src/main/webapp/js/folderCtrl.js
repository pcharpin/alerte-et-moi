function FolderCtrl($rootScope, $scope, dossiers, dossier, ngDialog,$location) {
    $scope.formDos={};
    $scope.listDossiers=[];
    $scope.documents=[];
//    $scope.documentNames=[];
//    $scope.documentContents=[];
    
	//****************Ajouter un dossier*******************    
    
    $scope.submitDos = function() {
    	
    	console.log($scope.documents);
//    	$scope.formDos.documents = $scope.documents;
//    	$scope.formDos.documentNames = $scope.documentNames;
//    	$scope.formDos.documentContents = $scope.documentContents;
    	
    	console.log("formDos = ", $scope.formDos);
		dossier.create($scope.formDos).$promise.then(function(result){
	    	console.log("resultat du create"+ result);
    	});
	};	 
	
	//*************************Suppression d'un dossier****************************
	 $scope.deleteFolder = function(idFolder) {
			dossier.deleteFolder({}, {idFolder : idFolder}).$promise.then(function(result){
				console.log("suppression ok"+ result);
			});
	    };	
	//***************************Mise à jour d'un dossier*******************
	  $scope.submitUpdateDos = function(idFolder) {
	  
		  //dossier.updateFolder($scope.formDos, {idFolder : idFolder}).$promise.then(function(result){
		  dossier.updateFolder({},{idFolder : idFolder}).$promise.then(function(result){
			  console.log("mis à jour ok"+ result);
			  ngDialog.closeAll(); 
			});
		};	 
	
		//******************Retour à la liste des dossier*****************
		  $scope.cancel = function() {
			  ngDialog.closeAll(); 
			};	 
		
	$scope.initCreer = function() {
		
		$scope.resetForm();
		
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
    
    $scope.editFolder = function( folder ){   	
        $scope.formDos = folder;
        console.log("folder _o_ = ", $scope.formDos);
        
    	ngDialog.open({
    		//template: 'views/updateFolder.html?v=9',
    		template: 'views/updateFolder.html',
    		scope: $scope
    	});       
    };    
    
    $rootScope.$on('ngDialog.closed', function (e, $dialog) {
    	//on vide le formulaire de cr�ation
    	$scope.formDos = {};
    });
       
    $scope.resetForm = function(){
    	$scope.formDos = null;
    	$scope.formDos = {
    			"idDos": null,
    			"nomDos": "",
    			"enumTypesDossiers":[],
    			"descDoc": "",
    			"evtDos": "",
//    			"documentNames":  [],
//    			"documentContents":  [],
    			"documents": [],
    			"priorDos": false,
    			"mntDOS": 0,
    			"periodJourDos": null,
    			"periodHebdoDos": null,
    			"periodMensDos": null,
    			"periodTrimDos": true,
    			"periodSemestDos": null,
    			"periodAnuDos": null,
    			"periodSansDos": null,
    			"actifDos": true,
    			"cntNomDos": null,
    			"cntPrenomDos": null,
    			"cntTelDos": null,
    			"cntCmntDos": "",
    			"libre": null
        };
    };
    
    // Ajouter un document à un dossier 
    
//    $scope.showContent = function($fileContent){    
//        var obj = {name:args.file.name}
//    	$scope.documents.push(obj);
//    };
//    $scope.$on("fileSelected", function (folder, args) {
//        $scope.$apply(function () {            
//            //Read content file
//        	var reader = new FileReader();
//        	reader.readAsBinaryString(args.file);
//        	
//        	//end of reading and loading
//        	reader.onloadend = function(e){
//        		var result = e.target.result;
//        		//var obj = {name:args.file.name,fileContent:result} ;   
//        		//name -> content
//            	$scope.documentNames.push(args.file.name);
//            	$scope.documentContents.push(result);
//        	}        	
//        });
//    });      
};
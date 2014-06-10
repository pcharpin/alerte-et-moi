angular.module('exampleDialog', ['ngDialog']);

function MainCtrl($scope, ngDialog) {
	
	var templatePopup = '<div class="ngdialog-message"><h3>ngDialog template</h3><p ng-show="theme">Test content for <code>{{jsonData}}</code></p><p ng-show="ngDialogData.foo">Data passed through directive: <code>{{ngDialogData.foo}}</code></p></div><div class="ngdialog-buttons"><button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="openSecond()">Open next</button></div>';
	
	$scope.jsonData = '{"foo": "bar"}';
	$scope.theme = 'ngdialog-theme-default';

	$scope.open = function () {
	ngDialog.open({ 
		template: templatePopup,
		plain: true,
		controller: 'InsideCtrl' });
	};
	
	$scope.openDefault = function () {
	ngDialog.open({
	template: templatePopup,
	controller: 'InsideCtrl',
	className: 'ngdialog-theme-default'
	});
	};
	
	$scope.openPlain = function () {
	$scope.theme = 'ngdialog-theme-plain';
	
	ngDialog.open({
	template: templatePopup,
	controller: 'InsideCtrl',
	className: 'ngdialog-theme-plain'
	});
	};
	
	$scope.openTemplate = function () {
	$scope.value = true;
	
	ngDialog.open({
	template: 'externalTemplate.html',
	className: 'ngdialog-theme-plain',
	scope: $scope
	});
	}
};

function InsideCtrl($scope, ngDialog){
	$scope.openSecond = function () {
	ngDialog.open({
	template: '<h3><a href="" ng-click="closeSecond()">Close all by click here!</a></h3>',
	plain: true,
	closeByEscape: false,
	controller: 'SecondModalCtrl'
	});
	};
};

function SecondModalCtrl($scope, ngDialog) {
$scope.closeSecond = function () {
ngDialog.close();
};
};


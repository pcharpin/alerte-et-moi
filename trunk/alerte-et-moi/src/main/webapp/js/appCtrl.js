function AppCtrl($scope, $route) {
	console.log('current', $route)
	$scope.currentPage = $route;
};
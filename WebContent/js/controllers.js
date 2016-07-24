
function PersonsCtrl($scope, $http, Persons, Reports, $location) {

	$scope.refresh = function() {
		$scope.persons = Persons.query();
	};

	$scope.reset = function() {
		$scope.newPerson = {};
	};

	$scope.editPerson = function(personId) {
		$location.path('/person-detail/' + personId);
	};
	
	$scope.viewReport = function() {
		$location.path('/report/');
	};

	$scope.register = function() {
		$scope.successMessages = '';
		$scope.errorMessages = '';
		$scope.errors = {};

		Persons.save($scope.newPerson,
				function(data) {
					// mark success on the registration form
					$scope.successMessages = ['Name Registered'];

					// Update the list of persons
					$scope.refresh();

					// Clear the form
					$scope.reset();
				}, function(result) {
					if ((result.status == 409) || (result.status == 400)) {
						$scope.errors = result.data;
					} else {
						$scope.errorMessages = ['Unknown  server error'];
					}
					$scope.$apply();
				});

	};

	$scope.deletePerson = function(data) {
		$scope.successMessages = '';
		$scope.errorMessages = '';
		$scope.errors = {};

		Persons.remove({
					id : data
				}, function(data) {
					// mark success on the removal 
					$scope.successMessages = ['Name Removed'];
					$scope.refresh();
					$scope.reset();
				}, function(result) {
					if ((result.status == 409) || (result.status == 400)) {
						$scope.errors = result.data;
					} else {
						$scope.errorMessages = ['Unknown  server error'];
					}
					$scope.$apply();
				});

	};

	// Call the refresh() function, to populate the list of person
	$scope.refresh();

	// Initialize newPerson here to prevent Angular from sending a request
	// without a proper Content-Type.
	$scope.reset();

	// Set the default orderBy to the name property
	$scope.orderBy = 'lastname';
}


function PersonsDetailCtrl($scope, $routeParams, Persons, $location) {

	$scope.updatePerson = function(data) {
		$scope.successMessages = '';
		$scope.errorMessages = '';
		$scope.errors = {};

		Persons.update($scope.person,
				function(data) {
					$scope.successMessages = ['Name Updated'];
					$location.path('/home');
				}, function(result) {
					if ((result.status == 409) || (result.status == 400)) {
						$scope.errors = result.data;
					} else {
						$scope.errorMessages = ['Unknown  server error'];
					}
					$scope.$apply();
				});
	};

	$scope.cancelUpdate = function() {
		$location.path('/home');
	};

	$scope.person = Persons.show({id : $routeParams.id});
}

function ReportsCtrl($scope, $http, Reports, $location) {

	$scope.refresh = function() {
		$scope.reports = Reports.query();
	};

	$scope.closeReport = function() {
		$location.path('/home');
	};

	// Call the refresh() function, to populate the report
	$scope.refresh();
}



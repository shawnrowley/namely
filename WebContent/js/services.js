
// Define the REST resource service, allowing us to interact with it as a high level service

var services = angular.module('personsService', ['ngResource']);

services.factory('Persons', function ($resource) {
    return $resource('rest/Persons/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT'},
        remove: { method: 'DELETE', params: {id: '@id'} }
    })
});

services.factory('Reports', function ($resource) {
	return $resource('rest/report/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT'},
        remove: { method: 'DELETE', params: {id: '@id'} }
    })

});



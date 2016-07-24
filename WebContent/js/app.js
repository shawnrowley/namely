
angular.module('namemanager', ['personsService']).config(
        [ '$routeProvider', function($routeProvider) {
            $routeProvider.when('/person-detail/:id', {
                templateUrl : 'partials/person-detail.html',
                controller : PersonsDetailCtrl
            });
            
            $routeProvider.when('/report', {
                templateUrl : 'partials/report.html',
                controller : ReportsCtrl
            });
            
            $routeProvider.when('/home', {
                templateUrl : 'partials/home.html',
                controller : PersonsCtrl
            });
            
            $routeProvider.otherwise({redirectTo: '/home'});
            
        } ]);


var app = angular.module('cartApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8087/',
    PRODUCT_SERVICE_API : 'http://localhost:8087/product/'
});



app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        alert('Ohayo');
        $stateProvider
            .state('views', {
                url: '/',
                templateUrl: 'views/aaa',
                controller:'productController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, productService) {
                        console.log('Data entry view');
                        var deferred = $q.defer();
                        productService.addProduct().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);
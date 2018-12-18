'use strict';

angular.module('cartApp').factory('productService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                addProduct: addProduct,

            };

            return factory;






            function addProduct(product) {
                console.log('Creating Product');
                var deferred = $q.defer();
                $http.post(urls.PRODUCT_SERVICE_API+add, product)
                    .then(
                        function (response) {
                            console.log(response.data);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while adding product : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }


        }
    ]);
'use strict';

angular.module('cartApp').controller('productController',
    ['productService', '$scope',  function( productService, $scope) {

        var self = this;


        self.submit = submit;

        self.addProduct=addProduct;
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
                console.log('Saving New User', self.product);
                alert('in submit');
                addProduct(self.product);

        }

        function addProduct(product) {
            console.log('About to create user');
            productService.addProduct(product)
                .then(
                    function (response) {
                        console.log('Product added successfully');
                        self.successMessage = 'Product added successfully';
                        self.errorMessage = '';
                        self.done = true;
                        self.user = {};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while adding product');
                        self.errorMessage = 'Error while adding product: ' + errResponse.data.errorMessage;
                        self.successMessage = '';
                    }
                );
        }
    }

    ]);
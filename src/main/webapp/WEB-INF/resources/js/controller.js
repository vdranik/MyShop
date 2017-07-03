var cardApp = angular.module ("cardApp", []);

cardApp.controller("cardCtrl", function($scope, $http){

    $scope.refreshCard = function(){
        $http.get('/myShop/rest/card/' + $scope.cardId).success(function (data){
            $scope.card = data;
        });
    };

    $scope.clearCard = function(){
        $http.delete('/myShop/rest/card/' + $scope.cardId).success($scope.refreshCard());
    };

    $scope.initCardId = function(cardId){
        $scope.cardId = cardId;
        $scope.refreshCard(cardId);
    };

    $scope.addToCard = function(productId){
        $http.put('/myShop/rest/card/add/' + productId).success(function (){
            alert('Product successfully added to the card!');
        });
    };

    $scope.removeFromCard = function(productId){
        $http.put('/myShop/rest/card/remove/' + productId).success(function(data){
            $scope.refreshCard();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.card.cardItems.length; i++){
            grandTotal += $scope.card.cardItems[i].totalPrice;
        }

        return grandTotal;
    }
});
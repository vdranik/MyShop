<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Card</h1>
                    <p>All the selected products in your shopping card</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cardApp">

            <div ng-controller = "cardCtrl" ng-init="initCardId('${cardId}')">

                <div>
                    <a class="btn btn-danger pull-left" ng-click = "clearCard()"><span class="glyphicon glyphicon-remove-sign"></span> Clear Card</a>
                    <a href="<spring:url value="/order/${cardId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-card"></span> Check out</a>
                </div>

                <br/><br/><br/>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat = "item in card.cardItems">
                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productPrice}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="label label-danger" ng-click="removeFromCard(item.product.productId)"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="<spring:url value="/productList" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>

<!-- My -->
<script src="<c:url value="/resources/js/controller.js" /> "></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
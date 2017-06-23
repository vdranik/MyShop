<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/23/2017
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">this is the administrator page</p>
        </div>

        <h3>
            <a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify product inventory!</p>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="<c:url value="/resources/images/console.jpg" />" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Welcome to MyShop</h1>
                            <p>CONSOLES!Bla-bla-bla</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="<c:url value="/resources/images/games.jpg" />" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Facts You Should know About Games</h1>
                            <p>GAMES!Bla-bla-bla</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="<c:url value="/resources/images/accessory.jpg" />" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Accessory</h1>
                            <p>ACCESSORY!Bla-bla-bla</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

        <div class="container marketing">

            <!-- Three columns of text below the carousel -->
            <div class="row">
                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Console" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/console.jpg"/>" alt="Console Image" width="140" height="140">
                    </a>

                    <h2>Console:</h2>
                    <p>Cooooooonsoles</p>

                </div>



                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Game" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/games.jpg"/>" alt="Game Image" width="140" height="140">
                    </a>

                    <h2>Games:</h2>
                    <p>Games-games-games</p>

                </div>


                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Accessory" />" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/accessory.jpg"/>" alt="Accessory Image" width="140" height="140">
                    </a>

                    <h2>Accessories:</h2>
                    <p>All gamers and related geeky goods</p>

                </div>
            </div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>

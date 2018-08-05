<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>appPARTMENTS main</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <#include "Menu.ftlh">
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron jumbotron-fluid">
            <#include "Header.ftlh">
    </header>

    <!-- Page Features -->
    <#if promotedAds??>
        <h5 class="main-page-section">Polecamy!</h5>

    <div class="row text-center cards">
        <#list promotedAds as ad>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL1}" alt="">
                    <div class="card-body">
                        <img class="star" src="http://kodziaki.jjdd4.is-academy.pl/images/star3.png"/>
                        <h5 class="card-title"><b>${ad.title}</b></h5>
                        <p class="" city">${ad.city}, ${ad.district}</p>
                    </div>
                    <div class="card-footer">
                        <a href="/detailed?id=${ad.id}"
                           class="btn btn-primary">Zobacz</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
    </br></br>

    <h5 class="main-page-section">Najczęściej odwiedzane</h5>

    <div class="row text-center cards">
        <#list mostPopularAds as ad>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL1}" alt="">
                    <div class="card-body">
                        <h5 class="card-title"><b>${ad.title}</b></h5>
                        <p class="city">${ad.city}, ${ad.district}</p>
                        <p>wyświetleń: ${ad.visits}</p>
                    </div>
                    <div class="card-footer">
                        <a href="/detailed?id=${ad.id}"
                           class="btn btn-primary">Zobacz</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>

    <#else>
        <h5 class="main-page-section">Baza danych nie została wczytana.</h5>
    <a class="btn btn-primary" href="create-db" role="button">Wczytaj bazę danych</a>
    </#if>

    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<#include "Footer.ftlh">

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
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
    <header class="jumbotron my-4">
            <#include "Header.ftlh">
    </header>

    <!-- Page Features -->
    <div class="row text-center">
        <#list promotedAds as ad>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img width="254" height="200" src="http://127.0.0.1:4200/${ad.imageURL1}" alt="">
                    <div class="card-body">
                        <h5 class="promoted" style="color:#ffcc00;">*POLECANE!*</h5>
                        <h4 class="card-title"><b>${ad.title}</b></h4>
                        <h5 class="" city">${ad.city}, ${ad.district}</h5>
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

    <div class="row text-center">
        <#list mostPopularAds as ad>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img width="254" height="200" src="http://127.0.0.1:4200/${ad.imageURL1}" alt="">
                    <div class="card-body">
                    <#--<h5 class="promoted" style="color:#6666ff;">*NOWOŚĆ!*</h5>-->
                        <h4 class="card-title"><b>${ad.title}</b></h4>
                        <h5 class="city">${ad.city}, ${ad.district}</h5>
                    </div>
                    <div class="card-footer">
                        <a href="/detailed?id=${ad.id}"
                           class="btn btn-primary">Zobacz</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
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
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>appPARTMENTS: Filtered Ads</title>

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
    <div class="row text-center">
        <#list filteredAds as ad>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card">
                    <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                    <div class="card-body">
                        <h4 class="card-title"><b>${ad.title}</b></h4>
                            <#if ad.id == 3 || ad.id == 7 || ad.id == 11 || ad.id == 18 || ad.id == 1 || ad.id == 20>
                                 <h5 class="promoted" style="color:#ffcc00;">*POLECANE!*</h5>
                            </#if>
                        <h5 class="" city">${ad.city}, ${ad.district}</h5>
                    </div>
                    <div class="card-footer">
                        <a href="/detailed?id=${ad.id}" class="btn btn-primary">Zobacz</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<#include "Footer.ftlh">

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
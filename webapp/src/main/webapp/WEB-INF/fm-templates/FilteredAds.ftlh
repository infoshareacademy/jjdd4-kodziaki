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
<div class="container main-content">
    <div class="row text-center">
        <#if filteredAds?size != 0>
            <#list filteredAds as ad>
                <#include "AdCard.ftlh">
            </#list>
        <#else>
            <h2>Nie znaleziono ogłoszeń o wskazanych parametrach.</h2>
            <h2>Spróbuj jeszcze raz.</h2><a class="btn btn-primary" href="search"> >>>>>>> </a>
        </#if>
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
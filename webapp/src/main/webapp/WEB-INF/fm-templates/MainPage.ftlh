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

    <!-- Font Awesome -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

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

    <!-- Jumbotron Header -->
    <header class="jumbotron jumbotron-fluid">
            <#include "Header.ftlh">
    </header>

    <!-- Page Features -->

    <#if promotedAds??>
        <h5 class="main-page-section">Polecamy!</h5>

        <div class="row text-center cards">
            <#list promotedAds as ad>
                <#include "AdCard.ftlh">
            </#list>
        </div>
        </br></br>

        <h5 class="main-page-section">Najczęściej odwiedzane</h5>

        <div class="row text-center cards">
            <#list mostPopularAds as ad>
                <#include "AdCard.ftlh">
            </#list>
        </div>
    <#else>

        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h5 class="main-page-section">Baza danych nie została wczytana.</h5>
                    <a class="btn btn-primary" href="create-db" role="button">Wczytaj bazę danych</a>
                </div>
            </div>
        </div>

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
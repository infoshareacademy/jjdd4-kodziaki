<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>appPARTMENTS: Detailed Ad</title>

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

    <#list randomPlace as random>
    <!-- Portfolio Item Heading -->
        <h1 class="my-4"><b>${random.title}</b></h1>
        <h2>${random.city}, ${random.district}</h2>

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="col-md-8">
            <img class="img-fluid" src="http://placehold.it/750x500" alt="">
        </div>

        <div class="col-md-4">
            <h3 class="my-3">Szczegółowe informacje</h3>
            <ul>
                <li>Cena: ${random.price}</li>
                <li>Typ: ${random.placeType}</li>
                <li>Powierzchnia: ${random.area} </li>
                <li>Liczba pokoi: ${random.rooms}</li>
                <li>Piętro: #{random.floor}</li>
                <li>Winda: ${random.hasElevator?string("tak", "nie")} </li>
                <li>Zwierzęta dozwolone: ${random.animalAllowed?string("tak", "nie")} </li>
                <li>Palenie dozwolone: ${random.smokingAllowed?string("tak", "nie")}</li>
                <li>Tylko wynajemn długoterminowy: ${random.onlyLongTerm?string("tak", "nie")} </li>
                <li>Opis: ${random.description}</li>
                <li>Autor: ${random.author}</li>
                <li>Kontakt: ${random.phoneNumber}</li>
                <li>ID: ${random.id}</li>
            </ul>
        </div>
        </#list>
    </div>
    <!-- /.row -->

    <!-- Related Projects Row -->
    <h3 class="my-4">Zdjęcia</h3>

    <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://placehold.it/500x300" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://placehold.it/500x300" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://placehold.it/500x300" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://placehold.it/500x300" alt="">
            </a>
        </div>

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
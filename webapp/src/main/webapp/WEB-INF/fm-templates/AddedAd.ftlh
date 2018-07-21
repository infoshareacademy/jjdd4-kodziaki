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

    <!-- Portfolio Item Heading -->
    <h1 class="my-4"><b>${addedAd.title}</b></h1>
    <h2>${addedAd.city}, ${addedAd.district}</h2>

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="col-md-8">
            <img class="img-fluid" src="http://placehold.it/750x500" alt="">
        </div>

        <div class="col-md-4">
            <h3 class="my-3">Szczegółowe informacje</h3>
            <ul>
                <li>Cena: ${addedAd.price}</li>
                <li>Typ: ${addedAd.placeType}</li>
                <li>Powierzchnia: ${addedAd.area} </li>
                <li>Liczba pokoi: ${addedAd.rooms}</li>
                <li>Piętro: #{addedAd.floor}</li>
                <li>Winda: ${addedAd.hasElevator?string("tak", "nie")} </li>
                <li>Zwierzęta: ${addedAd.animalAllowed?string("dozwolone", "niedozwolone")} </li>
                <li>Palenie: ${addedAd.smokingAllowed?string("dozwolone", "niedozwolone")}</li>
                <li>Tylko wynajemn długoterminowy: ${addedAd.onlyLongTerm?string("tak", "nie")} </li>
                <li>Opis: ${addedAd.description}</li>
                <li>Autor: ${addedAd.author}</li>
                <li>Kontakt: ${addedAd.phoneNumber}</li>
                <li>ID: ${addedAd.id}</li>
            </ul>
        </div>
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
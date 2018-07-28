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
    <h1 class="my-4"><b>${randomPlace.title}</b></h1>
    <h2>${randomPlace.city}, ${randomPlace.district}</h2>

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="col-md-8">
            <img class="img-fluid" src="http://127.0.0.1:8080/appPartments${randomPlace.imageURL1}" alt="">
        </div>

        <div class="col-md-4">
            <h3 class="my-3">Szczegółowe informacje</h3>
            <ul>
                <li>Cena: ${randomPlace.price}</li>
                <li>Typ: ${randomPlace.placeType}</li>
                <li>Powierzchnia: ${randomPlace.area} </li>
                <li>Liczba pokoi: ${randomPlace.rooms}</li>
                <li>Piętro: #{randomPlace.floor}</li>
                <li>Winda: ${randomPlace.hasElevator?string("tak", "nie")} </li>
                <li>Zwierzęta: ${randomPlace.animalAllowed?string("dozwolone", "niedozwolone")} </li>
                <li>Palenie: ${randomPlace.smokingAllowed?string("dozwolone", "niedozwolone")}</li>
                <li>Tylko wynajemn długoterminowy: ${randomPlace.onlyLongTerm?string("tak", "nie")} </li>
                <li>Opis: ${randomPlace.description}</li>
                <li>Autor: ${randomPlace.author}</li>
                <li>Kontakt: ${randomPlace.phoneNumber}</li>
                <li>ID: ${randomPlace.id}</li>
            </ul>
        </div>
    </div>
    <!-- /.row -->

    <!-- Related Projects Row -->
    <h3 class="my-4">Zdjęcia</h3>

    <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://127.0.0.1:8080/appPartments${randomPlace.imageURL2}" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://127.0.0.1:8080/appPartments${randomPlace.imageURL3}" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://127.0.0.1:8080/appPartments${randomPlace.imageURL4}" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="http://127.0.0.1:8080/appPartments${randomPlace.imageURL1}" alt="">
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
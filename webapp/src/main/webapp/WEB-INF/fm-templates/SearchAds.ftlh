<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>appPARTMENTS: Search Ads</title>

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
< class="container">

    <form>
        <div data-role="range-slider">
            <label for="price-min">Cena min:</label>
            <input type="range" name="price-min" id="price-min" value="100" min="0" max="5000" step="10">
            <label for="price-max">Cena max:</label>
            <input type="range" name="price-max" id="price-max" value="800" min="0" max="5000" step="10">
        </div>
        <div data-role="range-slider">
            <label for="area-min">Powierzchnia od:</label>
            <input type="range" name="area-min" id="area-min" value="10" min="0" max="500" step="1">
            <label for="area-max">Powierzchnia do:</label>
            <input type="range" name="area-max" id="area-max" value="70" min="0" max="500" step="1">
        </div>
        <div data-role="range-slider">
            <label for="rooms-min">Pokoje od:</label>
            <input type="range" name="rooms-min" id="rooms-min" value="1" min="1" max="6" step="1">
            <label for="rooms-max">Pokoje do:</label>
            <input type="range" name="rooms-max" id="rooms-max" value="3" min="1" max="6" step="1">
        </div>
        <div data-role="range-slider">
            <label for="floor-min">Piętro od:</label>
            <input type="range" name="floor-min" id="floor-min" value="1" min="0" max="20" step="1">
            <label for="floor-max">Piętro do:</label>
            <input type="range" name="floor-max" id="floor-max" value="10" min="0" max="20" step="1">
        </div>
        </div>
        <div class="checkbox">
            <label><input type="checkbox"> Winda</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox"> Zwierzęta dozwolone</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox"> Dla niepalących</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox"> Długoterminowo</label>
        </div>
        <button type="submit" class="search-button" href="filtered">Poka co tam macie</button
    </form>

</div>
<!-- /.container -->

<!-- Footer -->
<#include "Footer.ftlh">

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
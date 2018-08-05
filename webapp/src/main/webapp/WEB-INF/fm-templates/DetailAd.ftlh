<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>: Detailed Ad</title>

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

    <!-- Message after adding ad -->
    <#if message??>
        <h5>${message}</h5>
    </#if>

    <!-- Portfolio Item Heading -->
    <h3 class="my-4"><b>${ad.title}</b></h3>
    <h5>${ad.city}, ${ad.district}</h5>
    <#if ad.isPromoted()>
        <img class="star" src="http://kodziaki.jjdd4.is-academy.pl/images/star3.png"/> <p>p</p>
    </#if>

    <!-- Portfolio Item Row -->
    <div class="row">
        <div class="col-md-8">
            <#if (ad.imageURL1)??>
                <img width="750" height="500" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL1}" alt="">
            </#if>
        </div>
        <div class="col-md-4">
            <p>Cena: <b>${ad.price} zł</b></p>
                <#switch ad.placeType>
                    <#case "BED">
                        <p>Typ wynajmu: <b>Miejsce w pokoju</b></p>
                        <#break>
                    <#case "ROOM">
                        <p>Typ wynajmu: <b>Pokój</b></p>
                        <#break>
                    <#case "APARTMENT">
                        <p>Typ wynajmu: <b>Mieszkanie</b></p>
                        <#break>
                </#switch>
            <p>Powierzchnia: <b>${ad.area} m<sup>2</sup></b></p>
            <p>Liczba pokoi: <b>${ad.rooms}</b></p>
            <p>Piętro: <b>#{ad.floor}</b></p>
            <p>Winda: <b>${ad.hasElevator?string("tak", "nie")}</b></p>
            <p>Zwierzęta: <b>${ad.animalAllowed?string("dozwolone", "niedozwolone")}</b></p>
            <p>Palenie: <b>${ad.smokingAllowed?string("dozwolone", "niedozwolone")}</b></p>
            <p>Tylko wynajem długoterminowy: <b>${ad.onlyLongTerm?string("tak", "nie")}</b></p>
            <p>Opis: </p>
            <div class="descriptionArea">
            ${ad.description}
            </div>
            <p>Autor: <b>${ad.author}</b></p>
            <p>Kontakt: <b>${ad.phoneNumber}</b></p>
            <p>ID: <b>${ad.id}</b></p>
            <p>Odwiedzin: <b>${ad.visits}</b></p>
        </div>
    </div>
    <!-- /.row -->

    <!-- Related Projects Row -->
    <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL2}" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL3}" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL4}" alt="">
            </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL5}" alt="">
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
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

    <!-- Message after adding ad -->
    <#if message??>
        <h5>${message}</h5>
    </#if>

    <!-- Portfolio Item Heading -->
    <h3 class="my-4"><b>${ad.title?upper_case}</b><#if ad.isPromoted()>
        <img class="ad-stars" src="http://kodziaki.jjdd4.is-academy.pl/images/star3.png"/>
    </#if></h3>
    <h5>${ad.city}, ${ad.district}</h5>
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

    <!-- Portfolio Item Row -->
    <div class="row">
        <div class="col-md-8">
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <#if (ad.imageURL1)??>
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL1}"
                                 alt="First slide" height="500">
                        </div>
                    </#if>
                    <#if (ad.imageURL2)??>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL2}"
                                 alt="Second slide" height="500">
                        </div>
                    </#if>
                    <#if (ad.imageURL3)??>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL3}"
                                 alt="Third slide">
                        </div>
                    </#if>
                    <#if (ad.imageURL4)??>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL4}"
                                 alt="Fourth slide">
                        </div>
                    </#if>
                    <#if (ad.imageURL5)??>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL5}"
                                 alt="Fifth slide">
                        </div>
                    </#if>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Poprzedni</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Następny</span>
                </a>
            </div>
        </div>

        <div class="col-md-4 ad-details">
            <h4>Cena: <b>${ad.price} zł</b></h4>
            <ul>
                <li>Powierzchnia: <b>${ad.area} m<sup>2</sup></b></li>
                <li>Liczba pokoi: <b>${ad.rooms}</b></li>
                <li>Piętro: <b>#{ad.floor}</b></li>
            </ul>
            <p>Dodatkowe informacje</p>
            <hr>
            <ul>
                <li>Winda: <b>${ad.hasElevator?string("tak", "nie")}</b></li>
                <li>Zwierzęta: <b>${ad.animalAllowed?string("dozwolone", "niedozwolone")}</b></li>
                <li>Palenie: <b>${ad.smokingAllowed?string("dozwolone", "niedozwolone")}</b></li>
                <li>Tylko wynajem długoterminowy: <b>${ad.onlyLongTerm?string("tak", "nie")}</b></li>
            </ul>
            <p>Kontakt</p>
            <hr>
            <ul>
                <li>Wynajmujący: <b>${ad.author}</b></li>
                <li>Nr telefonu: <b>${ad.phoneNumber}</b></li>
            </ul>
        </div>

    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="ad-description">
            ${ad.description}
            </div>
            <div class="ad-parameters">
                <p>Numer ogłoszenia: <b>${ad.id}</b><br>
                    Liczba odwiedzin: <b>${ad.visits}</b></p>
            </div>
        </div>
    </div>

</div>
<!-- /.container -->

<!-- Footer -->
    <#include "Footer.ftlh">

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>



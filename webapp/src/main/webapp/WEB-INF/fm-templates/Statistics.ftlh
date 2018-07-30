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
    <h1 class="my-4"><b>Statystyki</b></h1>

    <!-- Portfolio Item Row -->
    <div class="row">
        <div class="col-md-3">
            <h4><b>Popularność ogłoszeń z danej dzielnicy</b></h4>
            <table>
                <tr>
                    <td>Dzielnica</td>
                    <td>Suma wyświetleń</td>
                </tr>
                <#list districts as district>
                    <tr>
                        <td>${district[0]}</td>
                        <td>${district[1]}</td>
                    </tr>
                </#list>
            </table>
        </div>

        <div class="col-md-3">
            <h4><b>Popularność ogłoszeń z danego miasta</b></h4>
            <table>
                <tr>
                    <td>Miasto</td>
                    <td>Suma wyświetleń</td>
                </tr>
                <#list cities as city>
                    <tr>
                        <td>${city[0]}</td>
                        <td>${city[1]}</td>
                    </tr>
                </#list>
            </table>
        </div>

        <div class="col-md-6">
            <h4><b>Popularność ogłoszeń</b></h4>
            <table>
                <tr>
                    <td>Id ogłoszenia</td>
                    <td>Tytuł</td>
                    <td>Suma wyświetleń</td>
                </tr>
                <#list ads as ad>
                    <tr>
                        <td>${ad.id}</td>
                        <td>${ad.title}</td>
                        <td>${ad.visits}</td>
                    </tr>
                </#list>
            </table>
        </div>
        <!-- /.row -->
    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<#include "Footer.ftlh">

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
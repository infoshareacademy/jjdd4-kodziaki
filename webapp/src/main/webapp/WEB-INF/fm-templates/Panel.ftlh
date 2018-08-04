<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>appPARTMENTS: Panel</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">

    <#--<!--Load the AJAX API&ndash;&gt;-->
    <#--<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>-->
    <#--<script type="text/javascript">-->
        <#--google.charts.load("current", {packages:["corechart"]});-->
        <#--google.charts.setOnLoadCallback(drawChart);-->
        <#--function drawChart() {-->
            <#--var data = google.visualization.arrayToDataTable([-->
                <#--['Miasto', 'Liczba wyświetleń'],-->
                <#--<#list citiesStatistics as city>-->
                       <#--['${city[0]}', '${city[1]}'],-->
                <#--</#list>-->
            <#--]);-->

            <#--var options = {-->
                <#--legend: 'none',-->
                <#--pieSliceText: 'label',-->
                <#--title: 'Liczba wyświetleń ogłoszeń z danego miasta',-->
                <#--pieStartAngle: 100,-->
            <#--};-->

            <#--var chart = new google.visualization.PieChart(document.getElementById('piechart'));-->
            <#--chart.draw(data, options);-->
        <#--}-->
    <#--</script>-->



<#return output>
</#function>

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
    <div class="container admin-panel-container">
        <div class="row">
            <div class="col-3">
                <h5>Ustawienia</h5>
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Statystyki ogłoszeń</a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Statystyki miast</a>
                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Statystyki dzielnic</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Edycja ogłoszeń</a>
                </div>
            </div>
            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <#function pieChart rawData>
                        <#local data = [] />

                        <#list rawData as i>
                            <#local data = data + [] />
                        </#list>

                        <#local output =
                        "https://chart.googleapis.com/chart" +
                        "?cht=pc" +
                        "&chs=130x130" +
                        "&chco=ffffff,066639,08a15e,7acfa9" +
                        "&chp=-1.6" +
                        "&chd=t:0|15,14,72"
                        />

                    <img src="${pieChart([10, 20, 50])}" />

                        <div id="chart_div"></div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">

                    <#include "CitiesStat.ftlh">
                    </div>
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                    <#include "DistrictsStat.ftlh">
                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                    <#include "EditAds.ftlh">
                    </div>
                </div>
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
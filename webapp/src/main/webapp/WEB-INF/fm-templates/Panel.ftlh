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

    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

        // Load the Visualization API and the corechart package.
        google.charts.load('current', {'packages': ['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawAdsChart);
        google.charts.setOnLoadCallback(drawCitiesChart);
        google.charts.setOnLoadCallback(drawGdanskChart);
        google.charts.setOnLoadCallback(drawGdyniaChart);
        google.charts.setOnLoadCallback(drawSopotChart);

        function drawAdsChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Id');
            data.addColumn('number', 'Wyświetlenia');
            data.addRows([
                <#list adsStat as ad>
                ['id (${ad.id})', ${ad.visits}],
                </#list>
            ]);

            var options = {
                'title': 'Statystyki wyswietleń poszczególnych ogłoszeń',
                'width': 800,
                'height': 600
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div_ads'));
            chart.draw(data, options);
        }

        function drawCitiesChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Miasto');
            data.addColumn('number', 'Wyświetlenia');
            data.addRows([
        <#list citiesStat as city>
        ['${city[0]}', ${city[1]}],
        </#list>
            ]);

            var options = {
                'title': 'Suma wyświetleń ogłoszeń z danego miasta',
                'width': 800,
                'height': 600
            };

            var chart = new google.visualization.PieChart(document.getElementById('chart_div_cities'));
            chart.draw(data, options);
        }

        function drawGdanskChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Dzielnica');
            data.addColumn('number', 'Wyświetlenia');
            data.addRows([
        <#list gdanskStat as district, visits>
        ['${district}', ${visits}],
        </#list>
            ]);

            var options = {
                'title': 'Suma wyświetleń ogłoszeń z poszczególnych dzielnic miasta Gdańsk',
                'width': 800,
                'height': 600
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div_gdansk'));
            chart.draw(data, options);
        }

        function drawGdyniaChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Dzielnica');
            data.addColumn('number', 'Wyświetlenia');
            data.addRows([
        <#list gdyniaStat as district, visits>
        ['${district}', ${visits}],
        </#list>
            ]);

            var options = {
                'title': 'Suma wyświetleń ogłoszeń z poszczególnych dzielnic miasta Gdynia',
                'width': 800,
                'height': 600
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div_gdynia'));
            chart.draw(data, options);
        }

        function drawSopotChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Dzielnica');
            data.addColumn('number', 'Wyświetlenia');
            data.addRows([
        <#list sopotStat as district, visits>
        ['${district}', ${visits}],
        </#list>
            ]);

            var options = {
                'title': 'Suma wyświetleń ogłoszeń z poszczególnych dzielnic miasta Sopot',
                'width': 800,
                'height': 600
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div_sopot'));
            chart.draw(data, options);
        }

    </script>

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

                    <a class="nav-link active" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings"
                       role="tab"
                       aria-controls="v-pills-settings" aria-selected="false">Edycja ogłoszeń</a>

                    <a class="nav-link" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab"
                       aria-controls="v-pills-home" aria-selected="true">Statystyki ogłoszeń</a>

                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
                       aria-controls="v-pills-profile" aria-selected="false">Statystyki miast</a>

                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab"
                       aria-controls="v-pills-messages" aria-selected="false">Statystyki dzielnic</a>

                    <a class="nav-link" id="v-pills-raports-tab" data-toggle="pill" href="#v-pills-raports" role="tab"
                       aria-controls="v-pills-raports" aria-selected="false">Generowanie raportów</a>
                </div>
            </div>
            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">

                    <div class="tab-pane fade show active" id="v-pills-settings" role="tabpanel"
                         aria-labelledby="v-pills-settings-tab">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-1">Id</div>
                                <div class="col-sm-4">Tytuł</div>
                                <div class="col-sm-1">Odwiedzin</div>
                                <div class="col-sm-2"></div>
                                <div class="col-sm-2"></div>
                            </div>
                                <#list ads as ad>
                                    <div class="row">
                                        <div class="col-sm-1">
                                            ${ad.id}
                                        </div>
                                        <div class="col-sm-4">
                                            ${ad.title}
                                        </div>
                                        <div class="col-sm-1">
                                            ${ad.visits}
                                        </div>
                                        <div class="col-sm-2">
                                            <#if ad.isPromoted()>
                                                <form method="POST" action="/edit">
                                                    <input type="text" class="form-control" name="id" value="${ad.id}"
                                                           hidden>
                                                    <input type="text" class="form-control" name="action"
                                                           value="unpromote" hidden>
                                                    <button type="submit" class="btn btn-primary">Zakończ promowanie
                                                    </button>
                                                </form>
                                            <#else>
                                                <form method="POST" action="/edit">
                                                    <input type="text" class="form-control" name="id" value="${ad.id}"
                                                           hidden>
                                                    <input type="text" class="form-control" name="action"
                                                           value="promote" hidden>
                                                    <button type="submit" class="btn btn-primary">Promuj</button>
                                                </form>
                                            </#if>
                                        </div>
                                        <div class="col-sm-2">
                                            <form method="POST" action="/edit">
                                                <input type="text" class="form-control" name="id" value="${ad.id}"
                                                       hidden>
                                                <input type="text" class="form-control" name="action" value="delete"
                                                       hidden>
                                                <button type="submit" class="btn btn-primary">Usuń</button>
                                            </form>
                                        </div>
                                    </div>
                                </#list>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <div id="chart_div_ads"></div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
                         aria-labelledby="v-pills-profile-tab">
                        <div id="chart_div_cities"></div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab">
                        <div id="chart_div_gdansk"></div>
                        <div id="chart_div_gdynia"></div>
                        <div id="chart_div_sopot"></div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-raports" role="tabpanel"
                         aria-labelledby="v-pills-raports-tab">
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
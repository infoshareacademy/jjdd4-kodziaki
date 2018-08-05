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
        google.charts.load('current', {'packages':['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawAdsChart);

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawCitiesChart);

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawDistrictsChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawAdsChart() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Id');
            data.addColumn('number', 'wyświetlenia');
            data.addRows([
                <#list ads as ad>
                ['id (${ad.id})', ${ad.visits}],
                </#list>
            ]);

            // Set chart options
            var options = {'title':'Statystyki wyswietleń poszczególnych ogłoszeń',
                'width':800,
                'height':600};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.BarChart(document.getElementById('chart_div_ads'));
            chart.draw(data, options);
        }

        function drawCitiesChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Miasto');
        data.addColumn('number', 'wyświetlenia');
        data.addRows([
        <#list cities as city>
        ['${city[0]}', ${city[1]}],
        </#list>
        ]);

        // Set chart options
        var options = {'title':'Suma wyświetleń ogłoszeń z danego miasta',
        'width':800,
        'height':600};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div_cities'));
        chart.draw(data, options);
        }

        <#--function drawDistrictsChart() {-->

            <#--// Create the data table.-->
            <#--var data = new google.visualization.DataTable();-->
            <#--data.addColumn('string', 'Dzielnica');-->
            <#--data.addColumn('number', 'wyświetlenia');-->
            <#--data.addRows([-->
                <#--<#list districts as district>-->
                <#--['${district[0]}', ${district[1]}],-->
                <#--</#list>-->
            <#--]);-->

            <#--// Set chart options-->
            <#--var options = {'title':'Suma wyświetleń ogłoszeń z danej dzielnicy',-->
                <#--'width':800,-->
                <#--'height':600};-->

            <#--// Instantiate and draw our chart, passing in some options.-->
            <#--var chart = new google.visualization.BarChart(document.getElementById('chart_div_districts'));-->
            <#--chart.draw(data, options);-->
        <#--}-->

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
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Statystyki ogłoszeń</a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Statystyki miast</a>
                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Statystyki dzielnic</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Edycja ogłoszeń</a>
                    <a class="nav-link" id="v-pills-raports-tab" data-toggle="pill" href="#v-pills-raports" role="tab" aria-controls="v-pills-raports" aria-selected="false">Generowanie raportów</a>
                </div>
            </div>
            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <div id="chart_div_ads"></div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                        <div id="chart_div_cities"></div>
                    </div>
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                        <#--<div id="chart_div_districts"></div>-->
                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                        <div class="container">

                                <#list ad as ad>
                                    <div class="row">
                                <div class="col-sm">
                                    ${ad.id}
                                </div>
                                <div class="col-sm">
                                    ${ad.title}
                                </div>
                                <div class="col-sm">
                                    <input class="btn btn-primary" type="button">
                                </div>
                                    </div>
                                </#list>

                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-raports" role="tabpanel" aria-labelledby="v-pills-raports-tab">
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
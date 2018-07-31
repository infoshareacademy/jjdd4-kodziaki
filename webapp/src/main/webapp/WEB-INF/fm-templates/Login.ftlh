<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>appPARTMENTS main</title>

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

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
            <#include "Header.ftlh">
    </header>

    <!-- Page Features -->
    <div class="row text-center">
        <div class="col-lg-3 col-md-6 mb-4">
            <#include "../login.jsp">
            <#--<div class="g-signin2" data-onsuccess="onSignIn"></div>-->
                <#--<form method=”GET” action=”googleplus”></form>-->
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

</html>
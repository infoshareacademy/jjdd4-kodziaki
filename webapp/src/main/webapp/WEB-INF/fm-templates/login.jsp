<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="64666962785-3t7g65b7veos86fm3lbphjuv4vn4c7p5.apps.googleusercontent.com">

    <title>appPartments - logowanie</title>
</head>
<body>
<h2>Zaloguj się i pamiętaj o RODO</h2>
<br>
<div class="g-signin2" data-onsuccess="onSignIn" data-longtitle="true"></div>

<script>
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        console.log('id_token: ' + googleUser.getAuthResponse().id_token);


        var redirectUrl = 'login';

        //using jquery to post data dynamically
        var form = $('<form action="' + redirectUrl + '" method="post">' +
            '<input type="text" name="id_token" value="' +
            googleUser.getAuthResponse().id_token + '" />' +
            '</form>');
        $('body').append(form);
        form.submit();
    }
</script>
</body>
</html>
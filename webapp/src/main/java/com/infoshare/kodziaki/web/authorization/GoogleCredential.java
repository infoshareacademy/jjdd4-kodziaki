package com.infoshare.kodziaki.web.authorization;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.*;
import com.google.api.client.json.JsonFactory;


public class GoogleCredential extends Credential {

    public static GoogleCredential createCredentialWithAccessTokenOnly(TokenResponse tokenResponse) {
//        return new GoogleCredential().setFromTokenResponse(tokenResponse);

//
//        JsonFactory jsonFactory = new JacksonFactory();
//        HttpTransport httpTransport = new NetHttpTransport();
//        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(httpTransport, jsonFactory,
//                "680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com", "PSkGx2arCOw6jQotZ2vtdBN_", code, "postmessage").execute();

        return new GoogleCredential.Builder(BearerToken.authorizationHeaderAccessMethod())
                .setFromTokenResponse(tokenResponse);
    }


    public static GoogleCredential createCredentialWithRefreshToken(HttpTransport transport, JsonFactory jsonFactory, GoogleClientSecrets clientSecrets, TokenResponse tokenResponse) {

        return new GoogleCredential.Builder()
                .setTransport(transport)
                .setJsonFactory(jsonFactory)
                .setClientSecrets(clientSecrets)
                .build()
                .setFromTokenResponse(tokenResponse);



        JsonFactory jsonFactory = new JacksonFactory();
        HttpTransport httpTransport = new NetHttpTransport();
        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(httpTransport, jsonFactory,
                "680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com", "PSkGx2arCOw6jQotZ2vtdBN_", code, "postmessage").execute();

        GoogleCredential googleCredential = GoogleCredential.Builder()
                .setJsonFactory(jsonFactory)
                .setTransport(httpTransport)
                .setClientSecrets("680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com", "PSkGx2arCOw6jQotZ2vtdBN_")
                .build()
                .setFromTokenResponse(tokenResponse);

        OAuth2 oauth2 = new OAuth2.Builder(httpTransport, jsonFactory, googleCredential).setApplicationName("appPartments").build();
        Tokeninfo tokenInfo = oauth2.tokeninfo().setAccessToken(googleCredential.getAccessToken()).execute();

        return oauth2.userinfo().get().execute();


    }
}



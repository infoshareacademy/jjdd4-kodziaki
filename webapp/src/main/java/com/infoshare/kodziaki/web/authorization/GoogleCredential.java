package com.infoshare.kodziaki.web.authorization;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

public class GoogleCredential extends Object implements com.google.api.client.http.HttpExecuteInterceptor, com.google.api.client.http.HttpRequestInitializer, com.google.api.client.http.HttpUnsuccessfulResponseHandler {

    public static GoogleCredential createCredentialWithAccessTokenOnly
            (HttpTransport transport, JsonFactory jsonFactory, TokenResponse tokenResponse) {
        return new GoogleCredential.Builder(BearerToken.authorizationHeaderAccessMethod())
                .setFromTokenResponse(tokenResponse);
    }

    public static GoogleCredential createCredentialWithRefreshToken(
            HttpTransport transport, JsonFactory jsonFactory, TokenResponse tokenResponse) {
        return new GoogleCredential.Builder(BearerToken.authorizationHeaderAccessMethod())
                .setTransport(transport)
                .setJsonFactory(jsonFactory)
                .setTokenServerUrl(new GenericUrl("https://server.example.com/token"))
                .setClientAuthentication(new BasicAuthentication("s6BhdRkqt3", "7Fjfp0ZBr1KtDRbnfVdmIw"))
                .build()
                .setFromTokenResponse(tokenResponse);
    }

    public static GoogleCredential createGoogleCredentialWithRefreshToken(){

        JsonFactory jsonFactory = new JacksonFactory();
        HttpTransport httpTransport = new NetHttpTransport();

        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(httpTransport, jsonFactory,
                "680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com", "PSkGx2arCOw6jQotZ2vtdBN_", code, "postmessage").execute();

        com.google.api.client.googleapis.auth.oauth2.GoogleCredential googleCredential = new com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder().setJsonFactory(jsonFactory).setTransport(httpTransport).setClientSecrets("680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com", "PSkGx2arCOw6jQotZ2vtdBN_").build().setFromTokenResponse(tokenResponse);

        Oauth2 oauth2 = new Oauth2.Builder(httpTransport, jsonFactory, googleCredential).setApplicationName("YourAppName").build();
        Tokeninfo tokenInfo = oauth2.tokeninfo().setAccessToken(googleCredential.getAccessToken()).execute();

        return oauth2.userinfo().get().execute();

    }

    @Override
    public void intercept(HttpRequest httpRequest) throws IOException {

    }

    @Override
    public void initialize(HttpRequest httpRequest) throws IOException {

    }

    @Override
    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean b) throws IOException {
        return false;
    }


}
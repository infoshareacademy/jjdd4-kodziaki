package com.infoshare.kodziaki.web.google;

import java.io.IOException;

public class Credential extends Object implements com.google.api.client.http.HttpExecuteInterceptor, com.google.api.client.http.HttpRequestInitializer, com.google.api.client.http.HttpUnsuccessfulResponseHandler {

    public static Credential createCredentialWithAccessTokenOnly(
            HttpTransport transport, JsonFactory jsonFactory, TokenResponse tokenResponse) {
        return new Credential(BearerToken.authorizationHeaderAccessMethod()).setFromTokenResponse(tokenResponse);
    }

    public static Credential createCredentialWithRefreshToken(
            HttpTransport transport, JsonFactory jsonFactory, TokenResponse tokenResponse) {
        return new Credential.Builder(BearerToken.authorizationHeaderAccessMethod())
                .setTransport(transport)
                .setJsonFactory(jsonFactory)
                .setTokenServerUrl(new GenericUrl("https://server.example.com/token"))
                .setClientAuthentication(new BasicAuthentication("s6BhdRkqt3", "7Fjfp0ZBr1KtDRbnfVdmIw"))
                .build()
                .setFromTokenResponse(tokenResponse);
    }

}
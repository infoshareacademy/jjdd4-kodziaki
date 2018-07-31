//package com.infoshare.kodziaki.web.authorization;
//
//import com.google.api.client.auth.oauth2.BearerToken;
//import com.google.api.client.auth.oauth2.TokenResponse;
//import com.google.api.client.http.*;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.auth.oauth2.Credential.Builder;
//import java.io.IOException;
//
//public class Credential
//        extends Object implements com.google.api.client.http.HttpExecuteInterceptor,
//        com.google.api.client.http.HttpRequestInitializer, com.google.api.client.http.HttpUnsuccessfulResponseHandler {
//
//    public static Credential createCredentialWithAccessTokenOnly(
//            HttpTransport transport, JsonFactory jsonFactory, TokenResponse tokenResponse) {
//
//        return new Credential.Builder(BearerToken.authorizationHeaderAccessMethod()).setFromTokenResponse(
//                tokenResponse);
//    }
//
//    public static Credential createCredentialWithRefreshToken(
//            HttpTransport transport, JsonFactory jsonFactory, TokenResponse tokenResponse) {
//
//        return new Credential.Builder(BearerToken.authorizationHeaderAccessMethod()).setTransport(
//                transport)
//                .setJsonFactory(jsonFactory)
//                .setTokenServerUrl(
//                        new GenericUrl("https://server.example.com/token"))
//                .setClientAuthentication(new BasicAuthentication("s6BhdRkqt3", "7Fjfp0ZBr1KtDRbnfVdmIw"))
//                .build()
//                .setFromTokenResponse(tokenResponse);
//
////        OAuth2 oauth2 = new OAuth2.Builder(transport, jsonFactory, googleCredential).setApplicationName("appPartments").build();
////        Tokeninfo tokenInfo = oauth2.tokeninfo().setAccessToken(googleCredential.getAccessToken()).execute();
////
////        return oauth2.userinfo().get().execute();
//    }
//
//    @Override
//    public void intercept(HttpRequest httpRequest) throws IOException {
//
//    }
//
//    @Override
//    public void initialize(HttpRequest httpRequest) throws IOException {
//
//    }
//
//    @Override
//    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean b) throws IOException {
//        return false;
//    }
//}

//package com.infoshare.kodziaki.web.authorization;
//
//import com.google.api.client.auth.oauth2.TokenRequest;
//import com.google.api.client.auth.oauth2.TokenResponse;
//import com.google.api.client.json.webtoken.JsonWebSignature;
//
//import java.io.IOException;
//import java.util.Base64;
//
//public class IdTokenResponseParse extends TokenResponse {
//
////    static JsonWebSignature executeIdToken(TokenRequest tokenRequest) throws IOException {
////
////        IdTokenResponseParse idTokenResponseParse = IdTokenResponseParse.execute(tokenRequest);
////
////        return idTokenResponseParse.parseIdToken();
////    }
//
//
//    public static String parseId(String jwtToken) {
//        String[] split_string = jwtToken.split("\\.");
//        String base64EncodedBody = split_string[1];
//        Base64 base64Url = new Base64(true);
//        String body = new String(base64Url.decode(base64EncodedBody));
//        String[] splitBody = body.split(",");
//        String[] splitid = splitBody[1].split("\"");
//        String returnUserId = splitid[3];
//        return returnUserId;
//    }
//
//}

package com.infoshare.kodziaki.web.authorization;

import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.webtoken.JsonWebSignature;

import java.io.IOException;

public class IdTokenResponse extends TokenResponse {

    static JsonWebSignature executeIdToken(TokenRequest tokenRequest) throws IOException {
        IdTokenResponse idTokenResponse = IdTokenResponse.execute(tokenRequest);
        return idTokenResponse.parseIdToken();
    }

}

package com.infoshare.kodziaki.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.infoshare.kodziaki.web.authorization.Google2Api;
import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.*;



@WebServlet("/googleplus")
public class GooglePlusServlet extends HttpServlet {

    private static final String CLIENT_ID = "680649103500-59lgm340117h0kclrnoie501745m9ovc.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "PSkGx2arCOw6jQotZ2vtdBN_";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //Configure
        ServiceBuilder builder= new ServiceBuilder();
        OAuthService service = builder.provider(Google2Api.class)
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback("http://localhost:4200/appPartments")
                .scope("openid profile email " +
                        "https://www.googleapis.com/auth/plus.login " +
                        "https://www.googleapis.com/auth/plus.me")
                .debug(System.out)
                .build(); //Now build the call

        HttpSession session = request.getSession();
        session.setAttribute("oauth2Service", service);

        response.sendRedirect(service.getAuthorizationUrl(null));
    }
}

// https://www.google.com/search?client=ubuntu&channel=fs&q=Google2Api+class&ie=utf-8&oe=utf-8
// https://oneminutedistraction.wordpress.com/2014/04/29/using-oauth-for-your-javaee-login/
// https://console.developers.google.com/apis/credentials?project=apppartments-1532526845285
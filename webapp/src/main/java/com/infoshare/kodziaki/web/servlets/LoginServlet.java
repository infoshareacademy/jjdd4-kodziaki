package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import org.riversun.oauth2.google.OAuthSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;

import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    private Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "Login.ftlh");
        response.setContentType("text/html;charset=UTF-8");

        GoogleCredential credential = new GoogleCredential(BearerToken.authorizationHeaderAccessMethod()).setAccessToken(accessToken);

                OAuthSession.getInstance().createCredential(request);

        try {
            String idToken = request.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            HttpSession session = request.getSession(true);
            session.setAttribute("userName", name);
            request.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static HttpResponse executeGet(
//            HttpTransport transport, JsonFactory jsonFactory, String accessToken, GenericUrl url)
//            throws IOException {
//        Credential credential =
//                new Credential(BearerToken.authorizationHeaderAccessMethod()).setAccessToken(accessToken);
//        HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
//        return requestFactory.buildGetRequest(url).execute();
//    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "Login.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        response.setContentType("text/html;charset=UTF-8");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
        }

    }

}

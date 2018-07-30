package com.infoshare.kodziaki.web.servlets;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import com.infoshare.kodziaki.web.authorization.AuthenticationControllerProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AuthenticationControllerProvider authenticationControllerProvider;

    private String domain;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        domain = config.getServletContext().getInitParameter("com.auth0.domain");
        try {
            authenticationController = AuthenticationControllerProvider.getInstance(config);
        } catch (UnsupportedEncodingException e) {
            throw new ServletException("Wystąpił błąd.", e);
        }
    }


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


    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
        Template template = templateProvider.getTemplate(getServletContext(), "Login.ftlh");
        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
        }

        String authorizeUrl = authenticationControllerProvider.buildAuthorizeUrl(req, redirectUri)
                .withAudience(String.format("https://%s/userinfo", domain))
                .build();
        resp.sendRedirect(authorizeUrl);

    }

}

package com.infoshare.kodziaki.web.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.kodziaki.web.authorization.IdTokenVerifierAndParser;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import com.infoshare.kodziaki.web.model.UserSession;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
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
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "Login.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
            resp.sendRedirect("/error");
        }

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();

            LOG.info("User name: " + name + "is logged");
            LOG.info("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userLogged", true);
            resp.sendRedirect("/main");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
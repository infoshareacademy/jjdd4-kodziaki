package com.infoshare.kodziaki.web.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.kodziaki.web.authorization.AdminConfig;
import com.infoshare.kodziaki.web.authorization.AdminService;
import com.infoshare.kodziaki.web.authorization.IdTokenVerifierAndParser;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private AdminConfig adminConfig;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "Login.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.warning("Template not found ");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();

            logger.info("User name: " + name + "is logged");
            logger.info("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userLogged", true);
            session.setAttribute("user", name);
            session.setAttribute("email", email);

            if (adminConfig.getAdmins().contains(email)){
                session.setAttribute("adminLogged", true);
                logger.info("User " + name + " is admin.");
            }

            resp.sendRedirect("/main");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
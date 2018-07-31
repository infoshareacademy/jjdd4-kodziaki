//package com.infoshare.kodziaki.web.servlets;
//
//import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
//import com.infoshare.kodziaki.web.authorization.AuthenticationControllerProvider;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.inject.Inject;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    private Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
//
//    @Inject
//    private TemplateProvider templateProvider;
//
//    @Inject
//    private AuthenticationController authenticationController;
//
//    private String domain;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        domain = config.getServletContext().getInitParameter("com.auth0.domain");
//        try {
//            AuthenticationController = AuthenticationControllerProvider.getInstance(config);
//        } catch (UnsupportedEncodingException e) {
//            LOG.error("Wystąpił błąd przy twoorzeniu instancji AuthenticationController.");
//            throw new ServletException("Wystąpił błąd.", e);
//        }
//    }
//
//
//    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
//
//        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
//        Template template = templateProvider.getTemplate(getServletContext(), "Login.ftlh");
//        Map<String, Object> dataModel = new HashMap<>();
//        resp.setContentType("text/html;charset=UTF-8");
//
//        try {
//            template.process(dataModel, resp.getWriter());
//        } catch (TemplateException e) {
//            LOG.error(e.getMessage());
//        }
//
//        String authorizeUrl = authenticationControllerProvider.buildAuthorizeUrl(req, redirectUri)
//                .withAudience(String.format("https://%s/userinfo", domain))
//                .build();
//        resp.sendRedirect(authorizeUrl);
//
//        final String accessToken = (String) SessionUtils.get(req, "accessToken");
//        final String idToken = (String) SessionUtils.get(req, "idToken");
//        if (accessToken != null) {
//            req.setAttribute("userId", accessToken);
//        } else if (idToken != null) {
//            req.setAttribute("userId", idToken);
//        }
//
//        LOG.info("authenticated as id={} accesToken={}", idToken, accessToken);
//
//    }
//
//}

package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.dao.UserDao;
import com.infoshare.kodziaki.web.model.UserSession;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;


@WebServlet("/login2test")
public class Login2Servlet extends HttpServlet {

    @Inject
    private UserSession userSession;

    @Inject
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id_token");

        try {
            HttpResponse<JsonNode> id_token = Unirest.get("https://www.googleapis.com/oauth2/v3/tokeninfo")
                    .queryString("id_token", id)
                    .asJson();

            if (id_token.getStatus() >= 300) {
                resp.getWriter().write("Invalid token, returned status was " + id_token.getStatus());
            } else {
                JSONObject object = id_token.getBody().getObject();
                String name = object.getString("name");
                String email = object.getString("email");

                logger.info("Username: " + name);
                logger.info("User e-mail: " + email);

                userSession.setName(name);
                userSession.setEmail(email);

                if (userDao.findByMail(email) == null) {
                    User user = new User(name, email);
                    userDao.save(user);
                }

                if (attemptToLogIn(email)) {
                    userSession.setLogged(true);
                    setActualBeachIfNotSet(actualBeach);
                    resp.sendRedirect("/parawan/main-menu");

                } else {
                    req.setAttribute("successfulLogin", false);
                    resp.sendRedirect("/login");
                }
            }
        } catch (UnirestException e) {
            logger.error("Cannot validate google token", e);
            e.printStackTrace(resp.getWriter());
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }

    private boolean attemptToLogIn(String email) {
        User user = userDao.findByMail(email);
        if (user.isAdmin()){
            userSession.setAdmin(true);
        }
        if (user != null) {
            userSession.setName(user.getName());
            userSession.setEmail(user.getEmail());
            return true;
        }
        return false;
    }

    public ActualBeach setActualBeachIfNotSet(ActualBeach actualBeach) {
        if (actualBeach.getName() == null || actualBeach.getName().isEmpty()) {
            List<Beach> beaches = beachDao.findAll();
            if (beaches.size() != 0) {
                Beach firstBeachFromDatabase = beaches.get(0);
                actualBeach.setId(firstBeachFromDatabase.getId());
                actualBeach.setName(firstBeachFromDatabase.getName());
                actualBeach.setMaxWidth(firstBeachFromDatabase.getMaxWidth());
                actualBeach.setMaxHeight(firstBeachFromDatabase.getMaxHeight());
            } else {
                logger.error("Error while loading data from database");
            }
        }
        return actualBeach;
    }
}
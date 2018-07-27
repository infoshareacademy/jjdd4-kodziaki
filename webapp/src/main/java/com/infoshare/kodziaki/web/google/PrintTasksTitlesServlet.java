package com.infoshare.kodziaki.web.google;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;

@SuppressWarnings("serial")
public class PrintTasksTitlesServlet extends HttpServlet {

    /**
     * The OAuth Token DAO implementation, used to persist the OAuth refresh token.
     * Consider injecting it instead of using a static initialization. Also we are
     * using a simple memory implementation as a mock. Change the implementation to
     * using your database system.
     */
    public static OAuthTokenDao oauthTokenDao = new OAuthTokenDaoMemoryImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        // If the user is not logged-in it is redirected to the login service, then back to this page
        if (user == null) {
            resp.sendRedirect(userService.createLoginURL(getFullRequestUrl(req)));
            return;
        }

        // Checking if we already have tokens for this user in store
        AccessTokenResponse accessTokenResponse = oauthTokenDao.getKeys(user.getEmail());

        // If we don't have tokens for this user
        if (accessTokenResponse == null) {
            OAuthProperties oauthProperties = new OAuthProperties();
            // Redirect to the Google OAuth 2.0 authorization endpoint
            resp.sendRedirect(new GoogleAuthorizationRequestUrl(oauthProperties.getClientId(),
                    OAuthCodeCallbackHandlerServlet.getOAuthCodeCallbackHandlerUrl(req), oauthProperties
                    .getScopesAsString()).build());
            return;
        }
    }

    /**
     * Construct the request's URL without the parameter part.
     *
     * @param req the HttpRequest object
     * @return The constructed request's URL
     */
    public static String getFullRequestUrl(HttpServletRequest req) {
        String scheme = req.getScheme() + "://";
        String serverName = req.getServerName();
        String serverPort = (req.getServerPort() == 80) ? "" : ":" + req.getServerPort();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = (req.getPathInfo() == null) ? "" : req.getPathInfo();
        String queryString = (req.getQueryString() == null) ? "" : "?" + req.getQueryString();
        return scheme + serverName + serverPort + contextPath + servletPath + pathInfo + queryString;
    }
}

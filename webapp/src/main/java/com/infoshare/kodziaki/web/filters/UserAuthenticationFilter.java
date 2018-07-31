package com.infoshare.kodziaki.web.filters;

import com.infoshare.kodziaki.web.model.UserSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import javax.inject.Inject;

@WebFilter(
        filterName = "UserAuthenticationFilter",
        urlPatterns = {"appPartments/login", "appPartments/add", "*/save"}
        )
public class UserAuthenticationFilter implements Filter {

    @Inject
    private UserSession userSession;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        User user = (User) request.getSession().getAttribute("user");
        HttpServletResponse response = (HttpServletResponse) resp;

        if (userSession.isLogged() != true) {
            resp.getWriter().println("Nie posiadasz uprawnień - zaloguj się");
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
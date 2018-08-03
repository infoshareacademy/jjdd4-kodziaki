package com.infoshare.kodziaki.web.filters;

import com.infoshare.kodziaki.web.model.UserSession;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import javax.inject.Inject;

@WebFilter(
        filterName = "AdminAuthenticationFilter",
        urlPatterns = {"/admin/*"},
                initParams = {@WebInitParam(name = "isAdmin", value = "true")
        })
public class AdminAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        try {
            boolean isAdmin = (boolean)request.getSession().getAttribute("adminLogged");
            filterChain.doFilter(req, resp);
        } catch (Exception e) {
            resp.getWriter().println("Nie posiadasz uprawnień - zaloguj się");
            response.sendRedirect("/login");
        }

    }
}
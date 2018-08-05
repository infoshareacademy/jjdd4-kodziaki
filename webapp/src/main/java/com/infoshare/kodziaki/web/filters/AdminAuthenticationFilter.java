package com.infoshare.kodziaki.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException {

        HttpServletResponse response = (HttpServletResponse) resp;

        try {
            filterChain.doFilter(req, resp);
        } catch (Exception e) {
            resp.getWriter().println("Nie posiadasz uprawnień - zaloguj się");
            response.sendRedirect("/login");
        }

    }
}
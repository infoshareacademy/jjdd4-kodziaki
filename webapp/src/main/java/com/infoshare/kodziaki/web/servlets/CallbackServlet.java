package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.authorization.GetUserInfo;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns={"/callback"}, asyncSupported=true)
public class CallbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        //Check if the user have rejected
        String error = req.getParameter("error");
        if ((null != error) && ("access_denied".equals(error.trim()))) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
            return;
        }

        //OK the user have consented so lets find out about the user
        AsyncContext ctx = req.startAsync();
        ctx.start(new GetUserInfo(req, resp, ctx));// czemu nie asyncCtx?

    }


}


package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/panel")
public class PanelServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private PlaceDao placeDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "Panel.ftlh");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("isLoggedIn", req.getSession().getAttribute("userLogged"));

        dataModel.put("districts", placeDao.getDistrictsStatistics());
        dataModel.put("cities", placeDao.getCitiesStatistics());
        dataModel.put("ads", placeDao.getAdsStatistics());

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.INFO, "Template not found", e.getMessage());
            //resp.sendRedirect("/error");
        }
    }
}

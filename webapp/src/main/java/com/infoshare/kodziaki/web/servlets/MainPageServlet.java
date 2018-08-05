package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private PlaceDao placeDao;

    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "MainPage.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("isLoggedIn", request.getSession().getAttribute("userLogged"));
        dataModel.put("isAdminLoggedIn", request.getSession().getAttribute("adminLogged"));

        response.setContentType("text/html;charset=UTF-8");

        try {
            dataModel.put("mostPopularAds", placeDao.getXMostPopularAds());
            dataModel.put("promotedAds", placeDao.getXPromotedAds());
        } catch (Exception e) {
            dataModel.put("message", "Brak wczytanej bazy danych");
        }

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            logger.warning("Template not found ");
        }

    }
}
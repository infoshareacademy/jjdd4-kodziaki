package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(MainPageServlet.class);

    @Inject
    private PlaceDao placeDao;

    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "MainPage.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("mostPopularAds", placeDao.getXMostPopularAds());
        dataModel.put("promotedAds", placeDao.getXPromotedAds());

        response.setContentType("text/html;charset=UTF-8");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
        }

        final String accessToken = (String) SessionUtils.get(request, "accessToken");
        final String idToken = (String) SessionUtils.get(request, "idToken");
        if (accessToken != null) {
            request.setAttribute("userId", accessToken);
        } else if (idToken != null) {
            request.setAttribute("userId", idToken);
        }

        LOG.info("authenticated as id={} accesToken={}", idToken, accessToken);

    }
}
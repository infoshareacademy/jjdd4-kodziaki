package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

        List<Place> allAds = placeDao.getAll();
        Map<String, Long> gdanskStat = allAds
                .stream()
                .filter(p -> p.getCity().equals("Gdansk"))
                .collect(Collectors.groupingBy(Place::getDistrict, Collectors.summingLong(Place::getVisits)));

        Map<String, Long> gdyniaStat = allAds
                .stream()
                .filter(p -> p.getCity().equals("Gdynia"))
                .collect(Collectors.groupingBy(Place::getDistrict, Collectors.summingLong(Place::getVisits)));

        Map<String, Long> sopotStat = allAds
                .stream()
                .filter(p -> p.getCity().equals("Sopot"))
                .collect(Collectors.groupingBy(Place::getDistrict, Collectors.summingLong(Place::getVisits)));

        dataModel.put("ads", allAds);
        dataModel.put("gdanskStat", gdanskStat);
        dataModel.put("gdyniaStat", gdyniaStat);
        dataModel.put("sopotStat", sopotStat);
        dataModel.put("citiesStat", placeDao.getCitiesStatistics());
        dataModel.put("adsStat", placeDao.getAdsStatistics());

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.warning( "Template not found");
            //resp.sendRedirect("/error");
        }
    }
}

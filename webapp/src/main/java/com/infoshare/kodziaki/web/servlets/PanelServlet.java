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

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "Panel.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("isLoggedIn", req.getSession().getAttribute("userLogged"));
        dataModel.put("isAdminLoggedIn", req.getSession().getAttribute("adminLogged"));

        List<Place> allAds = placeDao.getAll();
        dataModel.put("ads", allAds);
        dataModel.put("gdanskStat", getCityStatistics(allAds, "Gdansk"));
        dataModel.put("gdyniaStat", getCityStatistics(allAds, "Gdynia"));
        dataModel.put("sopotStat", getCityStatistics(allAds, "Sopot"));
        dataModel.put("citiesStat", placeDao.getCitiesStatistics());
        dataModel.put("adsStat", placeDao.getAdsStatistics());

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.warning( "Template not found");
        }
    }

    private Map<String, Long> getCityStatistics(List<Place> allAds, String city) {
        return allAds
                .stream()
                .filter(p -> p.getCity().equals(city))
                .collect(Collectors.groupingBy(Place::getDistrict, Collectors.summingLong(Place::getVisits)));
    }
}

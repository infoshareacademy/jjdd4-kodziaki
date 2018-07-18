package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.PlaceType;
import com.infoshare.kodziaki.model.UserPreferences;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search-ads")
public class SearchAdsServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(SearchAdsServlet.class);

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final List<Place> result = placeDao.getAllAds();
        LOG.info("Found {} objects", result.size());

//        resp.setContentType("text/html;charset=UTF-8");
//        for (Place place : result) {
//            resp.getWriter().println(place.toString());
//            resp.getWriter().println("-------------");
//        }

//        Template template = templateProvider.getTemplate(getServletContext(), "search-ads.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("adsList", result);

//        try {
//            template.process(dataModel, resp.getWriter());
//        } catch (TemplateException e) {
//            LOG.info("Template not found", e.getMessage());
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserPreferences userPreferences = new UserPreferences(
                parseToPlaceType(req.getParameter("placeType")),
                req.getParameter("city"),
                req.getParameter("district"),
                parseToBigDecimal(req.getParameter("minPrice")),
                parseToBigDecimal(req.getParameter("maxPrice")),
                parseToDouble(req.getParameter("minArea")),
                parseToDouble(req.getParameter("maxArea")),
                parseToInteger(req.getParameter("minRooms")),
                parseToInteger(req.getParameter("maxRooms")),
                parseToInteger(req.getParameter("minFloor")),
                parseToInteger(req.getParameter("maxFloor")),
                parseToBoolean(req.getParameter("isElevator")),
                parseToBoolean(req.getParameter("smokingAllowed")),
                parseToBoolean(req.getParameter("animalsAllowed")),
                parseToBoolean(req.getParameter("onlyLongTerm"))
        );

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(userPreferences.toString());
//
//        Map<String, Object> dataModel = new HashMap<>();
//        dataModel.put("userPreferences", userPreferences);
//        List<Place> adsList = placeDao.getAdsByUserPreferences(userPreferences);

//        adsList.stream().peek(p -> writer.println(p.getDistrict()));
//        dataModel.put("ads", adsList);

    }

    private Boolean parseToBoolean(String parameter) {
        if (parameter == null) {
            return null;
        }
        return Boolean.valueOf(parameter);
    }

    private Integer parseToInteger(String parameter) {
        if (parameter.isEmpty()) {
            return null;
        }
        return Integer.parseInt(parameter);
    }

    private Double parseToDouble(String parameter) {
        if (parameter.isEmpty()) {
            return null;
        }
        return Double.parseDouble(parameter);
    }

    private BigDecimal parseToBigDecimal(String parameter) {
        if (parameter.isEmpty()) {
            return null;
        }
        return BigDecimal.valueOf(Double.parseDouble(parameter));
    }

    private PlaceType parseToPlaceType(String parameter) {
        if (parameter.equals("all")) {
            return null;
        }
        return PlaceType.valueOf(parameter.toUpperCase());
    }

}

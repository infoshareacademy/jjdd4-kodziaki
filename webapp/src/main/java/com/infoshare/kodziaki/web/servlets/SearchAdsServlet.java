package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.model.PlaceType;
import com.infoshare.kodziaki.model.UserPreferences;
import com.infoshare.kodziaki.web.dao.PlaceDao;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/search-ads")
public class SearchAdsServlet extends HttpServlet {

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        writer.print("siema doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        writer.print("siema doPost");

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
                parseToBoolean(req.getParameter("animalsAllowed")),
                parseToBoolean(req.getParameter("smokingAllowed")),
                parseToBoolean(req.getParameter("isElevator")),
                parseToBoolean(req.getParameter("onlyLongTerm"))
        );

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("userPreferences", userPreferences);
        dataModel.put("ads", placeDao.getAdsFilteredBy(userPreferences));
//        places.stream().map(Place::getId).peek(writer::println);



    }

    private Boolean parseToBoolean(String parameter) {
        if (parameter == null) {
            return null;
        }
        switch (parameter) {
            case "true":
                return true;
            case "false":
                return false;
        }
        return null;
    }

    private Integer parseToInteger(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return Integer.parseInt(parameter);
    }

    private Double parseToDouble(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return Double.parseDouble(parameter);
    }

    private BigDecimal parseToBigDecimal(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return BigDecimal.valueOf(Double.parseDouble(parameter));
    }

    private PlaceType parseToPlaceType(String parameter) {
        if (parameter == null) {
            return null;
        }
        switch (parameter) {
            case "apartment":
                return PlaceType.APARTMENT;
            case "room":
                return PlaceType.ROOM;
            case "bed":
                return PlaceType.BED;
        }
        return null;
    }

}

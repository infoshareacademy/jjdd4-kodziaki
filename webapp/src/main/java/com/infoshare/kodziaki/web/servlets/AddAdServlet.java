package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.PlaceType;
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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add")
public class AddAdServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private PlaceDao placeDao;
    
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "AddAd.ftlh");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.INFO, "Template not found", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        Template template = templateProvider.getTemplate(getServletContext(), "DetailAd.ftlh");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        req.setCharacterEncoding("UTF-8");
        
        try {
            Place place = savePlace(req);
            dataModel.put("ad", place);
        } catch (Exception e) {
            resp.getWriter().println("Wystapił blad: " + e.getMessage());
        }

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.INFO, "Template not found", e.getMessage());
        }
    }

    private Place savePlace(HttpServletRequest req) {
        String titleParam = req.getParameter("title");
        PlaceType placeTypeParam = validatePlaceType(req.getParameter("placeType").toUpperCase());
        BigDecimal priceParam = validateBigDecimal(req.getParameter("price"));
        Double areaParam = validateDouble(req.getParameter("area"));
        Integer roomsParam = validateInteger(req.getParameter("rooms"));
        Integer floorParam = validateInteger(req.getParameter("floor"));
        String districtParam = req.getParameter("district");
        String cityParam = req.getParameter("city");
        Boolean hasElevatorParam = validateBoolean(req.getParameter("hasElevator"));
        Boolean smokingAllowedParam = validateBoolean(req.getParameter("smokingAllowed"));
        Boolean animalAllowedParam = validateBoolean(req.getParameter("animalAllowed"));
        Boolean onlyLongTermParam = validateBoolean(req.getParameter("onlyLongTerm"));
        String descriptionParam = req.getParameter("description");
        String authorParam = req.getParameter("author");
        String phoneNumberParam = req.getParameter("phoneNumber");

        final Place place = new Place();

        place.setId(placeDao.getLastId().intValue() + 1);
        place.setTitle(titleParam);
        place.setPlaceType(placeTypeParam);
        place.setPrice(priceParam);
        place.setArea(areaParam);
        place.setRooms(roomsParam);
        place.setFloor(floorParam);
        place.setDistrict(districtParam);
        place.setCity(cityParam);
        place.setHasElevator(hasElevatorParam);
        place.setSmokingAllowed(smokingAllowedParam);
        place.setAnimalAllowed(animalAllowedParam);
        place.setOnlyLongTerm(onlyLongTermParam);
        place.setDescription(descriptionParam);
        place.setAuthor(authorParam);
        place.setPhoneNumber(phoneNumberParam);

        placeDao.saveAd(place);
        logger.log(Level.INFO, "New place has been added " + place);

        return place;
    }

    private Integer validateInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
        }
    }

    private Boolean validateBoolean(String value) {
        try {
            return Boolean.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
        }
        throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
    }

    private Double validateDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
        }
    }

    private PlaceType validatePlaceType(String value) {
        try {
            return PlaceType.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
        }
    }

    private BigDecimal validateBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
        }
    }

}
